package demo.wangjq.algorithm.leetcode;

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
            boolean isBefore = (target >= nums[left] && target <= nums[mid])
                    || (target > nums[mid] && target > nums[left]);
            if (isBefore) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    @Test
    public void testSearch() {
        int[] nums = {5, 1, 3};
        int target = 5;
        search(nums, target);
    }
}
