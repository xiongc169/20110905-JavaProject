package org.practice.algorithm.ch01.recursion;

/**
 * @Desc 递推(顺推 、 逆推)
 * @Author
 * @Date
 * @Version 1.0
 */
public class App4Recursion {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            Integer count = fibonacci();
            System.out.println(count);
            Integer count2 = fibonacciByRecursion(12);
            System.out.println(count2);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 斐波那契数列(非递归)
     */
    public static Integer fibonacci() {
        Integer month = 12;
        Integer[] fab = new Integer[12];
        fab[0] = 1;
        fab[1] = 1;
        for (int i = 2; i < month; i++) {
            fab[i] = fab[i - 1] + fab[i - 2];
        }
        return fab[month - 1];
    }

    /**
     * 斐波那契数列(递归)
     */
    public static Integer fibonacciByRecursion(Integer n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibonacciByRecursion(n - 1) + fibonacciByRecursion(n - 2);
        }
    }

}
