package org.practice.thread1.ch11countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Java并发编程：CountDownLatch、CyclicBarrier和Semaphore
 * http://www.cnblogs.com/dolphin0520/p/3920397.html
 *
 * @author Administrator
 */
public class MyCountDownLatch {

    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            CountDownLatch latch = new CountDownLatch(2);

            new Thread() {
                public void run() {
                    try {
                        System.out.println("First Thread Begin " + Thread.currentThread().getId() + " " + Thread.currentThread().getName());
                        Thread.sleep(4000);
                        System.out.println("First Thread End");
                        latch.countDown();
                    } catch (Exception ex) {
                        System.out.println("First Thread Exception");
                    }
                }
            }.start();

            new Thread() {
                public void run() {
                    try {
                        System.out.println("Second Thread Begin " + Thread.currentThread().getId() + " " + Thread.currentThread().getName());
                        Thread.sleep(6000);
                        System.out.println("Second Thread End");
                        latch.countDown();
                    } catch (Exception ex) {
                        System.out.println("Second Thread Exception");
                    }
                }
            }.start();

            System.out.println("Main Thread Begin " + Thread.currentThread().getId() + " " + Thread.currentThread().getName());
            latch.await();
            //latch.await(3, TimeUnit.MILLISECONDS);
            System.out.println("Main Thread End " + Thread.currentThread().getId() + " " + Thread.currentThread().getName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
