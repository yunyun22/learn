package demo.wangjq.algorithm.tree;

/**
 * delete binary tree
 *
 * Created by wangjq on 2018/6/19.
 */
public class Tree {

    public static void main(String[] args) {
        Tree avlTree = new Tree();

        avlTree.insert(5);
        avlTree.insert(2);
        avlTree.insert(6);
        avlTree.insert(9);
        avlTree.insert(0);
        avlTree.insert(1);
        avlTree.insert(8);

        avlTree.prePrintTree();
        System.out.println();
        avlTree.midPrintTree();
        System.out.println();
        System.out.println("the min value is :" + avlTree.getMin());
        avlTree.delete(5);

        avlTree.midPrintTree();


    }

    private Node root;

    public Tree() {
    }


    public void prePrintTree() {
        preorder(root);
    }

    public void midPrintTree() {
        midorder(root);
    }

    public Integer getMin() {
        return minNode(root).getValue();
    }

    /**
     * 中序遍历
     */
    private void midorder(Node node) {
        if (node == null) {
            return;
        }
        midorder(node.getLeftNode());
        System.out.print(node.getValue() + " ");
        midorder(node.getRightNode());
    }

    /**
     * 前序遍历
     */
    private void preorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getValue() + " ");
        preorder(node.getLeftNode());
        preorder(node.getRightNode());
    }

    /**
     * 通过递归将node 插入到树中
     * @param value
     * @param node
     * @return
     */
    private Node insertNode(Integer value, Node node) {
        if (node == null) {
            return new Node(null, null, value);
        }
        int cmp = node.getValue().compareTo(value);

        if (cmp == -1) {
            node.setLeftNode(insertNode(value, node.getLeftNode()));
        } else if (cmp == 1) {
            node.setRightNode(insertNode(value, node.getRightNode()));
        } else {
            return null;
        }
        return null;
    }

    /**
     * 二叉树插入操作
     */
    public boolean insert(Integer value) {
        if (this.root == null) {
            this.root = new Node(null, null, value);
            return true;
        } else {
            Node node = root;
            Node parent = null;
            int cmp = 0;
            while (node != null) {
                parent = node;
                cmp = node.getValue().compareTo(value);
                if (cmp == -1) {
                    node = node.getRightNode();
                } else if (cmp == 1) {
                    node = node.getLeftNode();
                } else {
                    return false;
                }
            }
            node = new Node(null, null, value);
            if (cmp > 0) {
                parent.setLeftNode(node);
            } else {
                parent.setRightNode(node);
            }
            return true;
        }
    }

    /**
     * 删除
     */
    public boolean delete(Integer value) {
        if (this.root == null) {
            return false;
        } else {
            Node node = root;
            Node parent = null;
            int cmp = 0;
            while (node != null) {
                cmp = node.getValue().compareTo(value);
                if (cmp == -1) {
                    parent = node;
                    node = node.getRightNode();
                } else if (cmp == 1) {
                    parent = node;
                    node = node.getLeftNode();
                } else {
                    break;
                }
            }
            if (node == null) {
                return false;
            }
            Node leftNode = node.getLeftNode();
            Node rihgtNode = node.getRightNode();


            /**
             * 1.左右子树均为空，直接删除当前节点
             * 2.左子树为空右子树不为空
             * 3.左子数不为空右子树为空
             * 4.左右子树均不为空，找到右子树的最左节点
             */
            if (leftNode == null && rihgtNode == null) {
                if (cmp > 0) {
                    parent.setLeftNode(null);
                } else {
                    parent.setRightNode(null);
                }
            } else if (leftNode != null && rihgtNode == null) {
                parent.setLeftNode(node.getLeftNode());
                node.setLeftNode(null);
            } else if (leftNode == null && rihgtNode != null) {
                parent.setRightNode(node.getRightNode());
                node.setRightNode(null);
            } else {
                /**
                 * 找当前节点右子树的最小节点
                 */
                Node cNode = node.getRightNode();
                Node parentCNode = node;
                while (cNode.getLeftNode() != null) {
                    parentCNode = cNode;
                    cNode = cNode.getLeftNode();
                }
                node.setValue(cNode.getValue());
                parentCNode.setRightNode(cNode.getRightNode());
                cNode.setRightNode(null);
            }


            return false;
        }


    }

    private Node minNode(Node node) {

        if (node == null) {
            throw new RuntimeException("node is not null");
        }

        Node cNode = node;

        while (cNode.getLeftNode() != null) {
            cNode = cNode.getLeftNode();
        }
        return cNode;
    }
}


/**
 *
 */
class Node {
    private Node leftNode;
    private Node rightNode;
    private Integer value;


    /**
     *
     * @param leftNode
     * @param rightNode
     * @param value
     */
    public Node(Node leftNode, Node rightNode, Integer value) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.value = value;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}