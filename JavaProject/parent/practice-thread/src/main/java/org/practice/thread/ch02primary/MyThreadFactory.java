package org.practice.thread.ch02primary;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadFactory;

/**
 * Java并发编程与技术内幕:ThreadFactory、ThreadLocal
 * PS：为何使用ThreadFactory创建线程：为了统一在创建线程时设置一些参数或特性，如是否守护线程、优先级等。通过这个TreadFactory创建出来的线程能保证有相同的特性。
 *      ThreadFactory与ThreadGroup还有点关联，ThreadLocal基本上和这两个没什么关联，但是在高并发场景，如果只考虑线程安全而不考虑延迟性、数据共享的话，那么使用ThreadLocal会是一个非常不错的选择。
 * https://www.tuicool.com/articles/b2EZV3z
 */
public class MyThreadFactory implements ThreadFactory {

    private int counter;

    private String name;

    private List<String> status;

    public MyThreadFactory() {
    }

    public MyThreadFactory(String name) {
        counter = 0;
        this.name = name;
        status = new ArrayList<String>();
    }

    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, name + "-Thread-" + counter);
        counter++;
        status.add(String.format("MyThreadFactory.newThread: %d with name %s on%s \n", thread.getId(), thread.getName(), new Date()));
        return thread;
    }

}
