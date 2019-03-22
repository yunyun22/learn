package demo.wangjq.base.thread.juc;

import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Created by wangjq on 2018/10/22.
 */
public class ConcurrentSkipListMapTest {

    public static void main(String[] args) {

        ConcurrentSkipListMap<Integer, String> concurrentSkipListMap = new ConcurrentSkipListMap();

        concurrentSkipListMap.put(new Integer(1), "王金桥");
        concurrentSkipListMap.put(new Integer(2), "袁酝");

        String name = concurrentSkipListMap.get(new Integer(1));
        System.out.println(name);
    }
}
