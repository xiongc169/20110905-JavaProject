package org.practice.thread.book02.chap0113;

/**
 * @Desc 《Java 7并发编程实战手册》
 * PS：1.13、使用工厂类创建线程 - ThreadFactory
 * https://www.jb51.net/books/404868.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2015-08-30 09:00:00
 * <p>
 * @Version 1.0
 */
public class AppThreadFactory {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        MyThreadFactory factory = new MyThreadFactory("yoong");
        Task task = new Task();
        Thread thread = factory.newThread(task);
        thread.start();
    }
}
