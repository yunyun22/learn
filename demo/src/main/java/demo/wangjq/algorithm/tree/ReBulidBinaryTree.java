package demo.wangjq.algorithm.tree;

import demo.wangjq.ArraysUtil;

import java.util.Arrays;

import static demo.wangjq.ArraysUtil.getLength;

public class ReBulidBinaryTree {

    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] midorder = {4, 7, 2, 1, 5, 3, 8, 6};
        Node node = reBulidBinaryTree(preorder, midorder);

        preorder(node);
        System.out.println();
        midorder(node);

    }

    public static Node reBulidBinaryTree(int[] preorder, int[] midorder) {
        return Node.reBuild(preorder, midorder);
    }

    /**
     * 前序遍历
     *
     * @param node
     */
    public static void preorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        preorder(node.left);
        preorder(node.right);
    }

    /**
     * 中序遍历
     *
     * @param node
     */
    public static void midorder(Node node) {
        if (node == null) {
            return;
        }
        midorder(node.left);
        System.out.print(node.value + " ");
        midorder(node.right);
    }


    /**
     * 定义二叉树的数据结构
     */
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

        /**
         * 重构二叉树
         *
         * @param preorder
         * @param midorder
         * @return
         */
        public static Node reBuild(int[] preorder, int[] midorder) {
            if (preorder.length <= 0 || midorder.length <= 0) {
                return null;
            }

            int root = preorder[0];
            /**
             * root 节点在中序中的位置
             */
            int indexOfRoot = ArraysUtil.indexof(midorder, root);
            /**
             * 构建左子树
             */
            int rightLength = indexOfRoot;
            int[] leftPreorder = Arrays.copyOfRange(preorder, 1, rightLength + 1);
            int[] leftMidorder = Arrays.copyOfRange(midorder, 0, rightLength);

            Node left = reBuild(leftPreorder, leftMidorder);
            /**
             * 构建右子树
             */
            int leftLength = indexOfRoot + 1;
            int[] rightPreorder = Arrays.copyOfRange(preorder, leftLength, preorder.length);
            int[] rightMidorder = Arrays.copyOfRange(midorder, leftLength, midorder.length);

            Node right = reBuild(rightPreorder, rightMidorder);

            return new Node(left, right, root);
        }

    }
}


