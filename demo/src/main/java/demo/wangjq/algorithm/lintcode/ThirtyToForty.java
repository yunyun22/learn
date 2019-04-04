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
            if (target >= nums[left] && target <= nums[mid]) {
                right = mid;
            } else if (target >= nums[mid] && target <= nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
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
