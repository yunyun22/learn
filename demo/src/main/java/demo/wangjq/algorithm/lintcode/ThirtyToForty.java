package demo.wangjq.algorithm.lintcode;

import org.junit.Test;

import java.util.Stack;

/**
 * @author wangjq
 */
public class ThirtyToForty {
    /**
     * Input: "(()"
     * Output: 2
     * Explanation: The longest valid parentheses substring is "()"
     */
    public static int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        return 0;

    }


    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = (right + left) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            /**
             * 左边连续
             */
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target <= nums[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
                continue;
            }
            /**
             * 右边连续
             */
            if (nums[mid] < nums[right]) {
                if (target >= nums[mid] && target <= nums[right]) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        return -1;
    }

    @Test
    public void testSearch() {
        int[] nums = {1, 3};
        int target = 2;
        search(nums, target);
    }


    public static int[] searchRange(int[] nums, int target) {
        int start = -1, end = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                start = start == -1 ? i : start;
                end = i;
            }
        }
        return new int[]{start, end};
    }

    @Test
    public void testSearchRange() {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        searchRange(nums, 6);
    }
}
