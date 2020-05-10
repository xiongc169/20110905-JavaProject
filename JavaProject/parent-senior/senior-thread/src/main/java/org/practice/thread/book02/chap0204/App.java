package org.practice.thread.book02.chap0204;

/**
 *
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