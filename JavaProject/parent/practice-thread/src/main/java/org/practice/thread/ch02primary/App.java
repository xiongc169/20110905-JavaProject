package org.practice.thread.ch02primary;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import org.practice.model.Account;
import org.practice.model.Person;

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
            //测试
            myThreadTest();
            myRunnable();
            synchronizedTest();
            synchronizedTest2();
            interruptThread();
            threadFactoryTest();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void myThreadTest() {
        MyThread myThread = new MyThread();
        // for (int i = 0; i < 10; i++) {
        // Thread thread = new Thread(myThread);
        // thread.start();
        // }
        Thread threadA = new Thread(myThread);
        Thread threadB = new Thread(myThread);
        Thread threadC = new Thread(myThread);
        Thread threadD = new Thread(myThread);
        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
    }

    public static void myRunnable() {
        for (int i = 0; i < 10; i++) {
            MyRunnable myRun = new MyRunnable();
            Thread myTh = new Thread(myRun);
            myTh.start();
        }
    }

    /**
     * Java总结篇系列：Java多线程（三） <br>
     * PS：线程同步
     * http://www.cnblogs.com/lwbqqyumidi/p/3821389.html
     */
    public static void synchronizedTest() {
        Account account = new Account("123456", 1000);
        AtmRunnable drawMoneyRunnable = new AtmRunnable(account, 700);
        Thread myThread1 = new Thread(drawMoneyRunnable);
        Thread myThread2 = new Thread(drawMoneyRunnable);
        myThread1.start();
        myThread2.start();
        System.out.printf("Balance: %f \n", account.getBalance());
    }

    /**
     * 线程同步
     * 参考：http://www.cnblogs.com/XHJT/p/3897440.html
     */
    public static void synchronizedTest2() throws InterruptedException {
        Account account = new Account("123456", 0);
        Atm2Runnable atm2Runnable = new Atm2Runnable(account);
        for (int i = 0; i < 50; i++) {
            Thread myThread = new Thread(atm2Runnable);
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

    /**
     * ThreadFactory测试
     */
    public static void threadFactoryTest() {
        MyRunnable runnable = new MyRunnable();
        MyThreadFactory threadFactory = new MyThreadFactory("Yoong");
        for (int i = 0; i < 10; i++) {
            Thread thread = threadFactory.newThread(runnable);
            thread.start();
        }
    }
}
