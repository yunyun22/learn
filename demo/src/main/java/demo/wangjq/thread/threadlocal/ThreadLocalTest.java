package demo.wangjq.thread.threadlocal;


import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangjq on 2018/6/14.
 */
public class ThreadLocalTest {

    public static void main(String[] args) throws InterruptedException {

        Service service = new Service();

        //Service service1 = new Service();

        Thread[] threads = new Thread[10];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new MyRunable(service));
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }

        System.out.println("end");


    }


}

class MyRunable implements Runnable {

    private Service service;

    public MyRunable(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        try {
            service.startService();
            TimeUnit.SECONDS.sleep(1);
            service.endService();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Service {
    ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public void startService() {
        Random random = new Random();
        int i = random.nextInt(10);
        System.out.println("the thread:" + Thread.currentThread().getName() + " save the value:" + i);
        threadLocal.set(i);
    }

    public void endService() {
        System.out.println("the thread:" + Thread.currentThread().getName() + " get the value:" + threadLocal.get());
    }
}