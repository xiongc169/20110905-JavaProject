package org.practice.algorithm.community01.ch01.inference;

/**
 * @Desc 递推思想(顺推 、 逆推)
 * PS：斐波那契数列、整存零取
 * https://www.cnblogs.com/huangxincheng/archive/2011/12/29/2305525.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2019年2月14日10:15:00
 * <p>
 * @Version 1.0
 */
public class App4Inference {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            Integer count = fibonacci();
            System.out.println(count);
            Integer count2 = fibonacciByRecursion(12);
            System.out.println(count2);
            getMoney();
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

    /**
     * 整存零取(递推-逆推)
     */
    public static void getMoney() {
        double balance = 3000;
        for (int i = 47; i > 0; i--) {
            balance = 3000 + balance / 1.001425;
        }
        System.out.println(balance);//139288.0661922625

        for (int i = 1; i <= 47; i++) {
            balance = (balance - 3000) * 1.001425;
        }
        System.out.println(balance);
    }
}
