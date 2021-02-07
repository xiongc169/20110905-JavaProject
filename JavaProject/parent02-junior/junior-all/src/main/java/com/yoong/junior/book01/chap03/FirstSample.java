package com.yoong.junior.book01.chap03;

/**
 * @Desc 《Java核心技术·卷1》第三章、Java的基本程序设计结构
 * <p>
 * @Author yoong
 * <p>
 * @Date 2019/2/1 11:50
 * <p>
 * @Version 1.0
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
