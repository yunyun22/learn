package demo.wangjq.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import demo.wangjq.config.Student;

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


        //Optional<Optional<String>> optional = Optional.of("string").map(s -> Optional.of("STRING"));

        //System.out.println(optional.get().get());

        List<Student> list = new ArrayList<>();
        Student temp = new Student();
        temp.setAge("12");
        list.add(temp);

        list.stream().findFirst().ifPresent(
                student -> Optional.ofNullable(student.getAge()).ifPresent(
                        age -> System.out.println(student)));

        if (!list.isEmpty()) {
            Student student = list.get(0);
            if (student.getAge() != null) {
                System.out.println(student);
            }
        }


    }


}
