package demo.wangjq.collection;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wangjq on 2018/7/30.
 */
public class BitSetTest {

    public static void main(String[] args) {
        int i = 0;
        List<Apple> apples = new ArrayList<>();
        while (i < 10000000) {
            Apple apple = new Apple();
            if (i % 4 == 0) {
                apple.setCountry("china");
            }
            if (i % 6 == 0) {
                apple.setWight(10);
            }
            apple.setSeqNo(i);
            apples.add(apple);
            i++;
        }

        BitSet chinaBitSet = new BitSet();
        for (Apple apple : apples) {
            if ("china".equals(apple.getCountry())) {
                chinaBitSet.set(apple.getSeqNo());
            }
        }

        BitSet wightSet = new BitSet();
        for (Apple apple : apples) {
            if (Integer.valueOf(10).equals(apple.getWight())) {
                wightSet.set(apple.getSeqNo());
            }
        }

        // bitset求交集
        long startTimeOfBitSet = System.currentTimeMillis();
        wightSet.and(chinaBitSet);

        //wightSet.stream().forEach(System.out::println);


        long endTimeOfBitSet = System.currentTimeMillis();
        System.out.println("bitset method cost time---" + (endTimeOfBitSet - startTimeOfBitSet));

        // 正常求交集
        long startTimeOfNormal = System.currentTimeMillis();
        apples.parallelStream().filter(a -> "china".equals(a.getCountry()) && Integer.valueOf(10).equals(a.getWight())).collect(Collectors.toList());
        long endTimeOfNormal = System.currentTimeMillis();
        System.out.println("normal method cost time---" + (endTimeOfNormal - startTimeOfNormal));

    }
}
