package org.practice.primary.book01.chap14.thread02.ch01primary;

import java.util.concurrent.Callable;

public class CallableTask implements Callable {

    @Override
    public Object call() throws Exception {
        Long threadId = Thread.currentThread().getId();
        String threadName = Thread.currentThread().getName();
        Thread.State threadState = Thread.currentThread().getState();
        Integer threadPriority = Thread.currentThread().getPriority();
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        System.out.println("CallableTask.threadId: " + threadId);
        System.out.println("CallableTask.threadName: " + threadName);
        System.out.println("CallableTask.threadState: " + threadState);
        System.out.println("CallableTask.threadPriority: " + threadPriority);
        System.out.println("CallableTask.threadGroup: " + threadGroup);
        Thread.sleep(2000);
        return threadId;
    }
}
