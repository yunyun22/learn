package demo.wangjq.algorithm.tree;

import java.util.Iterator;

/**
 * 红黑树实现
 */
public class RedBlackTree<T> {

    /**
     * 根节点
     */
    private Node<T> root;

    /**
     * 红黑树节点数量
     */
    private int size;

    public RedBlackTree() {
    }


    /**
     * T 必须实现 Comparable 接口
     *
     * @param value
     * @return
     */
    public T add(T value) {
        if (value == null) {
            throw new RuntimeException("value is not null");
        }
        if (root == null) {
            root = new Node<>(value, Color.BLACK);
            return null;
        }
        Comparable<? super T> comparable = (Comparable<? super T>) value;

        Node<T> parent = root;

        int cmp;

        while (parent != null) {
            cmp = comparable.compareTo(parent.value);
            if (cmp > 0) {
                parent = parent.left;
            } else if (cmp < 0) {
                parent = parent.right;
            } else {
                return parent.value;
            }
        }
        parent = new Node<T>(value, Color.RED);
        size++;
        return null;
    }

    enum Color {
        BLACK, RED
    }

    /**
     * 红黑树节点
     */
    static final class Node<T> implements demo.wangjq.algorithm.tree.Node {

        Node left;
        Node right;
        T value;
        Color color;

        public Node(T value, Color color) {
            this.value = value;
            this.color = color;
        }

        public Node(Node left, Node right, T value, Color color) {
            this.left = left;
            this.right = right;
            this.value = value;
            this.color = color;
        }

        @Override
        public T getValue() {
            return value;
        }

        @Override
        public demo.wangjq.algorithm.tree.Node getRigt() {
            return right;
        }

        @Override
        public demo.wangjq.algorithm.tree.Node getLeft() {
            return left;
        }
    }

    private class MidItr implements Iterator<T> {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            return null;
        }
    }
}
