package org.practice.thread.ch02primary;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import org.practice.model.Account;
import org.practice.model.Person;

/**
 * @author Administrator
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
            accountTest();
            saveAccount();
            threadTest();
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
     * PS：线程安全测试 <br>
     * http://www.cnblogs.com/lwbqqyumidi/p/3821389.html
     */
    public static void accountTest() {
        Account account = new Account("123456", 1000);
        AtmRunnable drawMoneyRunnable = new AtmRunnable(account, 700);
        Thread myThread1 = new Thread(drawMoneyRunnable);
        Thread myThread2 = new Thread(drawMoneyRunnable);
        myThread1.start();
        myThread2.start();
        System.out.printf("Balance: %f \n", account.getBalance());
    }

    /**
     * 线程安全测试
     * 参考：http://www.cnblogs.com/XHJT/p/3897440.html
     */
    public static void saveAccount() throws InterruptedException {
        Account account = new Account("123456", 0);
        Atm2Runnable atm2Runnable = new Atm2Runnable(account);
        for (int i = 0; i < 500; i++) {
            Thread myThread = new Thread(atm2Runnable);
            myThread.start();
        }
        Thread.sleep(1000);
        System.out.printf("saveAccount Balance: %f \n", account.getBalance());
    }

    /**
     * 线程中断
     *
     * @throws InterruptedException
     */
    public static void threadTest() throws InterruptedException {
        System.out.println("threadTest Begin");

        Person person = new Person("chaoxiong", 25, 25);
        for (int i = 0; i < 10; i++) {
            MyThread thread = new MyThread(person);
            thread.start();
            thread.join();
            //中断线程
            Thread.interrupted();
            thread.isInterrupted();
            thread.interrupt();
            Thread.currentThread().isInterrupted();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("threadTest End");
    }
}
