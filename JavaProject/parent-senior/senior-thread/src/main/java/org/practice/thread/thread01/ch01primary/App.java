package org.practice.thread.thread01.ch01primary;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.FutureTask;

/**
 * @Desc Java总结篇系列：Java多线程（一）
 * http://www.cnblogs.com/lwbqqyumidi/p/3804883.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2015-08-30 09:06:00
 * <p>
 * @Version 1.0
 */
public class App {

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            Thread thread = Thread.currentThread();
            long threadId = Thread.currentThread().getId();
            String threadName = Thread.currentThread().getName();
            Thread.State state = Thread.currentThread().getState();
            boolean interrupted = Thread.currentThread().isInterrupted();
            boolean staticInterrupted = Thread.interrupted();
            String output = String.format("MainThread: %s %s %s %s %s %s", format.format(new Date()), threadId, threadName, state, interrupted, staticInterrupted);
            System.out.println(output);

            myThreadTest();
            summaryTest();
            lambdaRunnable();
            threadFactoryTest();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * MyThread测试
     */
    public static void myThreadTest() {
        MyThread myThread1 = new MyThread("myThread-1");
        MyThread myThread2 = new MyThread("myThread-2");
        myThread1.start();
        myThread2.start();

        MyThread myThread3 = new MyThread("myThread-3");
        MyThread myThread4 = new MyThread("myThread-4");
        Thread thread3 = new Thread(myThread3, "thread-3");
        Thread thread4 = new Thread(myThread4, "thread-4");
        thread3.start();
        thread4.start();

        MyThread myThread5 = new MyThread("myThread-5");
        Thread thread5 = new Thread(myThread5, "thread-5");
        Thread thread6 = new Thread(myThread5, "thread-6");
        thread5.start();
        thread6.start();
    }

    /**
     * 测试
     */
    public static void summaryTest() {
        // 1.Thread 测试
        MyThread myThread = new MyThread("myThread-1");
        myThread.start();

        // 2.Runnable 测试
        MyRunnable myRunnable = new MyRunnable();
        Thread runnableThread = new Thread(myRunnable, "myRunnable-1");
        runnableThread.start();

        // 3.Thread + Runnable 测试，执行MyThread线程体
        MyRunnable myRunnable2 = new MyRunnable();
        MyThread myThread2 = new MyThread(myRunnable2, "myThread-2");
        myThread2.start();

        // 4.Callable + FutureTask 测试
        try {
            MyCallable myCallable = new MyCallable();
            FutureTask fTask = new FutureTask(myCallable);
            Thread taskThread = new Thread(fTask, "myCallable-1");
            taskThread.start();

            Object result = fTask.get();//fTask.get()方法会阻塞，直到结果返回
            System.out.println(result);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("summaryTest End!");
    }

    /**
     * 利用Lambda创建线程
     * PS：Runnable runnable = ()->{};
     * https://blog.csdn.net/chengqiuming/article/details/95667184
     */
    public static void lambdaRunnable() {
        Runnable runnable = () -> {
            long threadId = Thread.currentThread().getId();
            String threadName = Thread.currentThread().getName();
            Thread.State state = Thread.currentThread().getState();
            boolean isInterrupted = Thread.currentThread().isInterrupted();
            String output = String.format("MyThread: %s %s %s %s %s", format.format(new Date()), threadId, threadName, state, isInterrupted);
            System.out.println(output);
        };
    }

    /**
     * threadFactory测试
     */
    public static void threadFactoryTest() {
        MyRunnable runnable = new MyRunnable();
        MyThreadFactory threadFactory = new MyThreadFactory("Yoong");
        for (int i = 0; i < 10; i++) {
            Thread thread = threadFactory.newThread(runnable);
            thread.start();
        }
        System.out.println("threadFactory.counter: " + threadFactory.counter);
    }
}
