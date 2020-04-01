package org.practice.thread.book01.chap0604;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author yoong
 *
 * @desc App
 *
 * @date 2019/1/8 20:08
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
     *
     * @throws Exception
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
