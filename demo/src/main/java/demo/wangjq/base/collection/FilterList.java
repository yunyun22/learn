package demo.wangjq.base.collection;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author:wangjq
 * @Date: 2019/4/28 11:28
 */
public class FilterList {

    private List<Integer> list;


    public static final int capacity = 1000000;


    @Before
    public void testBefore() {
        Random random = new Random();
        if (list == null) {
            list = new ArrayList<>(capacity);
        }
        for (int i = 0; i < capacity; i++) {
            list.add(random.nextInt(10));
        }

    }


    @Test
    public void testFilterList() {
        list.spliterator().trySplit().forEachRemaining((i) -> {
            if (list.get(i) == 2) {
                System.out.println(list.get(i));
            }
        });
    }

}
