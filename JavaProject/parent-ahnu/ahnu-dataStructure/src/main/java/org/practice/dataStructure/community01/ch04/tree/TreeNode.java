package org.practice.dataStructure.community01.ch04.tree;

import lombok.Data;

/**
 * @Desc 二叉树的节点类(链式存储)
 * <p>
 * @Author yoong
 * <p>
 * @Date 2012-07-04 09:00:00
 * <p>
 * @Version 1.0
 */
@Data
public class TreeNode<T> {

    private T data;

    private TreeNode<T> parent;

    private TreeNode<T> left;

    private TreeNode<T> right;

    public TreeNode() {
    }

    public TreeNode(T data) {
        this.data = data;
    }
}
