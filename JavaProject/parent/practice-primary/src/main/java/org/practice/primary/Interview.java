package org.practice.primary;

/**
 * @author yoong
 * <br>
 * @desc Interview
 * <br>
 * @date 2019/1/29 19:05
 */
public class Interview {

    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            equalTest();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * souche——2019年1月29日18:56:56
     */
    public static void equalTest() {
        int a = 1;
        Integer b = 1;
        Integer c = 1;
        System.out.println("a == b ? " + (a == b));//true
        System.out.println("b == c ? " + (b == c));//true

        String strA = "String";
        String strB = "String";
        System.out.println("strA == strB ? " + (strA == strB));//true
        System.out.println("strA.equals(strB) ? " + (strA.equals(strB)));//true
    }
}
