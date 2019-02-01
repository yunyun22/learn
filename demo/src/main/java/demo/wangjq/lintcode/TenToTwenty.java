package demo.wangjq.lintcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import demo.wangjq.lintcode.TopTen.*;

/**
 * Created by wangjq on 2019/1/29.
 */
public class TenToTwenty {

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int i = 0;
        boolean flag = true;
        while (flag) {
            char cur, first;
            for (int j = 0; j < strs.length; j++) {
                if (i >= strs[j].length()) {
                    flag = false;
                    i = i - 1;
                    break;
                }
                first = strs[0].charAt(i);
                cur = strs[j].charAt(i);
                if (first != cur) {
                    flag = false;
                    i = i - 1;
                    break;
                }
            }
            i++;
        }
        return strs[0].substring(0, i);
    }

    @Test
    public void testLongestCommonPrefix() {
        System.out.println(longestCommonPrefix(new String[]{}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        return null;
    }

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < Math.pow(3, digits.length()); i++) {

        }
        return null;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode cur = head, preRemove = null;
        for (; cur != null; size++, cur = cur.next) ;
        cur = head;
        for (int i = 0; i < size - n && cur.next != null; i++) {
            preRemove = cur;
            cur = cur.next;
        }
        if (preRemove != null) {
            preRemove.next = preRemove.next.next;
        }
        return preRemove == null ? head.next : head;
    }

    @Test
    public void testRemoveNthFromEnd() {
        ListNode tail, head;
        tail = head = new ListNode(1);
        tail = tail.next = new ListNode(2);
//        tail = tail.next = new ListNode(3);
//        tail = tail.next = new ListNode(4);
//        tail = tail.next = new ListNode(5);

        System.out.println(removeNthFromEnd(head, 2));
    }

    public static boolean isValid(String s) {
        List<Character> left = Arrays.asList('{', '(', '[');
        List<Character> right = Arrays.asList('}', ')', ']');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (left.contains(c)) {
                stack.push(c);
            } else if (right.contains(c)
                    && !stack.isEmpty()
                    && right.indexOf(c) == left.indexOf(stack.pop())) {
                continue;
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void testIsValid() {
        System.out.println(isValid("["));
    }
}
