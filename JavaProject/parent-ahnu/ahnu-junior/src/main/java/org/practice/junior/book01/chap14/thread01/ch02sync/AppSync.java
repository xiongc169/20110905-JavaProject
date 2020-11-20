package org.practice.junior.book01.chap14.thread01.ch02sync;

import org.practice.junior.book01.chap14.thread01.model.Account;

/**
 * @Desc Java总结篇系列：Java多线程（三）
 * PS：线程同步：synchronized方法、synchronized代码块、Lock
 * https://www.cnblogs.com/lwbqqyumidi/p/3821389.html
 * Java中的多线程你只要看这一篇就够了
 * http://www.cnblogs.com/wxd0108/p/5479442.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2015-08-30 09:06:00
 * <p>
 * @Version 1.0
 */
public class AppSync {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            //线程同步
            synchronizedTest();
            synchronizedTest2();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Java总结篇系列：Java多线程（三）
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
}
