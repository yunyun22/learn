package demo.wangjq.lambda;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by wangjq on 2018/6/8.
 */
public class FunctionalTest {

    public static void main(String[] args) {


        List<List<String>> list = Arrays.asList(
                Arrays.asList("a"),
                Arrays.asList("b")
        );

        System.out.println(list.stream().flatMap(Collection::stream).collect(Collectors.toList()));


        IntStream.of(12, 3, 56, 78).sum();
        IntStream.of(12, 3, 56, 78).average().getAsDouble();

        IntStream.of(12, 3, 56, 78).max().getAsInt();


    }

}
