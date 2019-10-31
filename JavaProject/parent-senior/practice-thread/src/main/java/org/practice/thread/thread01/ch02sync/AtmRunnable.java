package org.practice.thread.thread01.ch02sync;

import org.practice.thread.thread01.model.Account;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * java笔记--关于线程同步(7种同步方式)
 * http://www.cnblogs.com/XHJT/p/3897440.html
 */
public class AtmRunnable implements Runnable {

    private Lock lock = new ReentrantLock();

    private Account account;

    public AtmRunnable(Account account) {
        this.account = account;
    }

    /**
     * 同步方式：同步方法(synchronized)、同步代码块、volatile(无效)、Lock锁、ThreadLocal(无效)、线程阻塞队列、原子变量
     */
    @Override
    public void run() {
        try {
//            synchronized (account) {
            //lock.lock();
            for (int i = 0; i < 10; i++) {
                Integer balance = account.getBalance();
                account.setBalance(balance + 10);
            }
            //System.out.println("AtmRunnable threadName: " + Thread.currentThread().getName() + "; Balance: " + account.getBalance());
//            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            //lock.unlock();
        }
    }
}
