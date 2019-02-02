package org.practice.book01.chap03;

/**
 * @author yoong
 * <br>
 * @desc FirstSample
 * <br>
 * @date 2011-9-25~2019-2-1
 */
public class FirstSample {

    /**
     * javac FirstSample.java
     * java FirstSample
     * javac\java编译运行时，需去掉顶部的package，否则会报错：找不到或无法加载主类
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            System.out.println("Hello World");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
