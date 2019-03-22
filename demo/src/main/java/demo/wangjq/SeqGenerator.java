package demo.wangjq;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wangjq on 2018/8/13.
 */
public final class SeqGenerator {

    private static SeqGenerator seqGenerator = new SeqGenerator();

    private SeqGenerator() {
    }


    private static int sequence = 0;

    private static int MAX = 100000;

    private static Long lastTimestamp = -1L;

    private static Lock lock = new ReentrantLock();

    public static String getSeq() {
        lock.lock();
        try {
            //i.getAndIncrement();
            long timestamp = getCurrent();
            //判断是否到达max
            if (sequence == MAX) {
                //判断当前时间戳与上一个时间戳是否一致
                if (lastTimestamp == timestamp) {
                    //获取下一个时间戳
                    timestamp = seqGenerator.tilNextMillis(lastTimestamp);
                }
                sequence = 0;
            } else {
                sequence += 1;
            }
            lastTimestamp = timestamp;
            return timestamp + " " + sequence;
        } finally {
            lock.unlock();
        }
    }

    private static long getCurrent() {
        return System.currentTimeMillis();
    }

    private static Long tilNextMillis(final long lastTimestamp) {
        long timestamp = getCurrent();
        while (timestamp <= lastTimestamp) {
            timestamp = getCurrent();
        }
        return timestamp;
    }

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(1000000);
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        System.out.println("start");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            executorService.submit(() -> {
                System.out.println(SeqGenerator.getSeq());
                //concurrentHashMap.put(seq, o);
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        Long end = System.currentTimeMillis();
        System.out.println(end - start);

        //System.out.println(concurrentHashMap.size());
        //System.out.println(SeqGenerator.i);
    }
}
