package demo.wangjq.base.math;

/**
 * @author wang, jinqiao
 * @title: BinaryTest
 * @date 06/04/2021
 */
public class BinaryTest {

    public static void main(String[] args) {

        System.out.println(tAddOk(-3, Integer.MAX_VALUE - 2));

        System.out.println(-Integer.MIN_VALUE);

        System.out.println(tSubOk(1, Integer.MIN_VALUE));

        System.out.println(0 - Integer.MIN_VALUE);
    }


    public static int overflow() {

        int max = Integer.MAX_VALUE;

        return max + 1;

    }


//    public static boolean tAddOk(int x, int y) {
//
//        int sum = x + y;
//
//        return (sum - x == y) && (sum - y == x);
//
//    }


    public static boolean tSubOk(int x, int y) {
        // 如果y为最小的情况，-y不会变成正整数，会导致数据异常
        if (y == Integer.MIN_VALUE && x >= 0) {
            return false;
        }
        return tAddOk(x, -y);
    }

    public static boolean tAddOk(int x, int y) {

        if (x > 0 && y > 0) {

            return x + y > 0;

        }
        if (x < 0 && y < 0) {

            return x + y < 0;

        }
        return true;
    }


}
