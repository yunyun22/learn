package demo.wangjq.base;

/**
 * @author:wangjq
 * @Date: 2019/7/5 15:12
 */
public class ThreadLocalTest {


    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();

        threadLocal.set("fuck");

        while (threadLocal.get() != null) {
            System.gc();
        }
        System.out.println("fuck");

    }


}
