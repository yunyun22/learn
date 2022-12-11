package demo.wangjq.algorithm.dp;

import java.util.Arrays;

/**
 * @author Administrator
 */
public class LongestAscSubSequence {


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 给定数组的最长严格上升子序列的长度。
     *
     * @param arr int整型一维数组 给定的数组
     * @return int整型
     */
    public int LIS(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[] result = new int[arr.length];

        Arrays.fill(result, 1);

        int res = 1;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    result[i] = Math.max(result[i], result[j] + 1);
                    res = Math.max(res, result[i]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LongestAscSubSequence las = new LongestAscSubSequence();
        int[] arr = {1, 6, 4, 7, 5, 3, 2};
        int lis = las.LIS(arr);
        System.out.println(lis);
    }
}
