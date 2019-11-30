package org.practice.dataStructure.ch04.tree;

import lombok.Data;

/**
 * 二叉树的节点类(链式存储)
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
