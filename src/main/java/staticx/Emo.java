package staticx;

/**
 * Created by ³¾¶« on 2016/3/14.
 */
public class Emo {

    private int size = 1;

    public Emo(int size,String mm) {
        this.size = size;
        System.out.println("init emo "+ mm);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
