package demo.wangjq.optional;

import java.util.Optional;

/**
 * Created by wangjq on 2018/6/8.
 */
public class OptionalTest {

    public static void main(String[] args) {

//        Optional<String> optional = Optional.empty();
//        optional.ifPresent(System.out::print);
//        System.out.println(optional.orElse("wangjq"));
//        optional.orElseGet(() -> "time,time");
//        optional.orElseThrow(() -> {
//            return new IllegalArgumentException("argument error");
//        });


        Optional<Optional<String>> optional = Optional.of("string").map(s -> Optional.of("STRING"));

        System.out.println(optional.get().get());

    }

}
