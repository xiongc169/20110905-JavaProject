package com.yoong.thread.thread01.ch04com.sync01;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ConsumerSyn implements Runnable {

    private Object obj;

    private List pool;

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");

    public ConsumerSyn(Object obj, List pool) {
        this.obj = obj;
        this.pool = pool;
    }

    @Override
    public void run() {
        try {
            synchronized (obj) {
                while (true) {
                    long threadId = Thread.currentThread().getId();
                    String threadName = Thread.currentThread().getName();
                    Thread.State state = Thread.currentThread().getState();
                    boolean isInterrupted = Thread.currentThread().isInterrupted();
                    String output = String.format("MyCallable: %s %s %s %s %s", format.format(new Date()), threadId, threadName, state, isInterrupted);
                    if (pool.size() <= 0) {
                        System.out.println("消费者Syn-" + threadId + ", 任务池为空" + pool.size() + "不足，等待生产...");
                        obj.wait();
                    }
                    Object amount = pool.remove(0);
                    System.out.println("消费者Syn-" + threadId + ", 消费任务：" + amount);
                    TimeUnit.SECONDS.sleep(1);
                    obj.notifyAll();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
