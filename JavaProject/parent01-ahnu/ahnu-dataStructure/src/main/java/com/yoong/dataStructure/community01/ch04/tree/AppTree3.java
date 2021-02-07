package com.yoong.dataStructure.community01.ch04.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @Desc AppTree3
 * <p>
 * @Author yoong
 * <p>
 * @Date 2012-07-04 09:00:00
 * <p>
 * @Version 1.0
 */
public class AppTree3 {

    /**
     * 二叉树的顺序存储
     */
    public static String[] seqTree = new String[]{};

    private static Scanner scanner = new Scanner(System.in);

    /**
     * 递归的全局变量
     */
    //private static Integer start = 0;

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            //构建二叉树(顺序存储)
            //seqTree = initSeqTree();

            //构建二叉树(链式存储，左子树构建，手动输入)
            //TreeNode<String> root = new TreeNode<>();
            //root.setData("1");
            //initLinkedTreeByInput(root);
            //System.out.println("root.getData: " + root.getData());

            //构建二叉树(链式存储，先序构建，手动输入)
            //TreeNode<String> root2 = new TreeNode<>();
            //root2.setData("1");
            //initLinkedTreeByPreOrder(root2);
            //System.out.println("root2.getData: " + root2.getData());

            //构建二叉树(链式存储，先序构建，免输入)
            //入参：23456######7##、248G##H##9##5A##B##36C##D##7E##F##
            Integer start = 0;
            String nodeData = "248G##H##9##5A##B##36C##D##7E##F##";
            TreeNode<String> root3 = new TreeNode<>();
            root3.setData("1");
            initLinkedTreeByPreOrderData(root3, nodeData, start);
            System.out.println("root3.getData: " + root3.getData());

            //检索二叉树
            boolean isContain = false;
            isContain = searchTree(root3, "7", isContain);
            System.out.println("isContain " + isContain);

            Integer depth = getDepth(root3);
            System.out.println("depth " + depth);

            //先序遍历二叉树
            preOrder(root3);
            System.out.println();

            //中序遍历二叉树
            inOrder(root3);
            System.out.println();

            //后序遍历二叉树
            postOrder(root3);
            System.out.println();

            Deque<TreeNode> queue = new ArrayDeque<>();
            levelTraversal(root3, queue);
            System.out.println(queue.size());
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

    /**
     * 构建二叉树(按左子树优先构建)
     * 输入：23456######7##
     */
    public static Integer initLinkedTreeByPreOrderData(TreeNode<String> root, String nodeData, Integer start) {
        if (start > nodeData.length()) {
            return start;
        }
        String input = nodeData.substring(start++, start);
        if (!input.equals("#")) {
            TreeNode<String> left = new TreeNode<>();
            left.setData(input);
            root.setLeft(left);
        }
        if (root.getLeft() != null) {
            start = initLinkedTreeByPreOrderData(root.getLeft(), nodeData, start);
        }
        input = nodeData.substring(start++, start);
        if (!input.equals("#")) {
            TreeNode<String> right = new TreeNode<>();
            right.setData(input);
            root.setRight(right);
        }
        if (root.getRight() != null) {
            start = initLinkedTreeByPreOrderData(root.getRight(), nodeData, start);
        }
        return start;
    }

    /**
     * 检索二叉树
     */
    public static boolean searchTree(TreeNode<String> root, String keyword, boolean isContain) {
        if (root == null) {
            return false;
        }
        if (root.getData() != null && root.getData().equals(keyword)) {
            System.out.println("Get It ! " + root.getData());
            return true;
        }
        isContain = isContain || searchTree(root.getLeft(), keyword, isContain);
        isContain = isContain || searchTree(root.getRight(), keyword, isContain);
        return isContain;
    }

    /**
     * 检索二叉树
     */
    public static Integer getDepth(TreeNode<String> root) {
        if (root == null) {
            return 0;
        }
        Integer left = getDepth(root.getLeft()) + 1;
        Integer right = getDepth(root.getRight()) + 1;
        return Math.max(left, right);
    }

    /**
     * 先序遍历二叉树
     */
    public static void preOrder(TreeNode<String> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.getData() + " ");
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    /**
     * 中序遍历二叉树
     */
    public static void inOrder(TreeNode<String> root) {
        if (root == null) {
            return;
        }
        inOrder(root.getLeft());
        System.out.print(root.getData() + " ");
        inOrder(root.getRight());
    }

    /**
     * 后序遍历二叉树
     */
    public static void postOrder(TreeNode<String> root) {
        if (root == null) {
            return;
        }
        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print(root.getData() + " ");
    }

    /**
     *
     */
    public static void levelTraversal(TreeNode<String> root, Deque<TreeNode> queue) {
        boolean isHead = true;
        TreeNode node = root;
        do {
            if (isHead) {
                queue.add(root);
            }
            if (node != null && node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if (node != null && node.getRight() != null) {
                queue.add(node.getRight());
            }
            if (isHead) {
                node = queue.pop();
                System.out.print(node.getData() + " ");
                isHead = false;
            }
            node = queue.pop();
            System.out.print(node.getData() + " ");
        } while (queue.size() > 0);
    }
}
