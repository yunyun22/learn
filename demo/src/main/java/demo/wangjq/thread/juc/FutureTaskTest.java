package demo.wangjq.thread.juc;

import java.util.Timer;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by AMD on 2018/6/6.
 */
public class FutureTaskTest {

    public static void main(String[] args) {

        FutureTask<String> futureTask = new FutureTask<>(() -> {

            TimeUnit.SECONDS.sleep(10);
            return "wangjq";
        });

        futureTask.run();


        Runnable runnable = () -> {
            try {
                System.out.println(futureTask.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        };


        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }


    }


}
