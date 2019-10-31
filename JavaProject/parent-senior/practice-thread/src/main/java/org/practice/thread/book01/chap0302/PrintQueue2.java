package org.practice.thread.book01.chap0302;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue2 {

    private boolean[] freePrinters;

    private final Semaphore semaphore;

    private Lock lockPrinters;

    public PrintQueue2() {
        semaphore = new Semaphore(3);
        freePrinters = new boolean[3];
        for (int i = 0; i < 3; i++) {
            freePrinters[i] = true;
        }
        lockPrinters = new ReentrantLock();
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
