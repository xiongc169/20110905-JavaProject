package org.practice.thread.thread01.ch04com.lock02;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ProducerLock implements Runnable {

    private Lock lock;

    private Condition condition;

    private List pool;

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");

    public ProducerLock(Lock lock, Condition condition, List pool) {
        this.lock = lock;
        this.condition = condition;
        this.pool = pool;
    }

    @Override
    public void run() {
        try {
            lock.lock();
            while (true) {
                long threadId = Thread.currentThread().getId();
                String threadName = Thread.currentThread().getName();
                Thread.State state = Thread.currentThread().getState();
                boolean isInterrupted = Thread.currentThread().isInterrupted();
                String output = String.format("MyCallable: %s %s %s %s %s", format.format(new Date()), threadId, threadName, state, isInterrupted);
                if (pool.size() >= 5) {
                    System.out.println("生产者Lock-" + threadId + ", 任务池已满" + pool.size() + "，等待消费...");
                    condition.await();
                }

                Integer amount = new Random().nextInt(100);
                pool.add(amount);
                System.out.println("生产者Lock-" + threadId + ", 生产任务：" + amount);
                TimeUnit.SECONDS.sleep(1);
                condition.signalAll();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
