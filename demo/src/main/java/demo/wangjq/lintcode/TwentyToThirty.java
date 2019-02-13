package demo.wangjq.lintcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import demo.wangjq.lintcode.TopTen.*;

/**
 * Created by wangjq on 2019/2/1.
 */
public class TwentyToThirty {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode start = new ListNode(0);
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode c1 = l1, c2 = l2, cur = start;
        for (; c1 != null && c2 != null; ) {
            ListNode temp = c1.val < c2.val ? c1 : c2;
            cur.next = temp;
            cur = cur.next;
            c1 = temp == c1 ? c1.next : c1;
            c2 = temp == c2 ? c2.next : c2;
        }
        if (c1 != null) {
            cur.next = c1;
        }
        if (c2 != null) {
            cur.next = c2;
        }
        return start.next;
    }

    @Test
    public void testMergeTwoLists() {
        ListNode temp, l1 = new ListNode(1);
        temp = l1;
        temp = temp.next = new ListNode(2);
        temp.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        temp = l2;
        temp = temp.next = new ListNode(3);
        temp.next = new ListNode(4);
        mergeTwoLists(l1, l2);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0), tail = head;
        ListNode[] current = lists;
        int minIndex = 0;
        while (minIndex > -1) {
            minIndex = -1;
            for (int i = 0; i < current.length; i++) {
                minIndex = minIndex == -1 && current[i] != null ? i : minIndex;
                minIndex = current[i] != null && current[i].val < current[minIndex].val ? i : minIndex;
            }
            if (minIndex != -1) {
                tail.next = current[minIndex];
                tail = tail.next;
                current[minIndex] = current[minIndex].next;
            }
        }
        return head.next;
    }

    @Test
    public void testMergeKLists() {

        ListNode temp, l1 = new ListNode(1);
        temp = l1;
        temp = temp.next = new ListNode(2);
        temp.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        temp = l2;
        temp = temp.next = new ListNode(3);
        temp.next = new ListNode(4);
        ListNode l3 = new ListNode(8);
        temp = l3;
        temp = temp.next = new ListNode(9);
        temp.next = new ListNode(10);
        List<ListNode> list = new ArrayList<>();
        list.add(l1);
        list.add(l2);
        list.add(l3);
        mergeKLists(list.toArray(new ListNode[list.size()]));
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode start = new ListNode(0), tail = start, cur = head;
        for (; cur != null; ) {
            ListNode preParis = cur;
            ListNode paris = cur.next;
            if (paris != null) {
                tail.next = paris;
                cur = cur.next.next;
                tail.next.next = preParis;
                preParis.next = null;
                tail = tail.next.next;
            } else {
                tail.next = cur;
                cur = cur.next;
            }
        }
        return start.next;
    }

    @Test
    public void testSwapPairs() {
        ListNode temp, l1 = new ListNode(1);
        temp = l1;
        temp = temp.next = new ListNode(2);
        temp = temp.next = new ListNode(3);
        temp = temp.next = new ListNode(4);
        temp.next = new ListNode(5);
        swapPairs(l1);
    }
}
