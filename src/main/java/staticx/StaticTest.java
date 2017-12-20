package staticx;

/**
 * Created by ³¾¶« on 2016/3/14.
 */
public class StaticTest {


    static {
        emo = new Emo(1,"bf1");
    }

    static Emo emo = new Emo(1,"bl1");

    public static void main(String[] args) {
        StaticTest test = new StaticTest();
        test.changevalue(emo);
        System.out.println(emo.getSize());
    }

    private  void changevalue(Emo emo){
        emo = new Emo(6,"change13");
    }
}
