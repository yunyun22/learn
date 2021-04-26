package demo.wangjq;

/**
 * @author:wangjq
 * @Date: 2019/5/13 10:41
 */
public class Test {


    public void test() {
    }


    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= Integer.MAX_VALUE) ? Integer.MAX_VALUE : n + 1;
    }

    public static void main(String[] args) {
        int i = tableSizeFor(3);
        System.out.println(3);
    }

}
