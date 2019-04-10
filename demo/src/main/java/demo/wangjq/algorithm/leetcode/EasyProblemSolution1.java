package demo.wangjq.algorithm.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


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

    static Map<Integer, String> countAndSay = new HashMap<>();

    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String preSay = countAndSay(n - 1);
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        char current = '\0';
        for (int i = 0; i < preSay.length(); i++) {
            current = preSay.charAt(i);
            if (i == 0 || current == preSay.charAt(i - 1)) {
                count++;
            } else {
                stringBuilder.append(count).append(preSay.charAt(i - 1));
                count = 1;
            }
        }
        return stringBuilder.append(count).append(current).toString();
    }

    @Test
    public void testCountAndSay() {
        System.out.println(countAndSay(5));
    }
}
