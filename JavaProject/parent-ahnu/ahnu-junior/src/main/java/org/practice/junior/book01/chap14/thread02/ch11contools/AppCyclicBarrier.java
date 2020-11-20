package org.practice.junior.book01.chap14.thread02.ch11contools;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CyclicBarrier;

/**
 * @Desc Java并发编程：CountDownLatch、CyclicBarrier和Semaphore
 * http://www.cnblogs.com/dolphin0520/p/3920397.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018年8月29日
 * <p>
 * @Version 1.0
 */
public class AppCyclicBarrier {

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            //参数parties指让多少个线程或者任务等待至barrier状态；参数barrierAction为当这些线程都达到barrier状态时会执行的内容；
            //当四个线程都到达barrier状态后，会从四个线程中选择一个线程去执行barrierAction
            CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
                public void run() {
                    System.out.println(format.format(new Date()) + " CyclicBarrier Thread " + Thread.currentThread().getId() + " " + Thread.currentThread().getName());

                }
            });

            new Thread() {
                public void run() {
                    try {
                        System.out.println(format.format(new Date()) + " First Thread Begin " + Thread.currentThread().getId() + " " + Thread.currentThread().getName());
                        Thread.sleep(6000);
                        barrier.await();
                        System.out.println(format.format(new Date()) + " First Thread End");
                    } catch (Exception ex) {
                        System.out.println(format.format(new Date()) + " First Thread Exception");
                    }
                }
            }.start();

            new Thread() {
                public void run() {
                    try {
                        System.out.println(format.format(new Date()) + " Second Thread Begin " + Thread.currentThread().getId() + " " + Thread.currentThread().getName());
                        Thread.sleep(1000);
                        System.out.println(format.format(new Date()) + " Second Thread End1");
                        barrier.await();
                        System.out.println(format.format(new Date()) + " Second Thread End2");
                    } catch (Exception ex) {
                        System.out.println(format.format(new Date()) + " Second Thread Exception");
                    }
                }
            }.start();

            System.out.println(format.format(new Date()) + " Main Thread Begin " + Thread.currentThread().getId() + " " + Thread.currentThread().getName());
            barrier.await();
            //barrier.await(10, TimeUnit.SECONDS);
            System.out.println(format.format(new Date()) + " Main Thread End " + Thread.currentThread().getId() + " " + Thread.currentThread().getName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
