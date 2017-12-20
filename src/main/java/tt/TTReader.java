package tt;

import com.alibaba.tt.exception.TTQueueException;
import com.alibaba.tt.exception.TTQueueSafemodeException;
import com.alibaba.tt.exception.TTSubChangedException;
import com.alibaba.tt.log.TTLog;
import com.alibaba.tt.log.TTLogInput;
import com.alibaba.tt.log.impl.TTLogBlock;
import com.alibaba.tt.log.impl.TTLogImpl;
import com.alibaba.tt.log.impl.TTLogSimpleInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Author:  dbsync_tt����֧��
 */
public class TTReader {
    private static final Logger LOG = LoggerFactory.getLogger(TTReader.class);

    static class Reader implements Runnable {
        private final TTLog ttLog;
        private final BlockingQueue<TTLogBlock> buffer;
        private final int queueIndex;
        private TTLogInput input;

        public Reader(TTLog ttLog, int queueIndex, BlockingQueue<TTLogBlock> buffer) {
            assert (ttLog != null && queueIndex >= 0 && buffer != null);
            this.ttLog = ttLog;
            this.queueIndex = queueIndex;
            this.buffer = buffer;
        }

        /**
         * ����input
         */
        private void createInput() {
            try {
                // �����ٺ󴴽�
                if (this.input != null) {
                    this.input.close();
                }

                /**
                 * ָ�����Ŀ�ʼʱ�䷽ʽ
                 * long ts = System.currentTimeMillis() / 1000;
                 * this.input = new TTLogSimpleInput(this.ttLog, ts, new int[]{this.queueIndex});
                 */
                this.input = new TTLogSimpleInput(this.ttLog, new int[]{this.queueIndex});
            } catch (TTQueueException e) {
                LOG.error("new TTLogSimpleInput failed", e);
                // TODO:��ʼ��ʧ�����д���,����ѭ������
            }
        }

        private void sleep(long milliSeconds) {
            try {
                TimeUnit.MILLISECONDS.sleep(milliSeconds);
            } catch (InterruptedException e) {
                // TODO:�����д����쳣
            }
        }

        public void run() {

            createInput();
            TTLogBlock block = null;
            while (true) {
                try {
                    block = this.input.read();
                } catch (TTQueueException e) {
                    LOG.error("input read failed", e);
                    /**
                     * ����������
                     * 1. ���������쳣������TT����������л�
                     * 2. TT��������ֹ��ȡ
                     */
                    sleep(1000);
                    createInput();
                } catch (TTQueueSafemodeException e) {
                    LOG.warn("input enter safe mode", e);
                    /**
                     * ����������
                     * 1. offset����ʧ�ܣ�ͨ������Ƿ���˿�����safe modeģʽ��������
                     * 2. ����ͻ��˶�ͬһ��queue�����໥�ߵ�����Ҫ��֤�κ�ʱ��ֻ��һ��client����
                     */
                    sleep(1000);
                } catch (TTSubChangedException e) {
                    /**
                     * ����������
                     * ��ҳ�������˶��ĵ�λ�󣬻��׳����쳣
                     */
                    LOG.warn("input sub changed");
                    createInput();
                }
                if (block == null) {
                    /**
                     * block����null����ʾ�Ѿ�û����������
                     */
                    sleep(1000);
                    continue;
                }
                try {
                    this.buffer.put(block);
                } catch (InterruptedException e) {
                    // TODO:�ж��쳣���д���
                }
            }
        }
    }

    public static void main(String[] args) throws TTQueueException {
        // ��־������
        String topic = "godeyes_tm_ad_exposure";
        // ����ID
        String subId = "07241450225RFCQAQ1";
        // ���������б���ķ���key��������־��accessKey��
        String accessKey = "f12598e1-5c1f-4f7c-9472-86969bce11a4";
        // ����TTLog���̻����TT��http����
        TTLog ttLog = new TTLogImpl(topic, subId, accessKey);
        int queueNumber = ttLog.getQueueNumber();

        // ������ȡ������
        BlockingQueue<TTLogBlock> bufferQueue = new LinkedBlockingQueue<TTLogBlock>(16);
        for (int i = 0; i < queueNumber; i++) {
            new Thread(new Reader(ttLog, i, bufferQueue), String.format("queue-%s", i)).start();
        }

        // �����߼�������������ϴ󣬽��鿪����̲߳�������bufferQueue
        TTLogBlock block;
        while (true) {
            try {
                block = bufferQueue.take();
            } catch (InterruptedException e) {
                // TODO:���д����ж�
                break;
            }
            byte[] data = block.getBuffer();

            if (data != null) {
                /**
                 * data�ļ��ֿ���:
                 * 1. null���հ�
                 * 2. ���ַ��������������û�д��Ŀհ���������û������ʱ����offset�ƶ�
                 * 3. ������byte����
                 */
                System.out.println(new String(block.getBuffer()));
            }
            /**
             * ������ɺ󣬵���ack��ÿһ��block����Ҫack
             */
            block.getKey().ack();
        }
    }
}