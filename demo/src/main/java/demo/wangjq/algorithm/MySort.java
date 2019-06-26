package demo.wangjq.algorithm;

import java.util.Arrays;

import demo.wangjq.ArraysUtil;

/**
 * a sort util
 *
 * @author wangjq
 */
public class MySort {
    /**
     * 冒泡排序
     */
    public static int[] bubbleSort(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
        return numbers;
    }


    /**
     * 选择排序
     */
    public static int[] selectionSort(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                if (numbers[i] > numbers[j]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        return numbers;
    }


    /**
     * 并归排序
     */
    public static int[] mergeSort(int[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("arrays is valid");
        }

        if (numbers.length < 2) {
            return numbers;
        }

        int mid = numbers.length / 2;

        int[] left = mergeSort(Arrays.copyOfRange(numbers, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(numbers, mid, numbers.length));

        return ArraysUtil.merge(left, right);
    }


    /**
     * 快速排序
     *
     * @param disOrder 未被排序的数组
     * @return 已经排序的数组
     */
    public static void quickSort(int[] disOrder) {
        sort(disOrder, 0, disOrder.length - 1);
    }

    private static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            sort(arr, low, pivot - 1);
            sort(arr, pivot + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= pivot) high--;
            arr[low] = arr[high];
            while (low < high && arr[low] < pivot) low++;
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;

    }

    public static void main(String[] args) {

        int[] disOrder = {2, 5, 3, 7, 6, 9, 1, 0};
        quickSort(disOrder);
        System.out.println(ArraysUtil.arraysToString(disOrder));


//        int[] left = {1, 3, 6, 8};
//        int[] right = {2, 4, 6, 9, 10, 11};
//        System.out.println(ArraysUtil.arraysToString(ArraysUtil.merge(left, right)));
//
//        int[] left1 = {1, 3, 6, 8, 9, 10, 13, 15};
//        int[] right1 = {2, 4, 6, 9, 10, 11};
//        System.out.println(ArraysUtil.arraysToString(ArraysUtil.merge(left1, right1)));
//
//        int[] left2 = {1, 3, 5, 7, 9};
//        int[] right2 = {2, 4, 6, 8, 10};
//        System.out.println(ArraysUtil.arraysToString(ArraysUtil.merge(left2, right2)));
    }

}
