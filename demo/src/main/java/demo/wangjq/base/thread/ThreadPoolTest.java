package demo.wangjq.base.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author:wangjq
 * @Date: 2019/5/5 14:12
 */
public class ThreadPoolTest {

    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1));

        /**
         * 验证在corePoolSize满了之后，将之后的task加入到阻塞队列中，阻塞队列满了之后将启动新的线程，直到线程数达到maximumPoolSize
         */
        for (int i = 0; i < 3; i++) {
            final int workId = i;
            threadPoolExecutor.execute(() -> {
                try {
                    System.out.println("work id:" + workId);
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        //System.out.println(threadPoolExecutor.getActiveCount());
    }
}
