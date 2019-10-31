package org.practice.thread.book01.chap0304;

import java.util.concurrent.CountDownLatch;

/**
 * @author yoong
 * @desc Participant
 * @date 2019/1/7 19:43
 */
public class Participant implements Runnable {

    private CountDownLatch latch;

    public Participant() {
    }

    public Participant(CountDownLatch latch) {
        this.latch = latch;
    }

    public synchronized void arrived() {
        System.out.println(Thread.currentThread().getName() + " Arrived");
        latch.countDown();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(4000);
            arrived();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
