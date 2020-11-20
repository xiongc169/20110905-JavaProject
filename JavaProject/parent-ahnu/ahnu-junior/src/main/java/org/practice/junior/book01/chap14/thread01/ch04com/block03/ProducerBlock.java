package org.practice.junior.book01.chap14.thread01.ch04com.block03;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class ProducerBlock implements Runnable {

    private BlockingQueue queue;

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");

    public ProducerBlock(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                long threadId = Thread.currentThread().getId();
                String threadName = Thread.currentThread().getName();
                Thread.State state = Thread.currentThread().getState();
                boolean isInterrupted = Thread.currentThread().isInterrupted();
                String output = String.format("MyCallable: %s %s %s %s %s", format.format(new Date()), threadId, threadName, state, isInterrupted);
                if (queue.size() >= 5) {
                    System.out.println("生产者Block-" + threadId + ", 任务池已满" + queue.size() + "，等待消费...");
                }
                Integer amount = new Random().nextInt(100);
                queue.put(amount);
                System.out.println("生产者Block-" + threadId + ", 生产任务：" + amount);
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
