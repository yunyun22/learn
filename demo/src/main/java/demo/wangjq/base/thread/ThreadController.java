package demo.wangjq.base.thread;

/**
 * @author wangjq
 */
public class ThreadController {
    static Boolean status = Boolean.TRUE;

    public static void main(String[] args) {

        char[] numbers = {'1', '2', '3', '4', '5', '6'};
        char[] chars = {'A', 'B', 'C', 'D', 'E', 'F'};
        Object lock = new Object();
        Thread t1 = new Thread(new NumberRunnable(numbers, lock));
        Thread t2 = new Thread(new CharRunnable(chars, lock));
        t1.start();
        t2.start();

    }


    static class NumberRunnable implements Runnable {

        private char[] resource;
        private Object lock;

        public NumberRunnable(char[] resource, Object lock) {
            this.resource = resource;
            this.lock = lock;
        }

        @Override
        public void run() {
            try {
                int i = 0;
                synchronized (lock) {
                    while (i < resource.length) {
                        if (!status) {
                            System.out.print(resource[i++]);
                        }
                        status = true;
                        lock.notify();
                        lock.wait();
                    }
                    lock.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class CharRunnable implements Runnable {
        private char[] resource;
        private Object lock;

        public CharRunnable(char[] resource, Object lock) {
            this.resource = resource;
            this.lock = lock;
        }

        @Override
        public void run() {
            try {
                int i = 0;
                synchronized (lock) {
                    while (i < resource.length) {
                        if (status) {
                            System.out.print(resource[i++]);
                        }
                        status = false;
                        lock.notify();
                        lock.wait();
                    }
                    lock.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
