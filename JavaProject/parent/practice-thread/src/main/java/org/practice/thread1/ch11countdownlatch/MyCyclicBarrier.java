package org.practice.thread1.ch11countdownlatch;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CyclicBarrier;

/**
 * Java并发编程：CountDownLatch、CyclicBarrier和Semaphore
 * http://www.cnblogs.com/dolphin0520/p/3920397.html
 *
 * @author Administrator
 */
public class MyCyclicBarrier {

    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            Date dt = new Date();
            final DateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
            // String now = df.format(dt);
            // System.out.println(now);

            final CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
                public void run() {
                    System.out.println(df.format(new Date()) + " This is Runnable Begin " + Thread.currentThread().getId() + " " + Thread.currentThread().getName());

                }
            });

            new Thread() {
                public void run() {
                    try {
                        System.out.println(df.format(new Date()) + " This is First Thread Begin " + Thread.currentThread().getId() + " " + Thread.currentThread().getName());
                        Thread.sleep(4000);
                        barrier.await();
                        System.out.println(df.format(new Date()) + " This is First Thread End");
                    } catch (Exception ex) {
                        System.out.println(df.format(new Date()) + " This is First Thread Exception");
                    }
                }
            }.start();

            new Thread() {
                public void run() {
                    try {
                        System.out.println(df.format(new Date()) + " This is Second Thread Begin " + Thread.currentThread().getId() + " " + Thread.currentThread().getName());
                        Thread.sleep(1000);
                        System.out.println(df.format(new Date()) + " This is Second Thread End1");
                        barrier.await();
                        System.out.println(df.format(new Date()) + " This is Second Thread End2");
                    } catch (Exception ex) {
                        System.out.println(df.format(new Date()) + " This is Second Thread Exception");
                    }
                }
            }.start();

            System.out.println(df.format(new Date()) + " This is main Thread Begin " + Thread.currentThread().getId() + " " + Thread.currentThread().getName());
            // latch.await();
            barrier.await();
            System.out.println(df.format(new Date()) + " This is main Thread End " + Thread.currentThread().getId() + " " + Thread.currentThread().getName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
