package demo.wangjq.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

public class CruniiTest {

    public static void main(String[] args) {

        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(20);

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(8, 8, 10L, TimeUnit.SECONDS, workQueue);


        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        for (int i = 0; i < 100; i++) {
            poolExecutor.execute(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                    System.out.println("this thread name:" + Thread.currentThread().getName() + ",time" + format.format(new Date()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

        }
        poolExecutor.shutdown();


    }
}

class MyRejectedExecution implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        try {

            System.out.println("use the reject");

            executor.getQueue().put(r);

            System.out.println("the task wait end");

        } catch (InterruptedException e) {
            r.run();
            e.printStackTrace();
            throw new RuntimeException("The thread is interrupted");
        }
    }
}
