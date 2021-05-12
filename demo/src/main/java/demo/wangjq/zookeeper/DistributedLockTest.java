package demo.wangjq.zookeeper;

import java.util.concurrent.locks.Lock;

/**
 * @author https://www.cnblogs.com/jing99/p/11607094.html
 * @date 12/05/2021
 */
public class DistributedLockTest {
    //100张票
    private Integer n = 1000;

    public void printInfo() {
        System.out.println(Thread.currentThread().getName() +
                "正在运行,剩余余票:" + --n);
    }

    public class TicketThread implements Runnable {
        @Override
        public void run() {
            Lock lock = new DistributedLock("localhost:2181", "zk");
            while (true) {
                lock.lock();
                try {
                    if (n > 0) {
                        printInfo();
                    } else {
                        return;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public void ticketStart() {
        TicketThread thread = new TicketThread();
        for (int i = 0; i < 30; i++) {
            Thread t = new Thread(thread, "mem" + i);
            t.start();
        }
    }

    public static void main(String[] args) {
        new DistributedLockTest().ticketStart();
    }
}
