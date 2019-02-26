package demo.wangjq.base.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wangjq on 2018/9/12.
 */
public class LockTest {

    public static void main(String[] args) {

        Lock lock = new ReentrantLock();


        //ReentrantLock.lock()-> Sync.lock()->NonfairSync.lock()
        //ReentrantLock has a Sync
        //Sync extend AbstractQueuedSynchronizer
        //NonfairSync extend Sync

        new Thread(() -> {
            try {
                lock.lock();
                while (true)
                    System.out.println("I am aquire the lock,others go away.");
            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                lock.lock();
                System.out.println("please,please.give it me");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                lock.lock();
                lock.lock();
                System.out.println("fuck,fuck.son of bitch");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                lock.unlock();
            }


        }).start();


    }
}
