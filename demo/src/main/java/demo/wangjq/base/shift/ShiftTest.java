package demo.wangjq.base.shift;

/**
 * @author wangjq
 */
public class ShiftTest {
    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY = (1 << COUNT_BITS) - 1;

    private static final int RUNNING = -1 << COUNT_BITS;
    private static final int SHUTDOWN = 0 << COUNT_BITS;
    private static final int STOP = 1 << COUNT_BITS;
    private static final int TIDYING = 2 << COUNT_BITS;
    private static final int TERMINATED = 3 << COUNT_BITS;

    public static void main(String[] args) {
        System.out.println("CAPACITY:" + Integer.toBinaryString(CAPACITY).length());
        System.out.println("-1:" + Integer.toBinaryString(-1));
        System.out.println("RUNNING:" + Integer.toBinaryString(-1 << COUNT_BITS));
        System.out.println("SHUTDOWN:" + Integer.toBinaryString(SHUTDOWN));
        System.out.println("STOP:" + Integer.toBinaryString(STOP));
        System.out.println("TIDYING:" + Integer.toBinaryString(TIDYING));
        System.out.println("TERMINATED:" + Integer.toBinaryString(TERMINATED));
    }
}
