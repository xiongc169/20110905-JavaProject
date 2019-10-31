package org.practice.thread.book01;

/**
 * 《Java 7并发编程实战手册》
 * https://www.jb51.net/books/404868.html
 *
 * @author Administrator
 */
public class App {

    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            System.out.println(args.length);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
