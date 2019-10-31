package org.practice.thread.thread02.ch03synch;

import org.practice.thread.thread01.model.ThreadLocalModel;

/**
 * @author yoong
 * <br>
 * @desc MyThreadLocal
 * <br>
 * @date 2019/1/14 10:01
 */
public class MyThreadLocal extends Thread {

    private ThreadLocalModel model;

    public MyThreadLocal() {
    }

    public MyThreadLocal(ThreadLocalModel model) {
        this.model = model;
    }

    @Override
    public void run() {
        System.out.println(model.getThreadId() + " " + model.getThreadName());
    }
}
