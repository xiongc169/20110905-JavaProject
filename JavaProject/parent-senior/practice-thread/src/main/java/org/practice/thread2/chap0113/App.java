package org.practice.thread2.chap0113;

/**
 *
 */
public class App {

    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {

        MyThreadFactory factory = new MyThreadFactory("yoong");
        Task task = new Task();
        Thread thread = factory.newThread(task);
        thread.start();
    }

}
