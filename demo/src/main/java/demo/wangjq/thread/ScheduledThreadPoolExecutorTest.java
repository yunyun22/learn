package demo.wangjq.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by AMD on 2018/6/7.
 */
public class ScheduledThreadPoolExecutorTest {

    public static void main(String[] args) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(5);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println("current date:" + simpleDateFormat.format(new Date()));

//        scheduledThreadPoolExecutor.schedule(() -> {
//            System.out.println("execute date:" + simpleDateFormat.format(new Date()));
//        }, 5, TimeUnit.SECONDS);

        scheduledThreadPoolExecutor.scheduleAtFixedRate(() ->
                        System.out.println("execute date:" + simpleDateFormat.format(new Date()))
                , 5, 5, TimeUnit.SECONDS);
    }

}
