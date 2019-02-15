package demo.wangjq.algorithm.list;

import org.junit.Assert;
import org.junit.Test;

import demo.wangjq.lintcode.TopTen;


public class LinkedListProblem {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    /**
     * @param head
     * @return
     */
    public static ListNode reverse(ListNode head) {
        ListNode start = new ListNode(0);
        for (; head != null; ) {
            ListNode cur = head;
            head = head.next;
            cur.next = start.next;
            start.next = cur;
        }
        return start.next;
    }

    @Test
    public void testReverse() {
        ListNode listNode = new ListNode(1);
        ListNode head = listNode;
        listNode.next = new ListNode(2);
        listNode = listNode.next;
        listNode.next = new ListNode(3);
        listNode = listNode.next;
        listNode.next = new ListNode(4);
        listNode = listNode.next;
        listNode.next = new ListNode(5);
        Assert.assertTrue(isOrder(reverse(head)));
    }

    public static boolean isOrder(ListNode listNode) {
        ListNode pre = null;
        ListNode current = listNode;
        for (; current.next != null; ) {
            pre = current;
            current = current.next;
            if (pre.val < current.val) {
                return false;
            }
        }
        return true;
    }

}
