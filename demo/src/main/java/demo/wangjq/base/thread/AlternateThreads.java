package demo.wangjq.base.thread;


/**
 * @author admin
 */
public class AlternateThreads {
    private static int i = 0;
    private static char c = 'A';


    public static void main(String[] args) {
        ThreadA threads = new ThreadA();
        Thread thread = new Thread(threads);
        Thread thread1 = new Thread(threads);
        thread1.start();
        thread.start();
    }

    public static class ThreadA implements Runnable {
        @Override
        public void run() {
            synchronized (this) {
                while (c <= 'Z') {
                    try {
                        System.out.print(i++);
                        System.out.println(c++);
                        this.notify();
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                this.notifyAll();
            }
        }
    }
}