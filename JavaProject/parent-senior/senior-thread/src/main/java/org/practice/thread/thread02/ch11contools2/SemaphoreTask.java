package org.practice.thread.thread02.ch11contools2;

import java.util.concurrent.Semaphore;

public class SemaphoreTask implements Runnable {

    private Semaphore semaphore;

    public SemaphoreTask(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public void run() {

        try {
            semaphore.acquire();

            System.out.printf("%s Start... \n", Thread.currentThread().getName());
            Thread.sleep(10000);
            System.out.printf("%s End! \n", Thread.currentThread().getName());

            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
