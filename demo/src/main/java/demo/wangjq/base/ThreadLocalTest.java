package demo.wangjq.base;

/**
 * @author:wangjq
 * @Date: 2019/7/5 15:12
 */
public class ThreadLocalTest {


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {

            ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
            threadLocal.set(i);

        }
        System.gc();

        Thread thread = Thread.currentThread();

    }
}
