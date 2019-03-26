package demo.wangjq;

import org.junit.Test;

import java.io.InputStream;
import java.io.Reader;

/**
 * @author wangjq
 */
public class ClassPathTest {

    public static final String path = "test.properties";


    @Test
    public void test() {
        InputStream inputStream2 = this.getClass().getResourceAsStream(path);
        System.out.println(inputStream2);

        // TODO 获取流为null，但是classLoader又不为null（appclassloader），获取URL为null
        InputStream inputStream3 = ClassLoader.getSystemResourceAsStream(path);
        System.out.println(inputStream3);

        // TODO 获取流为null，但是classLoader又不为null， 与上面方法一样都是通过类加载器，获取文件路由
        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(path);
        System.out.println(inputStream);
    }
}
