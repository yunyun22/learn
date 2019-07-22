package demo.wangjq.util;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author:wangjq
 * @Date: 2019/7/19 10:23
 */
public class NullableUtil {
    /**
     * 如果数组为空对象，返回一个没有任何元素的空数组对象
     *
     * @param t   无法判断该数组是否为空
     * @param <T> 泛型
     * @return 如果数组为null返回length为0的数组对象
     */
    public static <T> T[] nullToEmpty(T[] t) {
        return Optional.ofNullable(t).orElse((T[]) new Object[]{});
    }


    public static void main(String[] args) {
        Long[] longs = null;


        long[] longs1 = Stream.of(NullableUtil.nullToEmpty(longs)).mapToLong(Long::longValue).toArray();

        System.out.println(longs.length);


    }

}


