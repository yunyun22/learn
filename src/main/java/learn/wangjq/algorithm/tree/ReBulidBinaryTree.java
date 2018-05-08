package learn.wangjq.algorithm.tree;

import java.util.Arrays;

import static learn.wangjq.ArraysUtil.getLength;

public class ReBulidBinaryTree {


    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] midorder = {4, 7, 2, 1, 5, 3, 8, 6};
        reBulidBinaryTree(preorder, midorder);
    }

    public static Node reBulidBinaryTree(int[] preorder, int[] midorder) {
        Node root = new Node(preorder, midorder);
        return null;
    }


    private static class Node {
        private Node left;
        private Node right;
        private Object value;
        private int[] sonTreeValue;

        public Node() {
        }

        public Node(Node left, Node right, Object value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }

        public Node(int[] preorder, int[] midorder) {


            int root = preorder[0];

            midorder = Arrays.copyOfRange(midorder, 0, getLength(midorder, root));
            preorder = Arrays.copyOfRange(preorder, 1, midorder.length + 1);

            Node left = new Node(preorder, midorder);

            midorder = Arrays.copyOfRange(midorder, getLength(midorder, root), midorder.length);
            preorder = Arrays.copyOfRange(preorder, midorder.length + 1, preorder.length);

            Node right = new Node(preorder, midorder);

        }

    }
}


