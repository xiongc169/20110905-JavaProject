package com.yoong.thread.thread01.ch01primary;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class MyCallable implements Callable<Object> {

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");

    public Object call() throws Exception {
        long threadId = Thread.currentThread().getId();
        String threadName = Thread.currentThread().getName();
        Thread.State state = Thread.currentThread().getState();
        boolean isInterrupted = Thread.currentThread().isInterrupted();
        String output = String.format("MyCallable: %s %s %s %s %s", format.format(new Date()), threadId, threadName, state, isInterrupted);
        System.out.println(output);
        TimeUnit.SECONDS.sleep(10);
        return output;
    }

}
