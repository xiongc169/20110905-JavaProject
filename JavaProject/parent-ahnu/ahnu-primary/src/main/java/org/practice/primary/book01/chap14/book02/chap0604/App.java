package org.practice.primary.book01.chap14.book02.chap0604;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * @Desc 《Java 7并发编程实战手册》
 * PS：6.4、使用按优先级排序的阻塞式线程安全列表
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
            priorityBlocking();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 6.4、使用按优先级排序的阻塞式线程安全列表
     */
    private static void priorityBlocking() throws Exception {

        PriorityBlockingQueue<Event> priorityBlockingQueue = new PriorityBlockingQueue<>();
        Thread[] threads = new Thread[5];

        for (int i = 0; i < threads.length; i++) {
            Task task = new Task(i, priorityBlockingQueue);
            threads[i] = new Thread(task);
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }

        for (int i = 0; i < threads.length * 1000; i++) {
            Event event = priorityBlockingQueue.poll();
            System.out.println(event.getThread() + "-" + event.getPriority());
        }
    }
}
