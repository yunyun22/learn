package demo.wangjq.algorithm.tree;

/**
 * 定义二叉树节点
 *
 * @param <T>
 */
public interface Node<T> {


    /**
     * 获取当前节点的值
     *
     * @return
     */
    T getValue();

    /**
     * 获取右边节点
     *
     * @return
     */
    Node getRigt();

    /**
     * 获取左边节点
     *
     * @return
     */
    Node getLeft();


}
