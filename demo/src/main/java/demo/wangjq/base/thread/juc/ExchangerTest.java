package demo.wangjq.base.thread.juc;

import java.util.concurrent.Exchanger;

public class ExchangerTest {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        Runnable r1 = () -> {
            try {
                String messaeg = exchanger.exchange("r1");
                System.out.println("r1 messaeg = " + messaeg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        };

        Runnable r2 = () -> {
            try {
                String messaeg = exchanger.exchange("r2");
                System.out.println("r2 messaeg = " + messaeg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        };
        new Thread(r1).start();
        new Thread(r2).start();
    }
}
