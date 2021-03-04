package demo.wangjq.base.sort;

import cn.hutool.core.util.ArrayUtil;

/**
 * @author wang, jinqiao
 * @title: QuickSort
 * @date 25/01/2021
 */
public class QuickSort {

    public static void main(String[] args) {

        int[] array = {2, 1, 3, 4, 5, 6, 7};
        quickSort(array, 0, array.length - 1);

        System.out.println(ArrayUtil.toString(array));

    }

    public void sort(int[] array) {

    }

    public static void quickSort(int[] array, int start, int end) {
        if (array == null || array.length < 2) {
            return;
        }
        int base = array[start];
        int left = start;
        int right = end;

        while (left < right) {


            //如果先从基准左边开始,left会停留在一个比base大的数字,这时候right和left指向同一个位置时,之后交换会出现较大的数字在base左边

            //从基准的右边开始,一定会找到比base小的数字。
            //之后会出现两种情况：
            // 1.left不发生移动,置换后会将最小的数据放到base
            // 2.left发生移动,置换后会将小于base放左边,大于的放右边


            //比基准小
            while (left < right && array[right] >= base) {
                right--;
            }

            //比基准大
            while (left < right && array[left] <= base) {
                left++;
            }


            if (left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }
        array[start] = array[left];
        array[left] = base;

        quickSort(array, start, left - 1);
        quickSort(array, left + 1, end);
    }
}
