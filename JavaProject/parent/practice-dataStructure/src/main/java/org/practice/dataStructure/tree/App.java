package org.practice.dataStructure.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
java程序中index++和++index的区别
PS：假如 index=1，a=index++；那么 a=1，index=2；index++是先赋值给a，然后再加1；
	假如index=1，a=++index；那么 a=2，index=2；++index是index先加1变为2再赋值给a；
https://zhidao.baidu.com/question/139393793.html
*/
public class App {

    private static Scanner scanner = new Scanner(System.in);
    private static Integer index = 0;

    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            //构建二叉树
            TreeNode<String> root = new TreeNode();
            root.setData("1");
            //root = generateTree(root);
            //2345####67####
            //234567########
            List<String> data = Arrays.asList("234567########".split(""));
            root = generateTree(root, data);
            System.out.println(root.getData());

            //先、中、后序遍历二叉树
            preOrderTraversal(root);
            inOrderTraversal(root);
            postOrderTraversal(root);

            List<TreeNode> list = levelTraversal(root);
            System.out.println(list.size());

            //计算二叉树的深度
            int depth = 0;
            depth = getDepth(root, depth);
            System.out.println(depth);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 构建二叉树(2345####67####)
     *
     * @param root
     * @return
     */
    private static TreeNode<String> generateTree(TreeNode root) {
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
                generateTree(root.getLeft());
            }
            if (root.getRight() != null) {
                generateTree(root.getRight());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return root;
    }

    /**
     * 构建二叉树(2345####67####)
     *
     * @param root
     * @return
     */
    private static TreeNode<String> generateTree(TreeNode root, List<String> data) {
        try {
            String input = data.get(index++);
            System.out.println(index);
            if (!input.equals("#")) {
                TreeNode<String> left = new TreeNode();
                left.setData(input);
                root.setLeft(left);
            }

            input = data.get(index++);
            System.out.println(index);
            if (!input.equals("#")) {
                TreeNode<String> right = new TreeNode();
                right.setData(input);
                root.setRight(right);
            }

            if (root.getLeft() != null) {
                generateTree(root.getLeft(), data);
            }
            if (root.getRight() != null) {
                generateTree(root.getRight(), data);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return root;
    }

    /**
     * 先序遍历-递归
     *
     * @param root
     */
    private static void preOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.getData());
        if (root.getLeft() != null) {
            preOrderTraversal(root.getLeft());
        }
        if (root.getRight() != null) {
            preOrderTraversal(root.getRight());
        }
    }

    /**
     * 中序遍历-递归
     *
     * @param root
     */
    private static void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.getLeft() != null) {
            inOrderTraversal(root.getLeft());
        }
        System.out.println(root.getData());
        if (root.getRight() != null) {
            inOrderTraversal(root.getRight());
        }
    }

    /**
     * 后序遍历-递归
     *
     * @param root
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
        System.out.println(root.getData());
    }

    /**
     * 后序遍历-递归
     *
     * @param root
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
     * 二叉树深度
     *
     * @param root
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
