package org.practice.thread.ch01primary;

import java.util.concurrent.locks.ReentrantLock;

public class MyThread extends Thread {

    //private ReentrantLock lock = new ReentrantLock();

    public MyThread() {
    }


    public MyThread(String name) {
        super(name);
    }

    public MyThread(Runnable runnable) {
        super(runnable);
    }

    public MyThread(Runnable runnable, String name) {
        super(runnable, name);
    }

    public synchronized void run() {
        //lock.lock();
        try {
            long threadId = Thread.currentThread().getId();
            String threadName = Thread.currentThread().getName();
            System.out.println("MyThread threadId: " + threadId + "; MyThread threadName: " + threadName);
        } finally {
            //lock.unlock();
        }
    }

}
