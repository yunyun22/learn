package demo.wangjq.base.thread;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by AMD on 2018/6/7.
 */
public class ScheduledThreadPoolExecutorTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(5);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println("current date:" + simpleDateFormat.format(new Date()));

        for (int i = 10; i > 0; i--) {
            int taskId = i;
            ScheduledFuture<?> schedule = scheduledThreadPoolExecutor.schedule(() -> {
                        try {
                            System.out.println("execute date:" + LocalDateTime.now() + ",task id:" + taskId);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    , 5L * i, TimeUnit.SECONDS);
            Object o = schedule.get();
        }
    }

}
