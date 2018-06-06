package demo.wangjq.thread.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {
    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(5);

        Runnable r = () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("this thread down count");
            countDownLatch.countDown();
        };
        Thread[] ts = new Thread[5];
        for (Thread t : ts) {
            t = new Thread(r);
            t.start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("the main thread is  down");



    }
}
