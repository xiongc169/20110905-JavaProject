package org.practice.primary.book01.chap14.thread01.ch02callback;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Secretary implements Runnable {

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");

    private Boss boss;

    public Secretary() {
    }

    public Secretary(Boss boss) {
        this.boss = boss;
    }

    @Override
    public void run() {
        try {
            long threadId = Thread.currentThread().getId();
            String threadName = Thread.currentThread().getName();
            Thread.State state = Thread.currentThread().getState();
            boolean isInterrupted = Thread.currentThread().isInterrupted();
            String output = String.format("Secretary: %s %s %s %s %s", format.format(new Date()), threadId, threadName, state, isInterrupted);
            System.out.println(output);
            TimeUnit.SECONDS.sleep(10);
            boss.receiveResult(output);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
