package org.practice.primary.book01.chap14.book02;

/**
 * @Desc 《Java 7并发编程实战手册》
 * https://www.jb51.net/books/404868.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2015-08-30 09:00:00
 * <p>
 * @Version 1.0
 */
public class AppJava7 {

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
