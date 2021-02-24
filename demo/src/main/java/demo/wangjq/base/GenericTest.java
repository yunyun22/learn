package demo.wangjq.base;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangjq on 2019/2/26.
 */
public class GenericTest {
    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(1, 2, 4, 7, 9, 3, 6, 9);
//        printGreater(list, 4);

        List<LocalDate> localDates = Arrays.asList(LocalDate.now(), LocalDate.now());
        //如果没有 ? super T
        //那么转换成的类型为   <LocalDate extends Comparable<LocalDate>>
        //LocalDate 是没有实现Comparable<LocalDate> 而是父类ChronoLocalDate实现了Comparable<LocalDate>
        //所以需要下界通配符
        printGreater(localDates, LocalDate.now());
        localDates.removeIf((localDate) -> localDate.toEpochDay() == 1);
    }

    public static <T extends Comparable<? super T>> void printGreater(List<T> list, T val) {
        for (T t : list) {
            if (t.compareTo(val) > 0) {
                System.out.println(t);
            }
        }
    }

}
