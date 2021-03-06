package demo.wangjq.base.test;


import org.junit.Test;

import java.util.Objects;

public class DSTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Integer.bitCount(123456));
        System.out.println(bitCount(18787846));

        System.out.println(Integer.reverseBytes(123));
    }

    public static void incre() throws InterruptedException {
        int i = 0;
        while (true) {
            Thread.sleep(5000);
            System.out.println(i);
            i++;
        }
    }

    public static int bitCount(int n) {
        int i = 10;
        int bits = 1;
        while (true) {
            //Math.abs(n / i)意思是取n/i的绝对值
            if (Math.abs(n / i) > 0) {
                i *= 10;
                bits++;
            } else {
                return bits;
            }
        }
    }

    @Test
    public void testObjects() {

        System.out.println(Objects.equals(new Byte("1"), new Byte("1")));

    }


}
