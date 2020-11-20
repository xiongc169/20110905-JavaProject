package org.practice.junior.book01.chap14.thread02.ch03sync;

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
