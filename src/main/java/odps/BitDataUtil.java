package odps;

public class BitDataUtil {

    /**
     * 写
     *
     * @param bitSrc ：源数据
     * @param index  ：数据位
     * @param value  ：true则置1，否则置0,防止使用非01数据
     */
    public static long set(long bitSrc, int index, boolean value) {
        if (index < 0) {
            throw new IllegalArgumentException("index is less than 0");
        }
        int bitv = 1 << index;
        if (value) {
            bitSrc |= bitv;
        } else {
            bitSrc &= ~bitv;
        }
        return bitSrc;
    }

    /**
     * 读
     *
     * @param bitSrc ：源数据
     * @param index  ：数据位
     * @return boolean:是1返回true，0返回false
     */
    public static boolean get(long bitSrc, int index) {
        if (index < 0) {
            throw new IllegalArgumentException("index is less than 0");
        }
        return (bitSrc & (1 << index)) > 0 ? true : false;
    }


    public static void main(String arg[]) {
        boolean test = get(6291460, 22);

        System.out.println("test:" + test);

    }
}
