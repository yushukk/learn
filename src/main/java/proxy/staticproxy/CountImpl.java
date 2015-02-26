package proxy.staticproxy;

/**
 * Created by wandong.cwd on 2014/12/11.
 */
/**
 * 委托类(包含业务逻辑)
 *
 * @author Administrator
 *
 */
public class CountImpl implements Count {

    @Override
    public void queryCount() {
        System.out.println("查看账户方法...");

    }

    @Override
    public void updateCount() {
        System.out.println("修改账户方法...");

    }

}
