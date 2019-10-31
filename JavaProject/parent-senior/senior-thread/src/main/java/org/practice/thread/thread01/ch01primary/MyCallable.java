package org.practice.thread.thread01.ch01primary;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class MyCallable implements Callable<Object> {

    public Object call() throws Exception {

        long threadId = Thread.currentThread().getId();
        String threadName = Thread.currentThread().getName();
        String result = "Callable threadId: " + threadId + "; Callable threadName: " + threadName;
        System.out.println(result);
        TimeUnit.SECONDS.sleep(10);
        return result;
    }

}
