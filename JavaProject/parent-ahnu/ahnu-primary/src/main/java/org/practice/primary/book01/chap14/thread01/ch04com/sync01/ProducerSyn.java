package org.practice.primary.book01.chap14.thread01.ch04com.sync01;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ProducerSyn implements Runnable {

    private Object obj;

    private List pool;

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");

    public ProducerSyn(Object obj, List pool) {
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
                    if (pool.size() >= 5) {
                        System.out.println("生产者Syn-" + threadId + ", 任务池已满" + pool.size() + "，等待消费...");
                        obj.wait();
                    }

                    Integer amount = new Random().nextInt(100);
                    pool.add(amount);
                    System.out.println("生产者Syn-" + threadId + ", 生产任务：" + amount);
                    TimeUnit.SECONDS.sleep(1);
                    obj.notifyAll();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
