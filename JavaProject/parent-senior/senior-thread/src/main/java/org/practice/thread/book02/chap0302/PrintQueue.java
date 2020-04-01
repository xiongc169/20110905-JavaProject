package org.practice.thread.book02.chap0302;

import java.util.concurrent.Semaphore;

public class PrintQueue {

    private final Semaphore semaphore;

    public PrintQueue() {
        semaphore = new Semaphore(1);
    }

    public void printJob(Thread currentThread) {
        try {
            semaphore.acquire();
            for (int i = 0; i < 3; i++) {
                System.out.println(currentThread.getName() + ": " + i);
            }
            Thread.sleep(1000);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}
