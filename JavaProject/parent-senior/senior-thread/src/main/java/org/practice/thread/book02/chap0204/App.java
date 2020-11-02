package org.practice.thread.book02.chap0204;

/**
 * @Desc 《Java 7并发编程实战手册》
 * PS：2.4、在同步代码中使用条件
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
        EventStorage storage = new EventStorage();

        Producer producer = new Producer(storage);
        Consumer consumer = new Consumer(storage);

        Thread proThread = new Thread(producer);
        Thread conThread = new Thread(consumer);

        proThread.start();
        conThread.start();
    }
}
