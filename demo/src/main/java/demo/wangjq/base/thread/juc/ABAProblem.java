package demo.wangjq.base.thread.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import demo.wangjq.algorithm.lintcode.TopTen.*;

/**
 * @author wangjq
 */
public class ABAProblem {


    public static void main(String[] args) {
        AtomicReference<ListNode> listNodeAtomicReference = new AtomicReference<>();


        ListNode listNode = new ListNode(0);
        ListNode top = listNode;
        listNode.next = new ListNode(1);

        listNodeAtomicReference.set(top);

        Thread t = new Thread(() -> {
            ListNode second = top.next;
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            listNodeAtomicReference.compareAndSet(top, second);
        });

        Thread t2 = new Thread(() -> {

        });

    }

}
