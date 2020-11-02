package org.practice.thread.book02.chap0205;

/**
 * @Desc 《Java 7并发编程实战手册》
 * PS：2.5、使用锁实现同步
 * https://www.jb51.net/books/404868.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2015-08-30 09:00:00
 * <p>
 * @Version 1.0
 */
public class App {

    /**
     * 入口函数
     */
    public static void main(String[] args) {

        PrintQueue queue = new PrintQueue();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Job(queue));
        }
        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
    }
}
