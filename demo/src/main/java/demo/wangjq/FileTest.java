package demo.wangjq;

import java.io.FileNotFoundException;
import java.net.URL;

/**
 * @author:wangjq
 * @Date: 2019/9/6 09:42
 */
public class FileTest {

    public static void main(String[] args) throws FileNotFoundException {


        URL base = FileTest.class.getResource("");

        ClassLoader.getSystemClassLoader();

//        System.out.println(base);
//
//        File file = new File(base.getFile(), "/demo/wangjq/myTest.txt");
//
//        System.out.println(ClassLoader.getSystemResource(""));
//
//        InputStream inputStream = new FileInputStream(file);
//        System.out.println(ClassLoader.getSystemResource("/"));
//
//        System.out.println(file.getPath());

    }

}
