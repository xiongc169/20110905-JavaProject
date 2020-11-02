package org.practice.thread.book02.chap0304;

import java.util.concurrent.CountDownLatch;

/**
 * @Desc 《Java 7并发编程实战手册》
 * PS：3.4、等待多个并发事件的完成 - CountDownLatch
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
        try {
            startMeeting();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void startMeeting() throws Exception {
        System.out.println(Thread.currentThread().getName() + " Start Meeting...");
        CountDownLatch latch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            Participant participant = new Participant(latch);
            Thread thread = new Thread(participant, "Thread-" + i);
            thread.start();
        }
        System.out.println(Thread.currentThread().getName() + " await...");
        latch.await();
        System.out.println(Thread.currentThread().getName() + " End Meeting!");
    }
}
