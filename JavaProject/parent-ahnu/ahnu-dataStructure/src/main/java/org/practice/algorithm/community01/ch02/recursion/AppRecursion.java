package org.practice.algorithm.community01.ch02.recursion;

/**
 * @Desc 递归算法
 * PS：二叉树先序、中序、后序遍历
 * https://www.cnblogs.com/huangxincheng/archive/2011/12/30/2306875.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2019年2月14日10:15:00
 * <p>
 * @Version 1.0
 */
public class AppRecursion {

    private static Integer count = 0;

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            Integer sum = factorial(10);
            System.out.println(sum);
            Integer count = stairs(10);
            System.out.println(count);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 阶乘
     */
    public static Integer factorial(Integer n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static Integer stairs(Integer n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return count + stairs(n - 2);
    }
}
