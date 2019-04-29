package demo.wangjq.base.collection;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author:wangjq
 * @Date: 2019/4/29 16:29
 */
public class MapTest {


    @Test
    public void testIterator() {

        Map<String, String> map = new TreeMap<>();
        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");
        map.put("d", "4");
        map.put("e", "5");
        map.put("f", "6");

        map.keySet().forEach(key -> System.out.println(key));

        map.values().forEach(value -> System.out.println(value));

        map.entrySet().forEach(node -> System.out.println(node));

        map.forEach((k, v) -> System.out.println(k + "=" + v));

    }

}
