package demo.wangjq.base.sort;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author wang, jinqiao
 * @date 28/06/2021
 */
public class ListTest {
    public static void main(String[] args) {
        ArrayList<Integer> integers = Lists.newArrayList(2, 3, 1, 4);
        integers.sort(Comparator.comparing(Integer::intValue).reversed());
        System.out.println(integers);
    }
}
