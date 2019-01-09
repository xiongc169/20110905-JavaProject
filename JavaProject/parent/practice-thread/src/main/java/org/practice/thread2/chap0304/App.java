package org.practice.thread2.chap0304;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author yoong
 * @desc App
 * @date 2019/1/7 19:44
 */
public class App {

    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            startMeeting();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void startMeeting() throws Exception {
        System.out.println(Thread.currentThread().getName() + " Start Waiting...");
        CountDownLatch latch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            Participant participant = new Participant(latch);
            Thread thread = new Thread(participant, "Thread-" + i);
            thread.start();
        }
        System.out.println(Thread.currentThread().getName() + " await...");
        latch.await();
        System.out.println(Thread.currentThread().getName() + " End Waiting!");
    }
}
