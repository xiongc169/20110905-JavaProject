package org.practice.algorithm.community01.ch04.enums;

/**
 * @Desc 枚举法(穷举法)
 * PS：
 * https://www.cnblogs.com/huangxincheng/archive/2012/01/07/2315945.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2019年2月14日10:15:00
 * <p>
 * @Version 1.0
 */
public class AppEnums {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            enums();
            enums2();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 79365 * 7 = 555555
     */
    public static void enums() {
        int[] resultList = {111111, 222222, 333333, 444444, 555555, 666666, 777777, 888888, 999999};
        int[] divList = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int result : resultList) {
            for (int div : divList) {
                int multi = result / div;
                String start = String.valueOf(div);
                String end = String.valueOf(result % 10);
                String multiStr = String.valueOf(multi);
                if (multiStr.startsWith(start) && multiStr.endsWith(end)) {
                    System.out.println(multi + " * " + div + " = " + result);
                }
            }
        }
    }

    /**
     * 79365 * 7 = 555555
     */
    public static void enums2() {
        for (int a = 1; a <= 9; a++) {
            for (int b = 1; b <= 9999; b++) {
                for (int c = 1; c <= 9; c++) {
                    int multi1 = (a * 10000 + b + c);
                    int multiResult = multi1 * a;
                    int expectResult = 111111 * c;
                    if (multiResult == expectResult && multi1 % 10 == c) {
                        System.out.println(multi1 + " * " + a + " = " + expectResult);
                    }
                }
            }
        }
    }
}
