package org.practice.thread.thread01.ch04com.lock02;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ConsumerLock implements Runnable {

    private Lock lock;

    private Condition condition;

    private List pool;

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");

    public ConsumerLock(Lock lock, Condition condition, List pool) {
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
                if (pool.size() <= 0) {
                    System.out.println("消费者Lock-" + threadId + ", 任务池为空" + pool.size() + "不足，等待生产...");
                    condition.await();
                }
                Object amount = pool.remove(0);
                System.out.println("消费者Lock-" + threadId + ", 消费任务：" + amount);
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
