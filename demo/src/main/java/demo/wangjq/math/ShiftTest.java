package demo.wangjq.math;

/**
 * 32位,前三位表示线程池的工作状态,后29表示线程的capactity
 */
public class ShiftTest {

    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int RUNNING = -1 << COUNT_BITS;
    private static final int SHUTDOWN = 0 << COUNT_BITS;
    private static final int STOP = 1 << COUNT_BITS;
    private static final int TIDYING = 2 << COUNT_BITS;
    private static final int TERMINATED = 3 << COUNT_BITS;

    private static final int CAPACITY = (1 << COUNT_BITS) - 1;


    /**
     * ~CAPACITY :11100000000000000000000000000000
     *
     * @param c
     * @return
     */
    private static int runStateOf(int c) {
        return c & ~CAPACITY;
    }

    private static int workerCountOf(int c) {
        return c & CAPACITY;
    }

    private static int ctlOf(int rs, int wc) {
        return rs | wc;
    }

    public static void main(String[] args) {


        int x = 0;
        int y = 0;


//        String capacityString = Integer.toBinaryString(~CAPACITY);
//        System.out.println("~CAPACITY:" + capacityString);
//        System.out.println("~CAPACITY length:" + capacityString.length());


//        //CAPACITY:11111111111111111111111111111(29)
//        String capacityString = Integer.toBinaryString(CAPACITY);
//        System.out.println("CAPACITY:" + capacityString);
//        System.out.println("CAPACITY length:" + capacityString.length());
//
//        //RUNNING:11100000000000000000000000000000(32)
//        String runString = Integer.toBinaryString(RUNNING);
//        System.out.println("RUNNING:" + runString);
//        System.out.println("RUNNING length:" + runString.length());
//
//        //SHUTDOWN:0(32)
//        String shutdownString = Integer.toBinaryString(SHUTDOWN);
//        System.out.println("SHUTDOWN:" + shutdownString);
//        System.out.println("SHUTDOWN length:" + shutdownString.length());
//
//        //STOP:100000000000000000000000000000(30)
//        String stopString = Integer.toBinaryString(STOP);
//        System.out.println("STOP:" + stopString);
//        System.out.println("STOP length:" + stopString.length());
//
//        //TIDYING:1000000000000000000000000000000(31)
//        String tidyingString = Integer.toBinaryString(TIDYING);
//        System.out.println("TIDYING:" + tidyingString);
//        System.out.println("TIDYING length:" + tidyingString.length());
//
//        //TERMINATED:1100000000000000000000000000000(31)
//        String terminated = Integer.toBinaryString(TERMINATED);
//        System.out.println("TERMINATED:" + terminated);
//        System.out.println("TERMINATED length:" + terminated.length());
//
//
//        //MINUS1:11111111111111111111111111111111(32)
//        String minusOne = Integer.toBinaryString(-1);
//        System.out.println("MINUS1:" + minusOne);
//        System.out.println("MINUS1 length:" + minusOne.length());


    }
}
