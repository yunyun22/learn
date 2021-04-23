package demo.wangjq.base.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author wang, jinqiao
 * @date 23/04/2021
 */
public class JoinTest {

    public static void main(String[] args) {
        Thread washThread = new WashThread();
        Thread hotWaterThread = new HotWaterThread();
        washThread.start();
        hotWaterThread.start();
        try {
            washThread.join();
            hotWaterThread.join();
            System.out.println("泡茶喝");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    static class WashThread extends Thread {
        public WashThread() {
            super("$$清洗-线程");
        }

        @Override
        public void run() {
            try {
                System.out.println("洗茶壶");
                System.out.println("洗茶杯");
                System.out.println("拿茶叶");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("洗完了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class HotWaterThread extends Thread {

        public HotWaterThread() {
            super("**烧水-线程");
        }

        @Override
        public void run() {
            try {
                System.out.println("洗好水壶");
                System.out.println("罐上凉水");
                System.out.println("放在火上");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("水烧好了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
