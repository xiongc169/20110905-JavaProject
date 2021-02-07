package com.yoong.dataStructure.community01.ch04.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Desc AppTree
 * <p>
 * @Author yoong
 * <p>
 * @Date 2012-07-04 09:00:00
 * <p>
 * @Version 1.0
 */
public class AppTree {

    private static Scanner scanner = new Scanner(System.in);

    /**
     * 递归的全局变量
     */
    private static Integer index = 0;

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            //构建二叉树，手动输入：2345####67####
            //TreeNode<String> root = new TreeNode();
            //root.setData("1");
            //root = genTreeByInput(root);
            //System.out.println("root.Data: " + root.getData());

            //构建二叉树，免输入，入参：2345####67####，234567########，1234589######6##7##
            TreeNode<String> root2 = new TreeNode();
            root2.setData("1");
            List<String> data = Arrays.asList("234589######67####".split(""));
            root2 = genTreeByData(root2, data);
            System.out.println("root2.Data: " + root2.getData());

            //先序遍历
            preOrderTraversal(root2);
            System.out.println("Finished PreOrder");

            //中序遍历
            inOrderTraversal(root2);
            System.out.println("Finished InOrder");

            //后序遍历
            postOrderTraversal(root2);
            System.out.println("Finished PostOrder");

            //按层遍历
            List<TreeNode> list = levelTraversal(root2);
            System.out.println("root.Level: " + list.size());

            //计算深度
            int depth = 0;
            depth = getDepth(root2, depth);
            System.out.println("root.Depth: " + depth);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Ending App4Tree");
    }

    /**
     * 构建二叉树(按左子树优先构建，手动输入)
     * 输入：2345####67####
     */
    private static TreeNode<String> genTreeByInput(TreeNode root) {
        try {
            String input = scanner.nextLine();
            if (!input.equals("#")) {
                TreeNode<String> left = new TreeNode();
                left.setData(input);
                root.setLeft(left);
            }
            input = scanner.nextLine();
            if (!input.equals("#")) {
                TreeNode<String> right = new TreeNode();
                right.setData(input);
                root.setRight(right);
            }

            if (root.getLeft() != null) {
                genTreeByInput(root.getLeft());
            }
            if (root.getRight() != null) {
                genTreeByInput(root.getRight());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return root;
    }

    /**
     * 构建二叉树(按左子树优先构建，免输入)
     * 入参：2345####67####、234567########
     */
    private static TreeNode<String> genTreeByData(TreeNode root, List<String> data) {
        try {
            String input = data.get(index++);
            if (!input.equals("#")) {
                TreeNode<String> left = new TreeNode();
                left.setData(input);
                root.setLeft(left);
            }
            input = data.get(index++);
            if (!input.equals("#")) {
                TreeNode<String> right = new TreeNode();
                right.setData(input);
                root.setRight(right);
            }

            if (root.getLeft() != null) {
                genTreeByData(root.getLeft(), data);
            }
            if (root.getRight() != null) {
                genTreeByData(root.getRight(), data);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return root;
    }

    /**
     * 先序遍历(递归)
     */
    private static void preOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.getData() + "-");
        if (root.getLeft() != null) {
            preOrderTraversal(root.getLeft());
        }
        if (root.getRight() != null) {
            preOrderTraversal(root.getRight());
        }
    }

    /**
     * 中序遍历(递归)
     */
    private static void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.getLeft() != null) {
            inOrderTraversal(root.getLeft());
        }
        System.out.print(root.getData() + "-");
        if (root.getRight() != null) {
            inOrderTraversal(root.getRight());
        }
    }

    /**
     * 后序遍历(递归)
     */
    private static void postOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.getLeft() != null) {
            postOrderTraversal(root.getLeft());
        }
        if (root.getRight() != null) {
            postOrderTraversal(root.getRight());
        }
        System.out.print(root.getData() + "-");
    }

    /**
     * 按层遍历
     */
    private static List<TreeNode> levelTraversal(TreeNode root) {
        List<TreeNode> queue = new ArrayList<>();
        if (root != null) {
            queue.add(root);
        }
        int index = 0;
        while (queue.get(index) != null) {
            queue.add(queue.get(index).getLeft());
            queue.add(queue.get(index).getRight());
            index++;
        }
        return queue;
    }

    /**
     * 计算深度(递归)
     */
    private static int getDepth(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        depth += 1;
        Integer leftDepth = getDepth(root.getLeft(), depth);
        Integer rightDepth = getDepth(root.getRight(), depth);
        return Math.max(leftDepth, rightDepth);
    }
}
