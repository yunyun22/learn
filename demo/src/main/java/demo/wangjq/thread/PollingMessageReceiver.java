package demo.wangjq.thread;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by AMD on 2018/6/7.
 */
public class PollingMessageReceiver {


    public static void main(String[] args) {

        BlockingQueue<String> queue = new LinkedBlockingQueue<>();


        Random random = new Random();


        new Thread(() -> {
            while (true) {
                try {
                    for (int i = 0; i < 2; i++) {
                        //queue.put("message" + new Date().getTime());
                    }
                    Thread.sleep(random.nextInt(5000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        PollingMessageReceiver pollingMessageReceiver = new PollingMessageReceiver(queue, "test1");

        Runnable r = () -> {
            while (true) {
                String message = pollingMessageReceiver.receiveMessage();
                System.out.println(Thread.currentThread().getName() + " get " + message);
            }
        };


        for (int i = 0; i < 5; i++) {
            new Thread(r, "thread" + i).start();
        }


    }

    private static final int WAIT_SECONDS = 30;

    // if there are too many queues, a clear method could be involved after deleting the queue
    private static final Map<String, Object> LOCK_OBJECT_MAP = new HashMap<>();
    private static Map<String, Boolean> QUEUE_POLLING_MAP = new ConcurrentHashMap<>();

    private Object lockObj;
    private String queueName;
    private Queue<String> queue;


    public  PollingMessageReceiver(BlockingQueue<String> queue, String queueName) {
        this.queue = queue;
        this.queueName = queueName;

        synchronized (LOCK_OBJECT_MAP) {
            lockObj = LOCK_OBJECT_MAP.get(this.queueName);
            if (lockObj == null) {
                lockObj = new Object();
                LOCK_OBJECT_MAP.put(this.queueName, lockObj);
            }
        }
    }

    boolean setPolling() {
        synchronized (lockObj) {
            Boolean ret = QUEUE_POLLING_MAP.get(queueName);
            if (ret == null || !ret) {
                QUEUE_POLLING_MAP.put(queueName, true);
                return true;
            }
            return false;
        }
    }

    void clearPolling() {
        synchronized (lockObj) {
            QUEUE_POLLING_MAP.put(queueName, false);
            lockObj.notifyAll();
        }
    }


    public String receiveMessage() {
        boolean polling = false;
        while (true) {
            synchronized (lockObj) {
                Boolean state = QUEUE_POLLING_MAP.get(queueName);
                if (state != null && state) {
                    try {
                        polling = false;
                        System.out.println(Thread.currentThread().getName() + " wait");
                        lockObj.wait();
                    } catch (InterruptedException e) {
                        return null;
                    }
                }
            }

            try {
                String message = null;
                if (!polling) {
                    try {
                        message = queue.poll();
                    } catch (Exception e) {
                    }
                    if (message == null) {
                        polling = true;
                        continue;
                    }
                } else {
                    // 设置长轮询失败,取消当前长轮询尝试
                    if (!setPolling()) {
                        continue;
                    }
                    do {
                        try {

                            message = queue.poll();
                            System.out.println(Thread.currentThread().getName() + " get meessage:" + message);
                        } catch (Exception e) {
                            // 抛出异常前清除polling状态,避免其他线程无法被唤醒
                            clearPolling();
                            // 继续往外抛出异常,避免无法进入外部close监测,造成死循环
                            throw e;
                        }
                    } while (message == null);
                    clearPolling();
                }
                return message;
            } catch (Exception e) {
                // 捕捉异常后,返回null,避免死循环
                return null;
            }
        }
    }
}
