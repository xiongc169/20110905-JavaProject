package org.practice.thread.thread03;

/**
 * 《Java并发编程：核心方法与框架 (高洪岩)》
 * https://www.jb51.net/books/524956.html
 *
 * @author Administrator
 */
public class App {

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
