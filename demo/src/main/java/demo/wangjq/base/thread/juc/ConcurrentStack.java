package demo.wangjq.base.thread.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 实现ABA问题
 *
 * @param <E>
 */
public class ConcurrentStack<E> {

    AtomicReference<Node<E>> top = new AtomicReference<>();

    public Node<E> push(Node<E> newHead) throws InterruptedException {
        Node<E> oldHead;
        do {
            oldHead = top.get();
            newHead.next = oldHead;
        } while (!top.compareAndSet(oldHead, newHead));
        return oldHead;
    }

    public Node<E> pop(boolean flag) throws InterruptedException {
        Node<E> oldHead;
        Node<E> newHead;
        do {
            oldHead = top.get();
            if (oldHead == null) {
                return null;
            }
            newHead = oldHead.next;
            if (flag) {
                TimeUnit.SECONDS.sleep(1);
            }
        } while (!top.compareAndSet(oldHead, newHead));
        return oldHead;
    }

    private static class Node<E> {
        public final E item;
        public Node<E> next;

        public Node(E item) {
            this.item = item;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "item=" + item +
                    ", next=" + next +
                    '}';
        }
    }


    @Override
    public String toString() {
        return "ConcurrentStack{" +
                "top=" + top.get() +
                '}';
    }

    public static void main(String[] args) throws InterruptedException {

        ConcurrentStack<String> concurrentStack = new ConcurrentStack<>();
        concurrentStack.push(new Node<>("B"));
        concurrentStack.push(new Node<>("A"));

        Thread t1 = new Thread(() -> {
            try {
                concurrentStack.pop(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        Thread t2 = new Thread(() -> {
            Node<String> item = null;
            try {
                item = concurrentStack.pop(false);
                concurrentStack.pop(false);
                concurrentStack.push(new Node<>("D"));
                concurrentStack.push(new Node<>("C"));
                concurrentStack.push(item);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t2.start();
        t1.join();
        t2.join();

        System.out.println(concurrentStack);
    }
}
