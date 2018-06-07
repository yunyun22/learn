package demo.wangjq.algorithm.list;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by AMD on 2018/6/7.
 */
public class DelayedQueueTest {


    public static void main(String[] args) {

        DelayQueue delayQueue = new DelayQueue();


        delayQueue.offer(new MyDelayed(10000, "w1"));
        delayQueue.offer(new MyDelayed(20000, "w2"));
        delayQueue.offer(new MyDelayed(30000, "w3"));
        delayQueue.offer(new MyDelayed(40000, "w4"));


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy/MM/dd HH:mm");

        Date start = new Date();

        Delayed element = null;
        try {
            while (!delayQueue.isEmpty()) {
                element = delayQueue.take();
                System.out.println(element.toString() + " , start:" + simpleDateFormat.format(start) + ", current:" + simpleDateFormat.format(new Date()));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


}


class MyDelayed implements Delayed {

    private final long delayTime; //延迟时间
    private final long expire;  //到期时间
    private String data;   //数据

    public MyDelayed(long delay, String data) {
        delayTime = delay;
        this.data = data;
        expire = System.currentTimeMillis() + delay;
    }


    public long getDelayTime() {
        return delayTime;
    }

    public long getExpire() {
        return expire;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.expire - System.currentTimeMillis(), TimeUnit.MICROSECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return (int) (this.getDelay(TimeUnit.MICROSECONDS) - o.getDelay(TimeUnit.MICROSECONDS));
    }


    @Override
    public String toString() {
        return "MyDelayed{" +
                "delayTime=" + delayTime +
                ", expire=" + expire +
                ", data='" + data + '\'' +
                '}';
    }


}
