package org.practice.thread.ch02sync;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

import org.practice.model.Person;

/**
 * 线程中断
 *
 * @author chaoxiong
 * @since 2015-10-19 15:45:45
 */
public class MyThread extends Thread {

    private ReentrantLock lock = new ReentrantLock();

    private Person person;

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");

    public MyThread() {
    }

    public MyThread(Person person) {
        this.person = person;
    }

    public MyThread(Runnable runnable) {
        super(runnable);
    }

    /**
     * 线程中断的测试
     */
    @Override
    public void run() {
        boolean isInterrupted = Thread.currentThread().isInterrupted();
        try {
            while (!isInterrupted) {
                System.out.println("MyThread.isInterrupted: " + isInterrupted);
                String output = String.format("%s MyThread %s %s", format.format(new Date()), Thread.currentThread().getName(), Thread.currentThread().getState());
                System.out.println(output);
                //Thread.sleep(500);
                isInterrupted = Thread.currentThread().isInterrupted();
            }
            System.out.println("MyThread.isInterrupted outer: " + isInterrupted);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("deprecation")
    public void stopThread() {
        this.stop();
    }
}
