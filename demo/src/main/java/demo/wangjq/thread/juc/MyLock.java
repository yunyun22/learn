package demo.wangjq.thread.juc;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MyLock implements Lock, java.io.Serializable {

    private final Sync sync;

    public MyLock(Integer count) {
        this.sync = new Sync(count);
    }

    @Override
    public void lock() {

        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        long milliSeconds = unit.toMillis(time);

        long current = new Date().getTime();

        long endTime = current + milliSeconds;
        while (endTime > current) {
            sync.acquire(1);
            current = new Date().getTime();
        }
        return false;
    }

    @Override
    public void unlock() {
        sync.tryRelease(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }

    private static class Sync extends AbstractQueuedSynchronizer {

        private Integer count;

        protected Sync(Integer count) {
            this.count = count;
        }

        @Override
        protected boolean tryAcquire(int arg) {
            int state = getState();
            if (state < count) {

            }
            return super.tryAcquire(arg);
        }

        @Override
        protected boolean tryRelease(int arg) {
            return super.tryRelease(arg);
        }

        @Override
        protected int tryAcquireShared(int arg) {
            return super.tryAcquireShared(arg);
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            return super.tryReleaseShared(arg);
        }

        @Override
        protected boolean isHeldExclusively() {
            return super.isHeldExclusively();
        }
    }


}
