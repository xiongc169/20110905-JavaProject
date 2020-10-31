package org.practice.thread.thread02.ch11countdownlatch;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

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
public class AppCountDownLatch {

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            CountDownLatch latch = new CountDownLatch(2);

            new Thread() {
                public void run() {
                    try {
                        System.out.println(format.format(new Date()) + " First Thread Begin " + Thread.currentThread().getId() + " " + Thread.currentThread().getName());
                        Thread.sleep(4000);
                        System.out.println(format.format(new Date()) + " First Thread End");
                        latch.countDown();
                    } catch (Exception ex) {
                        System.out.println(format.format(new Date()) + " First Thread Exception");
                    }
                }
            }.start();

            new Thread() {
                public void run() {
                    try {
                        System.out.println(format.format(new Date()) + " Second Thread Begin " + Thread.currentThread().getId() + " " + Thread.currentThread().getName());
                        Thread.sleep(6000);
                        System.out.println(format.format(new Date()) + " Second Thread End");
                        latch.countDown();
                    } catch (Exception ex) {
                        System.out.println(format.format(new Date()) + " Second Thread Exception");
                    }
                }
            }.start();

            System.out.println(format.format(new Date()) + " Main Thread Begin " + Thread.currentThread().getId() + " " + Thread.currentThread().getName());
            latch.await();
            //latch.await(3, TimeUnit.MILLISECONDS);
            System.out.println(format.format(new Date()) + " Main Thread End " + Thread.currentThread().getId() + " " + Thread.currentThread().getName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
