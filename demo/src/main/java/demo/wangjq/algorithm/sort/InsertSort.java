package demo.wangjq.algorithm.sort;

import demo.wangjq.util.Print;

import java.util.Arrays;

/**
 * @author wang, jinqiao
 * @title: InsertSort
 * @date 12/08/2021
 */
public class InsertSort {

    @SuppressWarnings({"fallthrough", "rawtypes", "unchecked"})
    public static void sort(Object[] object) {
        if (object == null || object.length == 1) {
            return;
        }
        //依次保证左边的数据为有序
        //如果当前值依次从右往左进行比较，当前值小于左边的值，左边的值往后移动
        //直到当前值不小于左边的值
        for (int i = 1; i < object.length; i++) {
            Object target = object[i];
            int endIndexForTarget = i;
            for (int j = i; j > 0; j--) {
                Comparable comparable = (Comparable) object[j - 1];
                if (comparable.compareTo(target) > 0) {
                    object[j] = object[j - 1];
                    endIndexForTarget = j - 1;
                }
            }
            object[endIndexForTarget] = target;
        }
    }

    @SuppressWarnings({"fallthrough", "rawtypes", "unchecked"})
    public static Object[] insertOrderArray(Object[] object, Object o) {
        if (object == null || object.length == 0) {
            return new Object[]{o};
        }
        Object[] result = Arrays.copyOf(object, object.length + 1);
        int targetIndex = result.length - 1;
        for (int i = result.length - 1; i > 0; i--) {
            Comparable comparable = (Comparable) result[i - 1];
            if (comparable.compareTo(o) > 0) {
                result[i] = comparable;
                targetIndex = i - 1;
            }
        }
        result[targetIndex] = o;
        return result;
    }

    public static void main(String[] args) {
        Integer[] o = {1, 2, 4, 5, 8};
        sort(o);
        Print.printArray(o);
        Object[] objects = insertOrderArray(o, 3);
        Print.printArray(objects);

    }
}
