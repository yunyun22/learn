package demo.wangjq.base.collection;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

import demo.wangjq.app.time.DateTimeUtils;

/**
 * Created by wangjq on 2018/11/6.
 */
public class QueueTest {
    public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");


        DelayQueue<DelayElement> queue = new DelayQueue();
        queue.put(new DelayElement("task1", DateTimeUtils.getDateTimeOfTimestamp(System.currentTimeMillis() + 11000)));
        queue.put(new DelayElement("task2", DateTimeUtils.getDateTimeOfTimestamp(System.currentTimeMillis() + 13000)));
        queue.put(new DelayElement("task3", DateTimeUtils.getDateTimeOfTimestamp(System.currentTimeMillis() + 15000)));
        queue.put(new DelayElement("task4", DateTimeUtils.getDateTimeOfTimestamp(System.currentTimeMillis() + 17000)));
        queue.put(new DelayElement("task5", DateTimeUtils.getDateTimeOfTimestamp(System.currentTimeMillis() + 19000)));
        queue.put(new DelayElement("task6", DateTimeUtils.getDateTimeOfTimestamp(System.currentTimeMillis() + 21000)));


        while (!queue.isEmpty()) {
            try {
                DelayElement task = queue.take();
                System.out.println(task.name + ":" + System.currentTimeMillis());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    static class DelayElement implements Delayed {

        private String name;
        private LocalDateTime exeTimeStamp;

        public DelayElement(String name, LocalDateTime exeTimeStamp) {
            this.name = name;
            this.exeTimeStamp = exeTimeStamp;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return exeTimeStamp.toInstant(ZoneOffset.of("+8")).toEpochMilli() - System.currentTimeMillis();
        }

        @Override
        public int compareTo(Delayed o) {
            long l = this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS);
            return l == 0 ? 0 : (l > 0 ? 1 : -1);
        }

        @Override
        public String toString() {
            return "DelayElement{" +
                    "name='" + name + '\'' +
                    ", exeTimeStamp=" + exeTimeStamp +
                    '}';
        }
    }

}


