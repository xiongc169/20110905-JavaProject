package org.practice.primary.interview;

import org.practice.primary.community.domain.User;

/**
 * @Desc Interview
 * <p>
 * @Author yoong
 * <p>
 * @Date 2019/1/29 19:05
 * <p>
 * @Version 1.0
 */
public class Interview {

    public static final String flag = "flag";

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            //flag = "flag-2";
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
        Integer d = new Integer(1);
        System.out.println("a == b  " + (a == b));//true
        System.out.println("b == c  " + (b == c));//true
        System.out.println("c == d  " + (c == d));//false
        System.out.println();

        String strA = "String";
        String strB = "String";
        String strC = new String("String");
        System.out.println("strA == strB  " + (strA == strB));//true
        System.out.println("strA.equals(strB)  " + (strA.equals(strB)));//true
        System.out.println("strA == strC  " + (strA == strC));//false
        System.out.println("strA.equals(strC)  " + (strA.equals(strC)));//true
        System.out.println();

        Object objectA = new Object();
        Object objectB = new Object();
        System.out.println("objectA.equals(objectB)  " + objectA.equals(objectB));
        System.out.println("objectA.toString()  " + objectA.toString());//java.lang.Object@449b2d27
        System.out.println("objectB.toString()  " + objectB.toString());//java.lang.Object@5479e3f
        System.out.println("objectA.hashCode()  " + objectA.hashCode());//1151020327
        System.out.println("objectB.hashCode()  " + objectB.hashCode());//88579647
        System.out.println();

        StringBuffer sbA = new StringBuffer("abcd");
        StringBuffer sbB = new StringBuffer("abcd");
        System.out.println("sbA.equals(sbB)  " + sbA.equals(sbB));//false
        System.out.println();

        User user = new User();
        System.out.println("user.hashCode()  " + user.hashCode());//1244954382
    }
}
