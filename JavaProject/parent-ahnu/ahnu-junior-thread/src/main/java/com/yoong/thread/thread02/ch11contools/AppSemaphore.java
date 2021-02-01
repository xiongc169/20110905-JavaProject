package com.yoong.thread.thread02.ch11contools;

import java.text.SimpleDateFormat;
import java.util.concurrent.Semaphore;

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
public class AppSemaphore {

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            Semaphore semaphore = new Semaphore(3);
            for (int i = 0; i < 9; i++) {
                MyThread myThread = new MyThread(i, semaphore);
                myThread.start();
            }
            //System.out.println(format.format(new Date()) + " " + " " + Thread.currentThread().getName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
