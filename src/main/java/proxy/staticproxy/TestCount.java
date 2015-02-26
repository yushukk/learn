package proxy.staticproxy;

/**
 * Created by wandong.cwd on 2014/12/11.
 */
/**
 *≤‚ ‘Count¿‡
 *
 * @author Administrator
 *
 */
public class TestCount {
    public static void main(String[] args) {
        CountImpl countImpl = new CountImpl();
        CountProxy countProxy = new CountProxy(countImpl);
        countProxy.updateCount();
        countProxy.queryCount();
    }
}
