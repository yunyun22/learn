package demo.wangjq.base.thread.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author wangjq
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        Runnable r = () -> {
            try {
                semaphore.acquire();
                System.out.println("this thread waited,current time:" + System.currentTimeMillis());
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }

        };
        Thread[] ts = new Thread[50];
        for (Thread t : ts) {
            t = new Thread(r);
            t.start();
        }
    }
}
