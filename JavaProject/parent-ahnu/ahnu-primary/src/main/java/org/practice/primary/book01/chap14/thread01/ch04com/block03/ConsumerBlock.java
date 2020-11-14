package org.practice.primary.book01.chap14.thread01.ch04com.block03;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class ConsumerBlock implements Runnable {

    private BlockingQueue queue;

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");

    public ConsumerBlock(BlockingQueue queue) {
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
                if (queue.size() <= 0) {
                    System.out.println("消费者Block-" + threadId + ", 任务池为空" + queue.size() + "不足，等待生产...");
                }
                Object amount = queue.take();
                System.out.println("消费者Block-" + threadId + ", 消费任务：" + amount);
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
