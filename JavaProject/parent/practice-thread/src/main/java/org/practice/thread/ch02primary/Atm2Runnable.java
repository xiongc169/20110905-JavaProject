package org.practice.thread.ch02primary;

import org.practice.model.Account;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程安全测试
 * 参考：http://www.cnblogs.com/XHJT/p/3897440.html
 */
public class Atm2Runnable implements Runnable {

    private Lock lock = new ReentrantLock();

    private Account account;

    public Atm2Runnable(Account account) {
        this.account = account;
    }

    /**
     * 同步方法(synchronized)、同步代码块、volatile(无效)、Lock锁
     */
    @Override
    public void run() {
        try {
            //synchronized (account) {
            //lock.lock();
            for (int i = 0; i < 10; i++) {
                double balance = account.getBalance();
                account.setBalance(balance + 10);
            }
            //System.out.println("Atm2Runnable threadName: " + Thread.currentThread().getName() + "; Balance: " + account.getBalance());
            //}
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            //lock.unlock();
        }
    }
}
