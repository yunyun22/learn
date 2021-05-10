package demo.wangjq.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.concurrent.TimeUnit;

/**
 * @author wang, jinqiao
 * @date 10/05/2021
 */
public class InterprocessLock {
    public static void main(String[] args) throws InterruptedException {

        CuratorFramework zkClient = getZkClient();
        String lockPath = "/lock";
        InterProcessMutex lock = new InterProcessMutex(zkClient, lockPath);
        Thread[] threads = new Thread[50];
        //模拟50个线程抢锁
        for (int i = 0; i < 50; i++) {
            Thread thread = new Thread(new TestThread(i, lock));
            threads[i] = thread;
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(ShareInt.i);
    }

    static class ShareInt {

        static int i = 0;
    }

    static class TestThread implements Runnable {
        private final Integer threadFlag;
        private final InterProcessMutex lock;


        public TestThread(Integer threadFlag, InterProcessMutex lock) {
            this.threadFlag = threadFlag;
            this.lock = lock;
        }

        @Override
        public void run() {
            try {
                TimeUnit.MILLISECONDS.sleep(10);
                lock.acquire();
                //等到1秒后释放锁
                for (int i = 0; i < 10000; i++) {
                    ShareInt.i++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    lock.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static CuratorFramework getZkClient() {
        String zkServerAddress = "localhost:2181";
        ExponentialBackoffRetry retryPolicy = new ExponentialBackoffRetry(1000, 3, 5000);
        CuratorFramework zkClient = CuratorFrameworkFactory.builder()
                .connectString(zkServerAddress)
                .sessionTimeoutMs(5000)
                .connectionTimeoutMs(5000)
                .retryPolicy(retryPolicy)
                .build();
        zkClient.start();
        return zkClient;
    }
}
