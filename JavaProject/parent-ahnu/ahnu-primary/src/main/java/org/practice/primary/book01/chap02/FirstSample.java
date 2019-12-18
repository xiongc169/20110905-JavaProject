package org.practice.primary.book01.chap02;

/**
 * @author yoong
 * <br>
 * @desc 《Java核心技术·卷1》第二章、Java程序设计环境
 * <br>
 * @date 2011-9-25~2019-2-1
 */
public class FirstSample {

    /**
     * javac FirstSample.java
     * java FirstSample
     * javac\java编译运行时，需去掉顶部的package，否则会报错：找不到或无法加载主类
     */
    public static void main(String[] args) {
        try {
            System.out.println("Hello World");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
