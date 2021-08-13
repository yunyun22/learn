package demo.wangjq.algorithm.sort;

import demo.wangjq.util.Print;

/**
 * @author wang, jinqiao
 * @date 12/08/2021
 */
public class SelectSort {

    @SuppressWarnings({"fallthrough", "rawtypes", "unchecked"})
    public static void sort(Object[] object) {
        if (object == null || object.length == 1) {
            return;
        }
        //获取当前index(i)到最后一个index(length)
        //在整个数组中获取最小值的index(j)
        //交换数据i与j的位置 (object[i],object[j])

        //总结：选择好位置的数据与当前位置的数据交换，过程中只发生一次数据交换
        for (int i = 0; i < object.length; i++) {
            int minIndex = i;
            for (int j = i; j < object.length; j++) {
                Comparable comparable = (Comparable) object[i];
                if (comparable.compareTo(object[j]) > 0) {
                    minIndex = j;
                }
            }
            Object temp = object[i];
            object[i] = object[minIndex];
            object[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        Integer[] o = {2, 3, 4, 1, 8, 7};
        sort(o);
        Print.printArray(o);
    }


}
