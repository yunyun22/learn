package demo.wangjq.algorithm.list;

import org.junit.Assert;
import org.junit.Test;


public class LinkedListProblem {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    /**
     * @param listNode
     * @return
     */
    public static ListNode reverse(ListNode listNode) {
        ListNode pre = null;
        ListNode next = listNode;

        for (; next != null; ) {
            ListNode current = next;
            next = next.next;
            current.next = pre;
            pre = current;
        }
        return pre;
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
