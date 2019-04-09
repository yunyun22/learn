package demo.wangjq.algorithm.leetcode;

import org.junit.Test;


/**
 * @author:wangjq
 * @Date: 2019/4/9 10:10
 */
public class EasyProblemSolution1 {

    public static int searchInsert(int[] nums, int target) {
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == target || nums[i] > target) {
//                return i;
//            }
//        }
//        return nums.length + 1;

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    @Test
    public void testSearchInsert() {
        int[] nums = {1, 3, 5, 6};
        int target = 7;
        System.out.println(searchInsert(nums, target));
    }
}
