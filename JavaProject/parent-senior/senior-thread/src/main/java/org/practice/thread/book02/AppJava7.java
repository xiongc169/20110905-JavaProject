package org.practice.thread.book02;

/**
 * 《Java 7并发编程实战手册》
 * https://www.jb51.net/books/404868.html
 *
 * @author Administrator
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
