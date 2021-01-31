package org.practice.junior.book01.chap03;

import java.io.UnsupportedEncodingException;

public class AppDataType02 {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            dataTypeTest();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * java中char占了几个字节
     * PS：byte\short\int\long，1字节(byte)=8位(bits)
     * Unicode/GBK，中文2字节。UTF-8，中文通常3字节。
     * char在Java中占用2字节。
     * https://blog.csdn.net/u010325193/article/details/81282051
     * https://www.cnblogs.com/fnlingnzb-learner/p/7272348.html
     */
    public static void dataTypeTest() {
        byte bytee = Byte.MAX_VALUE;
        short shortt = Short.MAX_VALUE;
        int intt = Integer.MAX_VALUE;
        long longg = Long.MAX_VALUE;
        System.out.println(bytee);
        System.out.println(shortt);
        System.out.println(intt);
        System.out.println(longg);

        try {
            System.out.println("中".getBytes("UTF-8").length); // 3
            System.out.println("中中".getBytes("UTF-8").length); // 6
            System.out.println("中".getBytes("GBK").length); // 2
            System.out.println("中中".getBytes("GBK").length); // 4
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        char a = (char) Integer.MAX_VALUE;
        System.out.println((int) a);
    }
}
