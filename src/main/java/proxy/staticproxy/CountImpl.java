package proxy.staticproxy;

/**
 * Created by wandong.cwd on 2014/12/11.
 */
/**
 * ί����(����ҵ���߼�)
 *
 * @author Administrator
 *
 */
public class CountImpl implements Count {

    @Override
    public void queryCount() {
        System.out.println("�鿴�˻�����...");

    }

    @Override
    public void updateCount() {
        System.out.println("�޸��˻�����...");

    }

}
