package org.practice.thread.thread01.ch01primary;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadFactory;

/**
 * Java并发编程与技术内幕:ThreadFactory、ThreadLocal
 * PS：为何使用ThreadFactory创建线程：为了统一在创建线程时设置一些参数或特性，如是否守护线程、优先级等。通过这个TreadFactory创建出来的线程能保证有相同的特性。
 * ThreadFactory与ThreadGroup还有点关联，ThreadLocal基本上和这两个没什么关联，但是在高并发场景，如果只考虑线程安全而不考虑延迟性、数据共享的话，那么使用ThreadLocal会是一个非常不错的选择。
 * https://www.tuicool.com/articles/b2EZV3z
 * http://blog.csdn.net/chenleixing/article/details/42583701
 */
public class MyThreadFactory implements ThreadFactory {

    public int counter;

    public String name;

    public List<String> status;

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");

    public MyThreadFactory() {
    }

    public MyThreadFactory(String name) {
        counter = 0;
        this.name = name;
        status = new ArrayList<String>();
    }

    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, "ThreadFactory-" + name + counter);
        String output = String.format("ThreadFactory: %s %s %s %s %s", format.format(new Date()), thread.getId(), thread.getName(), thread.getState(), thread.isInterrupted());
        System.out.println(output);
        status.add(output);
        counter++;
        return thread;
    }
}
