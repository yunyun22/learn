package demo.wangjq.algorithm.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.IntFunction;

import static demo.wangjq.algorithm.leetcode.TopTen.*;

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

    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int max = dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    @Test
    public void testMaxSubArray() {
        int[] nums = {-2, -1};
        System.out.println(maxSubArray(nums));
    }

    public static int lengthOfLastWord(String s) {
        s = s.trim();
        Integer spaceIndex = null, length = s.length();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == 0x20) {
                spaceIndex = i;
            }
        }
        return spaceIndex == null ? s.length() : length - spaceIndex - 1;
    }

    @Test
    public void testLengthOfLastWord() {
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < 13; i++) {
            map.put("one two" + i + "three", "1");
        }

    }

    public static final byte FRONT_RESOURCE_TYPE = 1;

    public static final byte INTERFACE_RESOURCE_TYPE = 2;

    @Test
    public void testStreamAnyMatch() {
        List<Integer> list1 = Arrays.asList(1, 2, 4);
        List<Integer> list2 = Arrays.asList();
        System.out.println(list1.containsAll(list2));
        Long[] longs = list1.stream().mapToLong(Integer::longValue).boxed().toArray(new IntFunction<Long[]>() {
            @Override
            public Long[] apply(int value) {
                System.out.println(value);
                return new Long[3];
            }
        });

        System.out.println();
        Arrays.stream(longs).forEach(l -> System.out.println(l));
    }

    public static String addBinary(String a, String b) {
        String ret = new String();
        int i1 = a.length() - 1, i2 = b.length() - 1;
        int overFlow = 0;
        while (i1 >= 0 || i2 >= 0) {
            int cur = overFlow;
            if (i1 >= 0) {
                cur = cur + a.charAt(i1--) - '0';
            }
            if (i2 >= 0) {
                cur = cur + b.charAt(i2--) - '0';
            }
            int value = cur % 2;
            overFlow = cur / 2;
            ret = value + ret;
        }

        return overFlow == 0 ? ret : overFlow + ret;
    }

    @Test
    public void testAddBinary() {
        String a = "11";
        String b = "1";
        System.out.println(addBinary(a, b));
    }

    public static int mySqrt(int x) {
        long r = x;
        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return (int) r;
    }

    @Test
    public void testMySqrt() {
        System.out.println(mySqrt(2147395600));
    }

    public static int climbStairs(int n) {
        int[] climb = new int[n + 1];
        for (int i = 0; i < climb.length; i++) {
            if (i <= 2) {
                climb[i] = i;
            } else {
                climb[i] = climb[i - 1] + climb[i - 2];
            }
        }
        return climb[n];
    }

    @Test
    public void testClimbStairs() {
        System.out.println(climbStairs(1));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head, pre = cur;
        for (; cur != null; cur = cur.next) {
            if (pre.val != cur.val) {
                pre.next = cur;
                pre = cur;
            }
        }
        if (pre != null) {
            pre.next = null;
        }
        return head;
    }

    @Test
    public void testDeleteDuplicates() {
        ListNode temp, l1 = new ListNode(2);
        temp = l1;
        temp = temp.next = new ListNode(3);
        temp = temp.next = new ListNode(4);
        temp = temp.next = new ListNode(4);
        deleteDuplicates(l1);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1, im = m - 1, in = n - 1;
        for (; i >= 0; i--) {
            if (im >= 0 && in >= 0) {
                nums1[i] = nums1[im] > nums2[in] ? nums1[im--] : nums2[in--];
            } else if (in >= 0) {
                nums1[i] = nums2[in];
            }
        }
    }

    @Test
    public void testMerge() {
        int[] nums1 = {2, 0};
        int[] nums2 = {1};
        merge(nums1, 1, nums2, 1);
    }

    class ByteTest {
        private Byte ok;

        public Byte getOk() {
            return ok;
        }

        public void setOk(Byte ok) {
            this.ok = ok;
        }
    }


}
