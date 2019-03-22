package demo.wangjq.base.collection;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangjq on 2018/11/6.
 */
public class SynchronousQueueTest {
    public static void main(String[] args) throws InterruptedException {
        final SynchronousQueue<String> synchronousQueue = new SynchronousQueue();
        Thread t1 = new Thread(() -> {
            synchronousQueue.offer("my name is wangjq");
            System.out.println("the value is already");
        });
        Thread t2 = new Thread(() -> {
            String s = null;
            try {
                System.out.println("come t2");
                s = synchronousQueue.take();
                System.out.println(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("poll the value:" + s);
        });
        t2.start();
        TimeUnit.SECONDS.sleep(2);
        t1.start();
        TimeUnit.SECONDS.sleep(2);
    }
}
