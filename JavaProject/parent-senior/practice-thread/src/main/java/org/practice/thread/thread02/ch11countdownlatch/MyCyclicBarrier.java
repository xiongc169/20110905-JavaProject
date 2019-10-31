package org.practice.thread.thread02.ch11countdownlatch;

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
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            // String now = df.format(new Date());
            // System.out.println(now);

            //参数parties指让多少个线程或者任务等待至barrier状态；参数barrierAction为当这些线程都达到barrier状态时会执行的内容
            //当四个线程都到达barrier状态后，会从四个线程中选择一个线程去执行barrierAction
            CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
                public void run() {
                    System.out.println(df.format(new Date()) + " CyclicBarrier run() " + Thread.currentThread().getId() + " " + Thread.currentThread().getName());

                }
            });

            new Thread() {
                public void run() {
                    try {
                        System.out.println(df.format(new Date()) + " First Thread Begin " + Thread.currentThread().getId() + " " + Thread.currentThread().getName());
                        Thread.sleep(6000);
                        barrier.await();
                        System.out.println(df.format(new Date()) + " First Thread End");
                    } catch (Exception ex) {
                        System.out.println(df.format(new Date()) + " First Thread Exception");
                    }
                }
            }.start();

            new Thread() {
                public void run() {
                    try {
                        System.out.println(df.format(new Date()) + " Second Thread Begin " + Thread.currentThread().getId() + " " + Thread.currentThread().getName());
                        Thread.sleep(1000);
                        System.out.println(df.format(new Date()) + " Second Thread End1");
                        barrier.await();
                        System.out.println(df.format(new Date()) + " Second Thread End2");
                    } catch (Exception ex) {
                        System.out.println(df.format(new Date()) + " Second Thread Exception");
                    }
                }
            }.start();

            System.out.println(df.format(new Date()) + " Main Thread Begin " + Thread.currentThread().getId() + " " + Thread.currentThread().getName());
            barrier.await();
            //barrier.await(10, TimeUnit.SECONDS);
            System.out.println(df.format(new Date()) + " Main Thread End " + Thread.currentThread().getId() + " " + Thread.currentThread().getName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
