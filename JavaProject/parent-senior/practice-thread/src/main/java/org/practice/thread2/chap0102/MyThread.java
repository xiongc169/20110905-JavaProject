package org.practice.thread2.chap0102;

public class MyThread extends Thread {

    public void run() {
        System.out.println("Thread.currentThread().getId :" + Thread.currentThread().getId());
        //System.exit(0);
        System.out.println("Thread.currentThread().getName :" + Thread.currentThread().getName());
        System.out.println("Thread.currentThread().getPriority :" + Thread.currentThread().getPriority());
        System.out.println("Thread.currentThread().getState :" + Thread.currentThread().getState());
        System.out.println("Thread.currentThread().getThreadGroup :" + Thread.currentThread().getThreadGroup());
    }

}
