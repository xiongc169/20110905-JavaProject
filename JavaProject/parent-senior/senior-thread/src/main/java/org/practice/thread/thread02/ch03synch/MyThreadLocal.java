package org.practice.thread.thread02.ch03synch;

import org.practice.thread.thread01.model.ThreadLocalModel;

public class MyThreadLocal extends Thread {

    private ThreadLocalModel model;

    public MyThreadLocal() {
    }

    public MyThreadLocal(ThreadLocalModel model) {
        this.model = model;
    }

    @Override
    public void run() {
        System.out.println("threadId: " + model.getThreadId().get());
        System.out.println("threadName: " + model.getThreadName().get());
    }
}
