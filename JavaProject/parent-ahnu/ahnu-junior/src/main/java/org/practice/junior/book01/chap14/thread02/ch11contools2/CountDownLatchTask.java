package org.practice.junior.book01.chap14.thread02.ch11contools2;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTask implements Runnable {

    private CountDownLatch latch;

    public CountDownLatchTask(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {
        System.out.printf("%s Start... \n", Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        latch.countDown();
        System.out.printf("%s End! \n", Thread.currentThread().getName());
    }
}
