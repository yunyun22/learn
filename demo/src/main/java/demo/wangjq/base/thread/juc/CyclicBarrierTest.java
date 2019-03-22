package demo.wangjq.base.thread.juc;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierTest {

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

        Runnable r = () -> {

            try {
                System.out.println("this thread start wait,having waited threads:"+cyclicBarrier.getNumberWaiting());
                cyclicBarrier.await();
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("this thread end");
        };
        Thread[] ts = new Thread[5];
        for (Thread t : ts) {
            t = new Thread(r);
            t.start();
        }
    }
}
