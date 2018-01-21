package learn.wangjq.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < 1000; i++) {
//            list.add(i);
//        }
//        list.stream().filter((s) -> {
//            if (s > 100) {
//                return true;
//            } else {
//                return false;
//            }
//        }).forEach(System.out::println);

        Stream<String> stream = Stream.of("aaa", "bb", "cc");

        Stream<Integer> integerStream = Stream.iterate(0, (x) -> x + 2);
        integerStream.limit(10).forEach(System.out::println);
        //integerStream.count();

        Stream.generate(()->Math.random());
    }

}
