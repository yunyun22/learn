package demo.wangjq.base.thread;

/**
 * @author wangjq
 */
public class ThreadController {
    public static void main(String[] args) {

        char[] numbers = {'1', '2', '3', '4', '5', '6'};
        char[] chars = {'A', 'B', 'C', 'D', 'E', 'F'};
        Boolean lock = Boolean.FALSE;

        Thread t1 = new Thread(new NumberRunnable(numbers, lock));
        Thread t2 = new Thread(new CharRunnable(chars, lock));
        t1.start();
        t2.start();

    }


    static class NumberRunnable implements Runnable {

        private char[] resource;
        private Boolean lock;

        public NumberRunnable(char[] resource, Boolean lock) {
            this.resource = resource;
            this.lock = lock;
        }

        @Override
        public void run() {
            try {
                int i = 0;
                synchronized (lock) {
                    while (i < resource.length) {
                        if (!lock) {
                            System.out.print(resource[i++]);
                        }
                        lock = true;
                        lock.wait();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class CharRunnable implements Runnable {
        private char[] resource;
        private Boolean lock;

        public CharRunnable(char[] resource, Boolean lock) {
            this.resource = resource;
            this.lock = lock;
        }

        @Override
        public void run() {
            try {
                int i = 0;
                synchronized (lock) {
                    while (i < resource.length) {
                        if (this.lock) {
                            System.out.print(resource[i++]);
                        }
                        lock = false;
                        lock.notify();
                        lock.wait();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
