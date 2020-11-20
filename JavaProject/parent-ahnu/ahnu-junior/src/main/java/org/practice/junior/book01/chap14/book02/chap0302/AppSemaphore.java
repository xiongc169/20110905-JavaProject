package org.practice.junior.book01.chap14.book02.chap0302;

/**
 * @Desc 《Java 7并发编程实战手册》
 * PS：3.2、资源的并发访问控制 - Semaphore
 * https://www.jb51.net/books/404868.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2015-08-30 09:00:00
 * <p>
 * @Version 1.0
 */
public class AppSemaphore {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();
        for (int i = 0; i < 10; i++) {
            Job job = new Job(printQueue);
            Thread thread = new Thread(job);
            thread.start();
        }
    }
}
