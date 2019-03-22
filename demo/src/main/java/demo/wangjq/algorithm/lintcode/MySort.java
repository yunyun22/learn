package demo.wangjq.algorithm.lintcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by wangjq on 2019/2/12.
 */
public class MySort {
    /**
     * 实现插入排序
     */
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int cur = arr[i], k;
            for (k = i; k > 0 && cur < arr[k - 1]; k--) {
                arr[k] = arr[k - 1];
            }
            arr[k] = cur;
        }
    }

    @Test
    public void testInsertSort() {
        int arr[] = {6, 3, 9, 8, 1, 5};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
