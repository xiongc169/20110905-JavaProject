package org.practice.thread.ch01primary;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Object> {

    public Object call() throws Exception {

        long threadId = Thread.currentThread().getId();
        String threadName = Thread.currentThread().getName();
        String result = "Callable threadId: " + threadId + "; Callable threadName: " + threadName;
        System.out.println(result);

        return result;
    }

}
