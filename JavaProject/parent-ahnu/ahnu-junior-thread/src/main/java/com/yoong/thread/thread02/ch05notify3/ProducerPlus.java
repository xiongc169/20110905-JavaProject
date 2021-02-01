package com.yoong.thread.thread02.ch05notify3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ProducerPlus implements Runnable {
    private Lock lock;
    private Condition notFull;
    private Condition notEmpty;
    private List<String> queue = new ArrayList<>();

    public ProducerPlus() {
    }

    public ProducerPlus(Lock lock, Condition notFull, Condition notEmpty, List<String> queue) {
        this.lock = lock;
        this.notFull = notFull;
        this.notEmpty = notEmpty;
        this.queue = queue;
    }

    public void produce() {
        while (true) {
            try {
                lock.lock();
                if (queue.size() >= 10) {
                    System.out.println("数据池已满，生产者者阻塞...");
                    notFull.await();
                }
                String tmp = Math.random() + "";
                queue.add(tmp);
                System.out.println("生产者生成数据：" + tmp);
                notEmpty.signalAll();
                Thread.sleep(1000);
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    @Override
    public void run() {
        produce();
    }
}
