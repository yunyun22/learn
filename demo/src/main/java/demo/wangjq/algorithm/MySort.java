package demo.wangjq.algorithm;

import demo.wangjq.ArraysUtil;

import java.util.Arrays;

/**
 * a sort util
 */
public class MySort {
    /**
     * 冒泡排序
     *
     * @param numbers
     * @return
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
     *
     * @param numbers
     * @return
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
     *
     * @param numbers
     * @return
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

        return merge(left, right);
    }

    /**
     * 合并两个有序的数组
     *
     * @param left
     * @param right
     * @return
     */
    public static int[] merge(int[] left, int[] right) {

        int[] ret = new int[left.length + right.length];

        int leftIndex = 0, rightIndex = 0, i = 0;
        for (; ; ) {
            if (leftIndex < left.length && rightIndex < right.length) {
                if (left[leftIndex] < right[rightIndex]) {
                    ret[i] = left[leftIndex];
                    leftIndex++;
                } else {
                    ret[i] = right[rightIndex];
                    rightIndex++;
                }
            } else if (leftIndex < left.length) {
                ret[i] = left[leftIndex];
                leftIndex++;
            } else if (rightIndex < right.length) {
                ret[i] = right[rightIndex];
                rightIndex++;
            } else {
                break;
            }
            i++;
        }
        return ret;
    }


    public static void main(String[] args) {

        int[] disOrder = {2, 5, 3, 7, 6, 9, 1, 0};

        System.out.println(ArraysUtil.arraysToString(mergeSort(disOrder)));


        int[] left = {1, 3, 6, 8};
        int[] right = {2, 4, 6, 9, 10, 11};
        System.out.println(ArraysUtil.arraysToString(merge(left, right)));

        int[] left1 = {1, 3, 6, 8, 9, 10, 13, 15};
        int[] right1 = {2, 4, 6, 9, 10, 11};
        System.out.println(ArraysUtil.arraysToString(merge(left1, right1)));

        int[] left2 = {1, 3, 5, 7, 9};
        int[] right2 = {2, 4, 6, 8, 10};
        System.out.println(ArraysUtil.arraysToString(merge(left2, right2)));
    }

}
