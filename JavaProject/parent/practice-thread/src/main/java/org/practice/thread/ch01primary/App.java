package org.practice.thread.ch01primary;

import java.util.concurrent.FutureTask;

/**
 * Java总结篇系列：Java多线程（一）<br>
 * http://www.cnblogs.com/lwbqqyumidi/p/3804883.html
 *
 * @author Administrator
 */
public class App {

    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {

        Thread thread = Thread.currentThread();
        long threadId = Thread.currentThread().getId();
        String threadName = Thread.currentThread().getName();
        System.out.println("Main Thread: " + thread + "; ThreadId: " + threadId + "; ThreadName: " + threadName);

        myThreadTest();
        summaryTest();
    }

    /**
     * MyThread测试
     */
    public static void myThreadTest() {
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        myThread1.start();
        myThread2.start();

        MyThread myThread3 = new MyThread();
        MyThread myThread4 = new MyThread();
        Thread thread3 = new Thread(myThread3);
        Thread thread4 = new Thread(myThread4);
        thread3.start();
        thread4.start();

        MyThread myThread5 = new MyThread();
        Thread thread5 = new Thread(myThread5);
        Thread thread6 = new Thread(myThread5);
        thread5.start();
        thread6.start();
    }

    /**
     * 测试代码
     */
    public static void summaryTest() {
        // 1.Thread 测试
        MyThread myThread = new MyThread();
        myThread.start();

        // 2.Runnable 测试
        MyRunnable myRunnable = new MyRunnable();
        Thread runnableThread = new Thread(myRunnable);
        runnableThread.start();

        // 3.Thread + Runnable 测试
        MyRunnable myRunnable2 = new MyRunnable();
        MyThread myThread2 = new MyThread(myRunnable2);
        myThread2.start();

        // 4.Callable + FutureTask 测试
        try {
            MyCallable myCallable = new MyCallable();
            FutureTask ftask = new FutureTask(myCallable);
            Thread taskThread = new Thread(ftask);
            taskThread.start();

            Object result = ftask.get();
            System.out.println(result);
        } catch (Exception ex) {
            String msg = ex.getMessage();
            System.out.println(msg);
        }
    }
}
