package org.practice.thread.thread01.ch02sync;

import org.practice.thread.thread01.model.Account;
import org.practice.thread.thread01.model.Person;

/**
 * Java总结篇系列：Java多线程（三）
 * PS：线程同步
 * https://www.cnblogs.com/lwbqqyumidi/p/3821389.html
 * Java中的多线程你只要看这一篇就够了
 * http://www.cnblogs.com/wxd0108/p/5479442.html
 */
public class App {

    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            //创建线程
//            myThreadTest();
//            myRunnableTest();
//            threadFactoryTest();

            //线程同步
//            synchronizedTest();
            synchronizedTest2();

            //线程中断
//            interruptThread();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void myThreadTest() {
        for (int i = 0; i < 4; i++) {
            Thread thread = new MyThread();
            thread.start();
        }

        MyThread myThread = new MyThread();
        Thread threadA = new Thread(myThread);
        threadA.start();
    }

    public static void myRunnableTest() {
        for (int i = 0; i < 4; i++) {
            MyRunnable myRun = new MyRunnable();
            Thread myTh = new Thread(myRun);
            myTh.start();
        }
    }

    public static void threadFactoryTest() {
        MyRunnable runnable = new MyRunnable();
        MyThreadFactory threadFactory = new MyThreadFactory("Yoong");
        for (int i = 0; i < 10; i++) {
            Thread thread = threadFactory.newThread(runnable);
            thread.start();
        }
        System.out.println("threadFactory.counter: " + threadFactory.counter);
    }

    /**
     * Java总结篇系列：Java多线程（三） <br>
     * PS：线程同步：synchronized方法、synchronized代码块、Lock
     * http://www.cnblogs.com/lwbqqyumidi/p/3821389.html
     */
    public static void synchronizedTest() throws Exception {
        Account account = new Account("123456", 1000);
        DrawMoneyRunnable drawMoneyRunnable = new DrawMoneyRunnable(account, 700);
        Thread myThread1 = new Thread(drawMoneyRunnable);
        Thread myThread2 = new Thread(drawMoneyRunnable);
        myThread1.start();
        myThread2.start();
        myThread1.join();
        myThread2.join();
        System.out.printf("Balance: %d \n", account.getBalance());
    }

    /**
     * java笔记--关于线程同步(7种同步方式)
     * http://www.cnblogs.com/XHJT/p/3897440.html
     */
    public static void synchronizedTest2() throws InterruptedException {
        Account account = new Account("123456", 0);
        AtmRunnable atmRunnable = new AtmRunnable(account);
        for (int i = 0; i < 50; i++) {
            Thread myThread = new Thread(atmRunnable);
            myThread.start();
        }
        Thread.sleep(1000);
        System.out.printf("saveAccount Balance: %d \n", account.getBalance());
    }

    /**
     * 线程中断
     *
     * @throws InterruptedException
     */
    public static void interruptThread() throws InterruptedException {
        Person person = new Person("yoong", 25, 25);
        MyThread thread = new MyThread(person);
        thread.start();
        //中断线程1
        boolean interrupted = Thread.interrupted();//获取Main线程的中断状态——未中断
        System.out.println("Thread.interrupted(): " + interrupted);
        boolean isInterrupted = thread.isInterrupted();//获取子线程的中断状态——未中断
        System.out.println("thread.isInterrupted(): " + isInterrupted);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //中断线程2
        thread.interrupt();//中断子线程
        boolean interrupted2 = Thread.interrupted();//获取Main线程的中断状态——未中断
        System.out.println("Thread.interrupted() 2: " + interrupted2);
        boolean isInterrupted2 = thread.isInterrupted();//获取子线程的中断状态——已中断
        System.out.println("thread.isInterrupted() 2: " + isInterrupted2);

        //中断线程3
        Thread.currentThread().interrupt();//中断当前线程，即Main线程
        boolean interrupted3 = Thread.interrupted();//获取当前线程的中断状态——已中断
        System.out.println("Thread.interrupted() 3: " + interrupted3);
    }

}
