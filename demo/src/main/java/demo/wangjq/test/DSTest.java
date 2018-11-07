package demo.wangjq.test;


public class DSTest {
    public static void main(String[] args) throws InterruptedException {
        //System.out.println(Integer.bitCount(100));
        //System.out.println(bitCount(18787846));
        System.out.println(Integer.toBinaryString(0x55555555));
        System.out.println(Integer.toBinaryString(0x33333333));
        System.out.println(Integer.toBinaryString(0x0f0f0f0f));
        System.out.println(Integer.toBinaryString(0x3f));
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


}
