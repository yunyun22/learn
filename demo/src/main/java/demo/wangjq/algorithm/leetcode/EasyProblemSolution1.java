package demo.wangjq.algorithm.leetcode;

import com.sun.corba.se.impl.protocol.giopmsgheaders.LocateReplyMessage_1_0;

import org.junit.Test;

import sun.awt.SunHints;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;


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
