package com.yoong.thread.thread01.ch01primary;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyThread extends Thread {

    //private ReentrantLock lock = new ReentrantLock();

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");

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
            State state = Thread.currentThread().getState();
            boolean isInterrupted = Thread.currentThread().isInterrupted();
            String output = String.format("MyThread: %s %s %s %s %s", format.format(new Date()), threadId, threadName, state, isInterrupted);
            System.out.println(output);
        } finally {
            //lock.unlock();
        }
    }
}
