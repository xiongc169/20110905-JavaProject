package org.practice.dataStructure.tree;

import java.util.Scanner;

/**
 * @Desc App2
 * @Author
 * @Date 2019年7月8日11:27:33
 * @Version 1.0
 */
public class App2 {

    public static void main(String[] args) {
        TreeNode<String> root = new TreeNode();
        try {
            buildTree(root);
            preOrder(root);
            System.out.println("Finished PreOrder");
            midOrder(root);
            System.out.println("Finished MidOrder");
            postOrder(root);
            System.out.println("Finished PostOrder");
            int depth = 1;
            depth = getDepth(root, depth);
            System.out.println("Finished getDepth:" + depth);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Ending Tree");
    }

    /**
     * 1 2 3 4 5 # # # # 6 7 # # # #
     * 1 2 3 4 5 8 9 # # # # 10 11 # # # # 6 7 12 13 # # # # 14 15 # # # #
     */
    public static void buildTree(TreeNode root) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (root.getData() == null) {
            root.setData(input);
            input = scanner.nextLine();
        }
        if (root.getLeft() == null) {
            TreeNode left = new TreeNode(input);
            root.setLeft(left);
            input = scanner.nextLine();
        }
        if (root.getRight() == null) {
            TreeNode right = new TreeNode(input);
            root.setRight(right);
        }
        if (!root.getLeft().getData().equals("#")) {
            buildTree(root.getLeft());
        }
        if (!root.getRight().getData().equals("#")) {
            buildTree(root.getRight());
        }
    }

    public static void preOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.getData() + "  ");
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    public static void midOrder(TreeNode root) {
        if (root != null) {
            midOrder(root.getLeft());
            System.out.print(root.getData() + "  ");
            midOrder(root.getRight());
        }
    }

    public static void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.print(root.getData() + "  ");
        }
    }

    public static int getDepth(TreeNode root, int depth) {
        if (root.getLeft() == null && root.getRight() == null) {
            return depth;
        }
        depth++;
        int leftDepth = getDepth(root.getLeft(), depth);
        int rightDepth = getDepth(root.getRight(), depth);
        return Math.max(leftDepth, rightDepth);
    }
}
