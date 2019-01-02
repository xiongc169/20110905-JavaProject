package org.practice.thread.ch02primary;

import java.util.concurrent.locks.ReentrantLock;

import org.practice.model.Person;

/**
 * @author chaoxiong
 * @since 2015-10-19 15:45:45
 */
public class MyThread extends Thread {

    private ReentrantLock lock = new ReentrantLock();

    private Person person;

    public MyThread() {
    }

    public MyThread(Person person) {
        this.person = person;
    }

    public MyThread(Runnable runnable) {
        super(runnable);
    }

    @Override
    public synchronized void run() {
        // synchronized (this) {
        // for (int i = 0; i < 10; i++) {
        if (person.getAge() >= person.getSalary()) {

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            person.setAge(person.getAge() - person.getSalary());
        }
        Thread.yield();
        String output = String.format("MyThread %s %s  %d", Thread.currentThread().getName(), Thread.currentThread().getState(), person.getAge());
        System.out.println(output);
        // }
        // }
    }

    @SuppressWarnings("deprecation")
    public void stopThread() {
        this.stop();
    }
}
