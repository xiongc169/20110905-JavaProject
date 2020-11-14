package org.practice.primary.book01.chap14.thread02.ch05notify3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ConsumerPlus implements Runnable {

    private Lock lock;
    private Condition notFull;
    private Condition notEmpty;
    private List<String> queue = new ArrayList<>();

    public ConsumerPlus() {
    }

    public ConsumerPlus(Lock lock, Condition notFull, Condition notEmpty, List<String> queue) {
        this.lock = lock;
        this.notFull = notFull;
        this.notEmpty = notEmpty;
        this.queue = queue;
    }

    public void consume() {
        while (true) {
            try {
                lock.lock();
                if (queue.size() <= 0) {
                    System.out.println("数据池为空，消费者阻塞...");
                    notEmpty.await();
                }
                String result = queue.get(0);
                queue.remove(0);
                System.out.println("消费者消费数据：" + result);
                notFull.signalAll();
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
        consume();
    }
}
