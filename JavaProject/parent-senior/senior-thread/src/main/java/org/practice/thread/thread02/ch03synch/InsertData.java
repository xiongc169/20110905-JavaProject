package org.practice.thread.thread02.ch03synch;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InsertData {

    private ArrayList<Integer> arrayList = new ArrayList<Integer>();

    private Lock lock = new ReentrantLock();

    public void insert(Thread thread) {
        for (int i = 0; i < 100; i++) {
            System.out.println(thread.getName() + " 在插入数据 " + i);
            arrayList.add(i);
        }
        System.out.println(thread.getName() + " \n");
    }

    public void insert4Synchronized(Thread thread) {
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                System.out.println(thread.getName() + " 在插入数据 " + i);
                arrayList.add(i);
            }
        }
        System.out.println(thread.getName() + " \n");
    }

    public void insert4Lock(Thread thread) {
        lock.lock();
        try {
            for (int i = 0; i < 100; i++) {
                System.out.println(thread.getName() + " 在插入数据 " + i);
                arrayList.add(i);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            lock.unlock();
        }
        System.out.println(thread.getName() + " \n");
    }

}
