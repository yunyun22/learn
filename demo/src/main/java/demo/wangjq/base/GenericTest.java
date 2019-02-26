package demo.wangjq.base;

import java.util.Arrays;
import java.util.List;

/**
 * Created by wangjq on 2019/2/26.
 */
public class GenericTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 4, 7, 9, 3, 6, 9);
        printGreater(list, 4);
    }

    public static <T extends Comparable<T>> void printGreater(List<T> list, T val) {
        for (T t : list) {
            if (t.compareTo(val) > 0) {
                System.out.println(t);
            }
        }
    }

}
