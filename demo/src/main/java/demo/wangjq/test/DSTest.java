package demo.wangjq.test;


public class DSTest {
    public static void main(String[] args) throws InterruptedException {
        incre();
    }

    public static void incre() throws InterruptedException {
        int i = 0;
        while (true) {
            Thread.sleep(5000);
            System.out.println(i);
            i++;
        }
    }

}
