package demo.wangjq.algorithm.dp;

/**
 * @author Administrator
 */
public class FindGreatestSumOfSubArray {


    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int pre = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            int cur = Math.max(pre + array[i], array[i]);
            max = Math.max(max, cur);
            pre = cur;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {-10, -9, 8, 1, 1, -3, 4};
        FindGreatestSumOfSubArray findGreatestSumOfSubArray = new FindGreatestSumOfSubArray();
        int max = findGreatestSumOfSubArray.FindGreatestSumOfSubArray(arr);

        System.out.println(max);

    }
}
