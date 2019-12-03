package org.practice.algorithm.ch02.recursion;

/**
 * @Desc 递归
 * @Author
 * @Date
 * @Version 1.0
 */
public class App4Recursion {

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
