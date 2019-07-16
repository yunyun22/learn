package demo.wangjq.base.thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author:wangjq
 * @Date: 2019/7/16 11:19
 */
public class EscapeTest {

    private int time;

    public EscapeTest() throws InterruptedException {

        new Thread(new EscapeRunnable()).start();

        TimeUnit.SECONDS.sleep(10);

        time = 100;
    }


    class EscapeRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println(EscapeTest.this.time);
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(EscapeTest.this.time);

        }
    }


    public static void main(String[] args) throws InterruptedException {
        //EscapeTest escapeTest = new EscapeTest();


        List<Integer> list = new ArrayList<>();
        list.add(101);
        list.add(101);
        list.add(101);
        list.add(101);
        list.add(301);
        list.add(301);
        list.add(301);
        list.add(401);

        boolean removed = list.removeAll(Arrays.asList(101, 301));
        System.out.println(removed);
        System.out.println(list);

    }
}
