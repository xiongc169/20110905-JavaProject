package org.practice.primary.book01.chap14.thread01.ch01primary;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyRunnable implements Runnable {

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");

    public void run() {
        long threadId = Thread.currentThread().getId();
        String threadName = Thread.currentThread().getName();
        Thread.State state = Thread.currentThread().getState();
        boolean isInterrupted = Thread.currentThread().isInterrupted();
        String output = String.format("MyRunnable: %s %s %s %s %s", format.format(new Date()), threadId, threadName, state, isInterrupted);
        System.out.println(output);
    }
}
