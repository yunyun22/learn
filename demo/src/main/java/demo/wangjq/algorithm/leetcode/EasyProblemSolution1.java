package demo.wangjq.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.IntFunction;

import demo.wangjq.ArraysUtil;
import demo.wangjq.algorithm.leetcode.BaseDataStructure.TreeNode;
import demo.wangjq.algorithm.leetcode.TopTen.ListNode;

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

    public int[] plusOne(int[] digits) {
        int overflow = 0, index = digits.length - 1;
        for (int i = index; i >= 0; i--) {
            int value = (i == index) ? (digits[i] + 1) : digits[i] + overflow;
            overflow = value >= 10 ? 1 : 0;
            digits[i] = value >= 10 ? 0 : value;
        }
        if (overflow == 0) {
            return digits;
        } else {
            int[] ret = new int[index + 1];
            ret[0] = 1;
            System.arraycopy(ret, 1, digits, 0, digits.length);
            return ret;
        }

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
                nums1[i] = nums2[in--];
            }
        }
    }

    @Test
    public void testMerge() {
        int[] nums1 = {2, 0};
        int[] nums2 = {1};
        // merge(nums1, 1, nums2, 1);
        Integer i = null;
        Object o = null;
        System.out.println(i == o);
    }

    public static boolean isSameTree1(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree1(p.left, q.left)
                && isSameTree1(p.right, p.right);
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


    public static boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val == q.val) return true;
        return false;
    }

    public static boolean isSameTree(TreeNode r, TreeNode l) {
        if (r == null && l == null) return true;
        if (!check(r, l)) {
            return false;
        }
        ArrayDeque<TreeNode> rArrayDeque = new ArrayDeque<>();
        ArrayDeque<TreeNode> lArrayDeque = new ArrayDeque<>();
        rArrayDeque.addLast(r);
        lArrayDeque.addLast(l);
        while (!rArrayDeque.isEmpty()) {
            TreeNode p = rArrayDeque.removeFirst();
            TreeNode q = lArrayDeque.removeFirst();
            if (!check(p, q)) {
                return false;
            }
            if (p.left != null && q.left != null) {
                rArrayDeque.addLast(p.left);
                lArrayDeque.addLast(q.left);
            } else if (p.left != q.left) {
                return false;
            }
            if (p.right != null && q.right != null) {
                rArrayDeque.addLast(p.right);
                lArrayDeque.addLast(q.right);
            } else if (p.right != q.right) {
                return false;
            }
        }
        return true;
    }


    @Test
    public void testIsSameTree() {
        TreeNode r = new TreeNode(1);
        r.left = new TreeNode(2);
        TreeNode l = new TreeNode(1);
        l.right = new TreeNode(2);
        isSameTree(r, l);

    }


    public static boolean isSymmetric(TreeNode root) {
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        if (root == null) {
            return true;
        }
        linkedList.addLast(root.left);
        linkedList.addLast(root.right);
        while (!linkedList.isEmpty()) {
            TreeNode t1 = linkedList.pollFirst();
            TreeNode t2 = linkedList.pollFirst();
            if (t1 == null && t2 == null) {
                continue;
            }
            if (t1 == null || t2 == null) {
                return false;
            }
            if (t1.val != t2.val) {
                return false;
            }
            linkedList.addLast(t1.left);
            linkedList.addLast(t2.right);
            linkedList.addLast(t1.right);
            linkedList.addLast(t2.left);
        }
        return true;
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.right == null && root.left == null) {
            return 1;
        }
//        int rightDepth = root.right != null ? maxDepth(root.right) + 1 : 0;
//        int leftDepth = root.left != null ? maxDepth(root.left) + 1 : 0;
        return Math.max(maxDepth(root.right) + 1, maxDepth(root.left) + 1);
    }


    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<>();
        List<TreeNode> list = new LinkedList<>();
        if (root != null) {
            list.add(root);
        }
        while (!list.isEmpty()) {
            List<TreeNode> temps = new LinkedList<>();
            List<Integer> ret = new LinkedList<>();
            for (TreeNode temp : list) {
                ret.add(temp.val);
                if (temp.left != null) {
                    temps.add(temp.left);
                }
                if (temp.right != null) {
                    temps.add(temp.right);
                }
            }
            lists.add(0, ret);
            list = temps;
        }
        return lists;
    }


    public static int threeSumClosest(int[] num, int target) {

        int min = num[0] + num[1] + num[num.length - 1];
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }
            int cur = num[i], l = i + 1, r = num.length - 1;
            while (l < r) {
                int sum = cur + num[l] + num[r];
                min = Math.abs(target - sum) > Math.abs(target - min) ? min : sum;
                if (num[l] + num[r] + cur < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return min;

    }


    public static List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> ret = new ArrayList<>();
        if (num == null || num.length < 3) {
            return ret;
        }
        Arrays.sort(num);
        int length = num.length;

        for (int i = 0; i < length - 2; i++) {
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }
            int cur = num[i], l = i + 1, r = length - 1;
            while (l < r) {
                if (cur + num[l] + num[r] == 0) {
                    ret.add(Arrays.asList(cur, num[l], num[r]));
                    while (l < r && num[l] == num[++l]) {
                    }
                    while (l < r && num[r] == num[--r]) {
                    }
                } else if (num[l] + num[r] + cur < 0) {
                    l++;
                } else {
                    r--;
                }
            }

        }

        return ret;
    }


    @Test
    public void testThreeSum() {
        int[] num = {-1, 2, 1, -4};

        System.out.println(threeSumClosest(num, 1));
    }


    public static List<String> letterCombinations(String digits) {

        Map<Character, String> map = new HashMap<>(9);
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        map.put('1', "");
        LinkedList<String> list = new LinkedList<>();


        if (digits.length() < 1) {
            return list;
        }

        list.offer("");

        for (int i = 0; i < digits.length(); i++) {
            String s = map.get(digits.charAt(i));
            while (list.peek().length() == i) {
                String joined = list.poll();
                for (int j = 0; j < s.length(); j++) {
                    StringBuilder sb = new StringBuilder(joined);
                    sb.append(s.charAt(j));
                    list.offer(sb.toString());
                }
            }
        }
        return list;
    }

    @Test
    public void testLetterCombinations() {
        letterCombinations("");
    }


    public static void nextPermutation(int[] nums) {

        int i = nums.length - 2;

        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }

        revers(nums, i + 1, nums.length - 1);

    }

    public static void revers(int[] num, int start, int end) {

        while (start < end) {
            swap(num, start, end);
            start++;
            end--;
        }

    }

    public static void swap(int[] num, int i, int j) {

        if (i < 0 || i > num.length - 1) {
            throw new RuntimeException("");
        }
        if (j < 0 || j > num.length - 1) {
            throw new RuntimeException("");
        }

        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;

    }


    @Test
    public void testNextPermutation() {
        int[] nums = {1, 2};
        nextPermutation(nums);

        System.out.println(ArraysUtil.arraysToString(nums));
    }


    public static int[] searchRange(int[] nums, int target) {
        int start = binarySearch(nums, target);
        if (nums.length == start || nums[start] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{start, binarySearch(nums, target + 1) - 1};
    }

    public static int binarySearch(int[] nums, int target) {
        int lo = 0, hi = nums.length;

        while (lo < hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }


    @Test
    public void testSearchRange() {
        int[] num = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] range = searchRange(num, target);
        System.out.println(range[0] + " " + range[1]);
    }


    public static int uniquePaths(int m, int n) {

        return loopPaths(m, n);
    }


    public static int loopPaths(int m, int n) {
        int[][] cache = new int[m][n];

        cache[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    cache[i][j] = 1;
                } else {
                    cache[i][j] = cache[i - 1][j] + cache[i][j - 1];
                }
            }
        }
        return cache[m - 1][n - 1];

    }


    public static int recursionPath(int[][] cache, int m, int n) {
        if (m == 0 || n == 0) {
            return 1;
        }
        if (cache[m][n] != 0) {
            return cache[m][n];
        }
        cache[m][n] = recursionPath(cache, m - 1, n) + recursionPath(cache, m, n - 1);
        return cache[m][n];

    }

    @Test
    public void testUniquePaths() {
        Assert.assertSame(1, uniquePaths(1, 1));
    }


    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;

        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < obstacleGrid[i].length; j++) {
                if (i == 0 && j == 0) {
                    obstacleGrid[0][0] = 1;
                } else if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                } else if (i == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i][j - 1];
                } else if (j == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j];
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }
            }
        }
        return obstacleGrid[m - 1][obstacleGrid[m - 1].length - 1];
    }


    @Test
    public void testUniquePathsWithObstacles() {

        int[][] obstacleGrid = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}};


        Assert.assertSame(2, uniquePathsWithObstacles(obstacleGrid));


    }


}
