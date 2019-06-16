package demo.wangjq.base.thread.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author wangjq
 */
public class CountDownLatchTest {
    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(6);

        Runnable r = () -> {
            try {
                countDownLatch.await();
                System.out.println("Im the player:" + Thread.currentThread().getId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        };
        Thread[] ts = new Thread[6];
        for (Thread t : ts) {
            t = new Thread(r);
            t.start();
            countDownLatch.countDown();
            System.out.println("the player:" + t.getId() + " is already");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("the main thread is  down");


    }
}
