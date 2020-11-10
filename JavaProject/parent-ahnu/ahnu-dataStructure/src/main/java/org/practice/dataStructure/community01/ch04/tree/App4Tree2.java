package org.practice.dataStructure.community01.ch04.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Desc App4Tree2
 * <p>
 * @Author yoong
 * <p>
 * @Date 2012-07-04 09:00:00
 * <p>
 * @Version 1.0
 */
public class App4Tree2 {

    private static Scanner scanner = new Scanner(System.in);

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            //构建二叉树
            TreeNode<String> root = new TreeNode();
            buildTree(root);

            //先序遍历
            preOrder(root);
            System.out.println("Finished PreOrder");
            //中序遍历
            inOrder(root);
            System.out.println("Finished InOrder");
            //后序遍历
            postOrder(root);
            System.out.println("Finished PostOrder");

            //计算深度
            int depth = 1;
            depth = getDepth(root, depth);
            System.out.println("root.Depth: " + depth);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Ending App4Tree2");
    }

    /**
     * 构建二叉树(按左子树优先构建，手动输入)
     * 1 2 3 4 5 # # # # 6 7 # # # #
     * 1 2 3 4 5 8 9 # # # # 10 11 # # # # 6 7 12 13 # # # # 14 15 # # # #
     */
    public static void buildTree(TreeNode root) {
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

    /**
     * 先序遍历(递归)
     */
    public static void preOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.getData() + "  ");
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    /**
     * 中序遍历(递归)
     */
    public static void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.getLeft());
            System.out.print(root.getData() + "  ");
            inOrder(root.getRight());
        }
    }

    /**
     * TODO：中序遍历(非递归，循环)
     */
    public static void inOrderIterator(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        while (root != null) {
            nodes.add(root);
            root = root.getLeft();
            System.out.println(root.getData());

        }
    }

    /**
     * 后序遍历(递归)
     */
    public static void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.print(root.getData() + "  ");
        }
    }

    /**
     * 计算深度(递归)
     */
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
