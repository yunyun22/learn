package learn.wangjq.thread;

import java.util.concurrent.*;

public class ThreadTest {
    public static void main(String[] args) {

        MyRejectedExecutionHandler myRejectedExecutionHandler = new MyRejectedExecutionHandler();

        ThreadPoolExecutor ThreadPoolExecutor =
                new ThreadPoolExecutor(0, 5, 0L
                        , TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(1), myRejectedExecutionHandler);

        for (int i = 0; i < 10; i++) {
            System.out.println("已经生产的记录条数 = " + i);
            ThreadPoolExecutor.execute(() -> {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("消费了一条记录");
            });
        }
        ThreadPoolExecutor.getActiveCount();

    }
}

class MyRejectedExecutionHandler implements RejectedExecutionHandler {

    public MyRejectedExecutionHandler() {
    }

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        try {
            executor.getQueue().put(r);
        } catch (InterruptedException e) {
            r.run();
            e.printStackTrace();
            throw new RuntimeException("The thread is interrupted");
        }
    }
}
