package demo.wangjq.base.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author wang, jinqiao
 * @date 23/04/2021
 */
public class FutureTaskTest {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        WashCallable washCallable = new WashCallable();
        HotWaterCallable hotWaterCallable = new HotWaterCallable();

        FutureTask<Boolean> washFutureTask = new FutureTask<>(washCallable);
        FutureTask<Boolean> hotWaterFutureTask = new FutureTask<>(hotWaterCallable);

        Thread washThread = new Thread(washFutureTask);
        Thread hotWaterThread = new Thread(hotWaterFutureTask);
        washThread.start();
        hotWaterThread.start();

        while (!washFutureTask.isDone() || !hotWaterFutureTask.isDone()) {
            System.out.println("干点其它的吧");
        }

        Boolean wash = washFutureTask.get();
        Boolean hotWater = hotWaterFutureTask.get();
        if (wash && hotWater) {
            System.out.println("泡茶喝");
        }

    }

    static class WashCallable implements Callable<Boolean> {
        @Override
        public Boolean call() throws Exception {
            try {
                System.out.println("洗茶壶");
                System.out.println("洗茶杯");
                System.out.println("拿茶叶");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("洗完了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        }
    }

    static class HotWaterCallable implements Callable<Boolean> {

        @Override
        public Boolean call() throws Exception {
            try {
                System.out.println("洗好水壶");
                System.out.println("罐上凉水");
                System.out.println("放在火上");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("水烧好了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        }
    }
}
