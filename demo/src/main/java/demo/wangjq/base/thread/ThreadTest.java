package demo.wangjq.base.thread;

/**
 * @author wangjq
 */
public class ThreadTest {
    private static boolean initialized = false;

//    static {
//        Thread t = new Thread(() -> {
//            //System.out.println("sure?");
//            //initialized = true;
//        }, "fuck you");
//        t.start();
//
//        try {
//            t.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//
//    }

    public static void main(String[] args) throws InterruptedException {


        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println("fuck the world");
            }
        });

        //thread.setDaemon(true);

        thread.start();


    }
}