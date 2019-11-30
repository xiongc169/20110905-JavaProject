package org.practice.dataStructure.ch04.tree;

import java.util.Scanner;

/**
 * @Desc App4Tree3
 * @Author
 * @Date 2019年11月30日10:28:31
 * @Version 1.0
 */
public class App4Tree3 {

    /**
     * 二叉树的顺序存储
     */
    public static String[] seqTree = new String[]{};

    private static Scanner scanner = new Scanner(System.in);

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            //构建二叉树(顺序存储)
            seqTree = initSeqTree();

            //构建二叉树(链式存储)
            TreeNode<String> root = new TreeNode<>();
            root.setData("1");
            //initLinkedTreeByInput(root);
            System.out.println("root.getData: " + root.getData());

            //构建二叉树(链式存储)
            TreeNode<String> root2 = new TreeNode<>();
            root2.setData("1");
            initLinkedTreeByPreOrder(root2);
            System.out.println("root2.getData: " + root2.getData());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 构建二叉树(顺序存储)
     */
    public static String[] initSeqTree() {
        seqTree = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"};
        return seqTree;
    }

    /**
     * 构建二叉树(按左子树优先构建)
     * 输入：2 3 4 5 6 7 8 9 10 11 ############
     */
    public static void initLinkedTreeByInput(TreeNode<String> root) {
        String input = scanner.nextLine();
        if (!input.equals("#")) {
            TreeNode<String> left = new TreeNode<>();
            left.setData(input);
            root.setLeft(left);
        }
        input = scanner.nextLine();
        if (!input.equals("#")) {
            TreeNode<String> right = new TreeNode<>();
            right.setData(input);
            root.setRight(right);
        }
        if (root.getLeft() != null) {
            initLinkedTreeByInput(root.getLeft());
        }
        if (root.getRight() != null) {
            initLinkedTreeByInput(root.getRight());
        }
    }

    /**
     * 构建二叉树(按左子树优先构建)
     * 输入：2 3 4 5 6 ###### 7 ##
     */
    public static void initLinkedTreeByPreOrder(TreeNode<String> root) {
        String input = scanner.nextLine();
        if (!input.equals("#")) {
            TreeNode<String> left = new TreeNode<>();
            left.setData(input);
            root.setLeft(left);
        }
        if (root.getLeft() != null) {
            initLinkedTreeByPreOrder(root.getLeft());
        }
        input = scanner.nextLine();
        if (!input.equals("#")) {
            TreeNode<String> right = new TreeNode<>();
            right.setData(input);
            root.setRight(right);
        }
        if (root.getRight() != null) {
            initLinkedTreeByPreOrder(root.getRight());
        }
    }
}
