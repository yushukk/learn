package proxy.staticproxy;

/**
 * Created by wandong.cwd on 2014/12/11.
 */
public class CountProxy implements Count {
    private CountImpl countImpl;

    /**
     * ����Ĭ�Ϲ�����
     *
     * @param countImpl
     */
    public CountProxy(CountImpl countImpl) {
        this.countImpl = countImpl;
    }

    @Override
    public void queryCount() {
        System.out.println("������֮ǰ");
        // ����ί����ķ���;
        countImpl.queryCount();
        System.out.println("������֮��");
    }

    @Override
    public void updateCount() {
        System.out.println("������֮ǰ");
        // ����ί����ķ���;
        countImpl.updateCount();
        System.out.println("������֮��");

    }

}
