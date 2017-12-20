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
 * Author:  dbsync_tt技术支持
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
         * 构建input
         */
        private void createInput() {
            try {
                // 先销毁后创建
                if (this.input != null) {
                    this.input.close();
                }

                /**
                 * 指定订阅开始时间方式
                 * long ts = System.currentTimeMillis() / 1000;
                 * this.input = new TTLogSimpleInput(this.ttLog, ts, new int[]{this.queueIndex});
                 */
                this.input = new TTLogSimpleInput(this.ttLog, new int[]{this.queueIndex});
            } catch (TTQueueException e) {
                LOG.error("new TTLogSimpleInput failed", e);
                // TODO:初始化失败自行处理,可以循环重试
            }
        }

        private void sleep(long milliSeconds) {
            try {
                TimeUnit.MILLISECONDS.sleep(milliSeconds);
            } catch (InterruptedException e) {
                // TODO:请自行处理异常
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
                     * 触发条件：
                     * 1. 发生网络异常，或者TT服务端容灾切换
                     * 2. TT降级，禁止读取
                     */
                    sleep(1000);
                    createInput();
                } catch (TTQueueSafemodeException e) {
                    LOG.warn("input enter safe mode", e);
                    /**
                     * 触发条件：
                     * 1. offset更新失败，通常情况是服务端开启了safe mode模式，可重试
                     * 2. 多个客户端读同一个queue，会相互踢掉，需要保证任何时刻只有一个client订阅
                     */
                    sleep(1000);
                } catch (TTSubChangedException e) {
                    /**
                     * 触发条件：
                     * 在页面设置了订阅点位后，会抛出该异常
                     */
                    LOG.warn("input sub changed");
                    createInput();
                }
                if (block == null) {
                    /**
                     * block读到null，表示已经没有新数据了
                     */
                    sleep(1000);
                    continue;
                }
                try {
                    this.buffer.put(block);
                } catch (InterruptedException e) {
                    // TODO:中断异常自行处理
                }
            }
        }
    }

    public static void main(String[] args) throws TTQueueException {
        // 日志的名字
        String topic = "godeyes_tm_ad_exposure";
        // 订阅ID
        String subId = "07241450225RFCQAQ1";
        // 订阅详情列表里的访问key，不是日志的accessKey！
        String accessKey = "f12598e1-5c1f-4f7c-9472-86969bce11a4";
        // 构建TTLog过程会访问TT的http服务
        TTLog ttLog = new TTLogImpl(topic, subId, accessKey);
        int queueNumber = ttLog.getQueueNumber();

        // 并发读取缓冲区
        BlockingQueue<TTLogBlock> bufferQueue = new LinkedBlockingQueue<TTLogBlock>(16);
        for (int i = 0; i < queueNumber; i++) {
            new Thread(new Reader(ttLog, i, bufferQueue), String.format("queue-%s", i)).start();
        }

        // 消费逻辑，如果数据量较大，建议开多个线程并发消费bufferQueue
        TTLogBlock block;
        while (true) {
            try {
                block = bufferQueue.take();
            } catch (InterruptedException e) {
                // TODO:自行处理中断
                break;
            }
            byte[] data = block.getBuffer();

            if (data != null) {
                /**
                 * data的几种可能:
                 * 1. null：空包
                 * 2. 空字符串：心跳包，用户写入的空包，用于在没有数据时驱动offset移动
                 * 3. 正常的byte数组
                 */
                System.out.println(new String(block.getBuffer()));
            }
            /**
             * 处理完成后，调用ack，每一个block都需要ack
             */
            block.getKey().ack();
        }
    }
}