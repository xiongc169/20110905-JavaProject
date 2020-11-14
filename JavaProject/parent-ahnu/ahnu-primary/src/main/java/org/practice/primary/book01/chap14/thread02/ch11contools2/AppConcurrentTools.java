package org.practice.primary.book01.chap14.thread02.ch11contools2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
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
public class AppConcurrentTools {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            countDownLatchDemo();
            cyclicBarrierDemo();
            semaphoreDemo();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * CountDownLatch 测试
     */
    public static void countDownLatchDemo() {
        CountDownLatch latch = new CountDownLatch(3);

        CountDownLatchTask task = new CountDownLatchTask(latch);
        CountDownLatchTask task2 = new CountDownLatchTask(latch);
        CountDownLatchTask task3 = new CountDownLatchTask(latch);

        Thread thread = new Thread(task);
        Thread thread2 = new Thread(task2);
        Thread thread3 = new Thread(task3);

        thread.start();
        thread2.start();
        thread3.start();

        try {
            System.out.printf("Main: %s Start... \n", Thread.currentThread().getName());
            latch.await();
            System.out.printf("Main: %s End! \n", Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * CyclicBarrier 测试
     */
    public static void cyclicBarrierDemo() {
        CyclicBarrier barrier = new CyclicBarrier(3);

        CyclicBarrierTask task = new CyclicBarrierTask(barrier);
        CyclicBarrierTask task2 = new CyclicBarrierTask(barrier);
        CyclicBarrierTask task3 = new CyclicBarrierTask(barrier);

        Thread thread = new Thread(task);
        Thread thread2 = new Thread(task2);
        Thread thread3 = new Thread(task3);

        thread.start();
        thread2.start();
        thread3.start();
    }

    /**
     * Semaphore 测试
     */
    public static void semaphoreDemo() {
        Semaphore semaphore = new Semaphore(2);

        SemaphoreTask task = new SemaphoreTask(semaphore);
        SemaphoreTask task2 = new SemaphoreTask(semaphore);
        SemaphoreTask task3 = new SemaphoreTask(semaphore);

        Thread thread = new Thread(task);
        Thread thread2 = new Thread(task2);
        Thread thread3 = new Thread(task3);

        thread.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int permits = semaphore.availablePermits();
        System.out.printf("semaphore.availablePermits(): %d \n", permits);

        thread2.start();
        thread3.start();
    }
}
