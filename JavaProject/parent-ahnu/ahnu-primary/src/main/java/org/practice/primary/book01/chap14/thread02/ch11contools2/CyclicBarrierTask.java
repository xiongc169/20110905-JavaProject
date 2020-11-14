package org.practice.primary.book01.chap14.thread02.ch11contools2;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTask implements Runnable {

    private CyclicBarrier barrier;

    public CyclicBarrierTask(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    public void run() {
        System.out.printf("%s Start... \n", Thread.currentThread().getName());

        try {
            Long duration = (long) (Math.random() * 10) * 1000;
            System.out.printf("%s Sleep %d ms... \n", Thread.currentThread().getName(), duration);
            Thread.sleep(duration);
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.printf("%s End! \n", Thread.currentThread().getName());
    }
}
