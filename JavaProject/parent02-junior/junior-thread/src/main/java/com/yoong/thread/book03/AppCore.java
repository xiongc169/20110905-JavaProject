package com.yoong.thread.book03;

/**
 * @Desc 《Java并发编程：核心方法与框架-高洪岩》
 * https://www.jb51.net/books/524956.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2019/1/14 14:30:00
 * <p>
 * @Version 1.0
 */
public class AppCore {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            System.out.println(args.length);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
