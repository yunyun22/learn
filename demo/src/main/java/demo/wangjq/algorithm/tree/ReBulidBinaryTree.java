package demo.wangjq.algorithm.tree;

import learn.wangjq.ArraysUtil;

import java.util.Arrays;

import static learn.wangjq.ArraysUtil.getLength;

public class ReBulidBinaryTree {


    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] midorder = {4, 7, 2, 1, 5, 3, 8, 6};
        reBulidBinaryTree(preorder, midorder);
    }

    public static Node reBulidBinaryTree(int[] preorder, int[] midorder) {
        return Node.reBuild(preorder, midorder);
    }


    private static class Node {
        private Node left;
        private Node right;
        private Object value;

        public Node() {
        }

        public Node(Node left, Node right, Object value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }

        public static Node reBuild(int[] preorder, int[] midorder) {


            int root = preorder[0];
            int indexOfRoot = ArraysUtil.indexof(midorder, root);

            /**
             * 构建左子树
             */
            Node left = null;

            if (getLength(midorder, root) > 0 && midorder.length + 1 > 1) {

                int rightLength = indexOfRoot;

                left = reBuild(
                        Arrays.copyOfRange(preorder, 1, rightLength + 1),
                        Arrays.copyOfRange(midorder, 0, rightLength));
            }
            /**
             * 构建右子树
             */
            Node right = null;
            if (midorder.length > getLength(midorder, root) && preorder.length > midorder.length + 1) {

                int leftLength = indexOfRoot + 1;

                right = reBuild(
                        Arrays.copyOfRange(preorder, leftLength, preorder.length),
                        Arrays.copyOfRange(midorder, leftLength, midorder.length));
            }

            return new Node(left, right, root);
        }

    }
}


