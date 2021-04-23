package demo.wangjq.base.thread;

import com.google.common.util.concurrent.*;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wang, jinqiao
 * @date 23/04/2021
 */
public class ListenerFutureTaskTest {

    // 创建线程池
    final static ExecutorService SERVICE = Executors.newCachedThreadPool();
    // 创建线程池
    final static ListeningExecutorService LISTENING_EXECUTOR_SERVICE = MoreExecutors.listeningDecorator(SERVICE);

    public static void main(String[] args) {
        ListenableFuture<Boolean> future = LISTENING_EXECUTOR_SERVICE.submit(() -> true);

        Futures.addCallback(future, new FutureCallback<Boolean>() {

            @Override
            public void onSuccess(@Nullable Boolean result) {
                System.out.println("Finish task BooleanTask: " + result);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        }, LISTENING_EXECUTOR_SERVICE);
        System.out.println("我是不会阻塞的");
    }
}
