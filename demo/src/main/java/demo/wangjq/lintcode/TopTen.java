package demo.wangjq.lintcode;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopTen {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        int result = reverseInteger(123);
        System.out.println("result = " + result);
    }

    /**
     * @param number: A 3-digit number.
     * @return: Reversed number.
     */
    public static int reverseInteger(int number) {

        int i = number / 100;
        int j = (number - i * 100) / 10;
        int k = (number - i * 100) - j * 10;

        return k * 100 + j * 10 + i;
    }

    /**
     * Two Sum
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        int[] ret = new int[2];
        for (int index = 0; index < nums.length; index++) {
            if (map.containsKey(target - nums[index])) {
                ret[0] = map.get(target - nums[index]);
                ret[1] = index;
            }
            map.put(nums[index], index);
        }
        return ret;
    }

    @Test
    public void testTWoSum() {
        int[] nums = new int[]{2, 7, 11, 15};
        Assert.assertArrayEquals(new int[]{0, 1}, twoSum(nums, 9));
    }

    /**
     * Add Two Numbers
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        int carry = 0;
        ListNode curr = head;
        for (; l1 != null || l2 != null; ) {
            int val = carry + ((l1 != null) ? l1.val : 0) + ((l2 != null) ? l2.val : 0);

            carry = val / 10;
            val %= 10;

            curr.next = new ListNode(val);
            curr = curr.next;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }
        if (carry != 0) {
            curr.next = new ListNode(carry);
        }
        return head.next;
    }

    @Test
    public void testTwoNumbers() {
        ListNode temp, l1 = new ListNode(2);
        temp = l1;
        temp = temp.next = new ListNode(4);
        temp.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        temp = l2;
        temp = temp.next = new ListNode(6);
        temp.next = new ListNode(4);
        addTwoNumbers(l1, l2);
    }

    /**
     * z
     *
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        if (s == null || "".equals(s) || numRows == 1 || s.length() < numRows) {
            return s;
        }
        int length = s.length(),
                rows = numRows,
                vChar = (numRows * 2 - 2),
                vCharNum = length / (numRows * 2 - 2),
                columns = vCharNum * (numRows - 1) + ((length % vChar) == 0 ? 0 : ((vCharNum != 0 && length % vChar <= numRows) ? 1 : (length % vChar - numRows + 1)));
        char[][] z = new char[rows][columns];
        int i = 0;
        int rowsMinusOne = rows - 1;
        for (int y = 0; y < columns && i < length; y++) {
            if (y % rowsMinusOne == 0) {// vertically down
                for (int x = 0; x < rows && i < length; x++) {
                    z[x][y] = s.charAt(i++);
                }
            } else {// obliquely up
                z[rowsMinusOne - y % rowsMinusOne][y] = s.charAt(i++);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < z.length; k++) {
            for (int l = 0; l < z[k].length; l++) {
                sb.append(z[k][l] != 0 ? z[k][l] : "");
            }
        }
        return sb.toString();
    }

    @Test
    public void testConvert() {
        String s = "A";
        System.out.println(convert(s, 3));
    }

    /**
     * @param x
     * @return
     */
    public static int reverse(int x) {
        char[] chars = x < 0 ? new Integer(x).toString().substring(1).toCharArray() : new Integer(x).toString().toCharArray();
        char temp;
        for (int i = 0; i < chars.length / 2; i++) {
            temp = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = temp;
        }

        return x < 0 ? new Integer("-" + new String(chars)) : new Integer(new String(chars));
    }

    @Test
    public void testReverse() {
        System.out.println(reverse(1534236469));
    }

    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1, max = 0;
        while (left < right) {
            max = Math.max(height[left] > height[right] ? (height[right] * (right - left)) : (height[left] * (right - left)), max);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return max;
    }

    @Test
    public void testMaxArea() {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        Assert.assertEquals(49, maxArea(height));
        Assert.assertEquals(1, maxArea(new int[]{1, 1}));
    }

    public String longestPalindrome(String s) {
        int l = s.length();
        int[][] isPalindromic = new int[l][l];

        String str = "";
        for (int left = l - 1; left >= 0; left--) {
            for (int right = left; right < l; right++) {
                if (s.charAt(left) == s.charAt(right) &&
                        (right - left < 3 || isPalindromic[left + 1][right - 1] == 1)) {
                    isPalindromic[left][right] = 1;
                    str = str.length() > (right - left + 1) ? str : s.substring(left, right + 1);
                }
            }
        }
        return str;
    }

    @Test
    public void testLongestPalindrome() {
        System.out.println(longestPalindrome("aaaa"));
    }

    public static boolean isPalindrome(int x) {
        if (x >= 0 && x < 10) {
            return true;
        }
        if (x < 0) {
            return false;
        }
        int palindrome = x;
        List<Integer> list = new ArrayList<>();
        while (palindrome != 0) {
            list.add(palindrome % 10);
            palindrome /= 10;
        }

        if (list.isEmpty()) {
            return false;
        }
        for (int i = 0; i < list.size() / 2 + 1; i++) {
            if (!list.get(i).equals(list.get(list.size() - 1 - i))) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testIsPalindrome() {
        System.out.println(isPalindrome(-121));
    }

    public static int myAtoi(String str) {
        String temp = str.trim();
        int factor = 1;
        List<Integer> nums = new ArrayList<>();
        int res = 0, l = temp.length();
        for (int i = 0; i < l; i++) {
            char c = temp.charAt(i);
            if (i == 0 && (c == '-' || c == '+')) {
                factor = (c == '-') ? -1 : 1;
            } else if (c >= '0' && c <= '9') {
                nums.add(c - '0');
            } else {
                break;
            }
        }
        for (int i = nums.size() - 1; i >= 0; i--) {
            res += (nums.get(i) * factor * Math.pow(10, nums.size() - 1 - i));
        }
        return res;
    }

    @Test
    public void testMyAtoi() {
//        System.out.println(myAtoi("-123"));
//        int test = Integer.MAX_VALUE + 10000;
//        System.out.println(test);
    }
}
