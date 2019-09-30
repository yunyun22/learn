package demo.wangjq;

import com.google.common.primitives.Ints;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author:wangjq
 * @Date: 2019/9/6 09:42
 */
public class FileTest {

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println(System.getProperty("user.dir"));
        //URL base = FileTest.class.getResource("");

        //ClassLoader.getSystemClassLoader();

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


        int[] i = new int[]{1, 2, 3};

        List<Integer> integers = IntStream.of(i).boxed().collect(Collectors.toList());


        List<Integer> list = Ints.asList(i);

    }

}
