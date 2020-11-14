package org.practice.primary.book01.chap14.book02.chap0205;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PrintQueue {

    private Lock lock = new ReentrantLock();

    //chap0206
    private ReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    public void print() {
        lock.lock();
        //reentrantReadWriteLock.readLock().lock();
        //reentrantReadWriteLock.writeLock().lock();
        try {
            Long duration = (long) Math.random() * 1000;
            System.out.println(Thread.currentThread().getName() + ": PrintQueue.print during " + duration + " seconds");
            Thread.sleep(duration);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            lock.unlock();
            //reentrantReadWriteLock.readLock().unlock();
            //reentrantReadWriteLock.writeLock().unlock();
        }
    }
}
