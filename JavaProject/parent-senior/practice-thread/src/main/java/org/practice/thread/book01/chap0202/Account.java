package org.practice.thread.book01.chap0202;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {

    private Lock lock = new ReentrantLock();

    public double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * synchronized
     *
     * @param amount
     */
    public void addAmount(double amount) {
        // System.out.println("before addAmount");

//        lock.lock();
        try {
            double tmp = balance;
            Thread.sleep(10);
            tmp += amount;
            this.balance = tmp;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
//            lock.unlock();
        }
    }

    /**
     * synchronized
     *
     * @param amount
     */
    public void subtractAmount(double amount) {
        // System.out.println("before subtractAmount");
//        lock.lock();
        try {
            double tmp = balance;
            Thread.sleep(10);
            tmp -= amount;
            this.balance = tmp;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
//            lock.unlock();
        }
    }

}
