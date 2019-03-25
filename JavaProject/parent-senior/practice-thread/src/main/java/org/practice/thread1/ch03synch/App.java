package org.practice.thread1.ch03synch;

import org.practice.model.ThreadLocalModel;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yoong
 *
 * @desc Java并发编程：synchronized <br>
 *       http://www.cnblogs.com/dolphin0520/p/3923737.html <br>
 *       Java并发编程：Lock <br>
 *       http://www.cnblogs.com/dolphin0520/p/3923167.html
 *       Java并发编程：volatile关键字解析
 *       https://www.cnblogs.com/dolphin0520/p/3920373.html
 *
 * @date 2018年8月29日
 *
 */
public class App {

    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {
        //测试代码
        try {
            //insertTest();
            //synchronizedInsert();
            //lockInsert();

            //volatile测试
//            App app = new App();
//            volatileTest(app);
//            while (Thread.activeCount() > 1) {
//                //保证前面的线程都执行完
//                System.out.println("Thread.activeCount(): " + Thread.activeCount());
//                Thread.yield();
//            }
//            System.out.println(app.count);

            //threadLocal测试
            threadLocalTest();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 普通插入
     */
    public static void insertTest() {
        InsertData insertUtility = new InsertData();
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                insertUtility.insert(Thread.currentThread());
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                insertUtility.insert(Thread.currentThread());
            }
        });

        threadA.start();
        threadB.start();
    }

    /**
     * 同步插入(synchronized方法、代码块)
     */
    public static void synchronizedInsert() {
        InsertData insertUtility = new InsertData();
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                insertUtility.insert4Synchronized(Thread.currentThread());
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                insertUtility.insert4Synchronized(Thread.currentThread());
            }
        });

        threadA.start();
        threadB.start();
    }

    /**
     * 同步插入(lock)
     */
    public static void lockInsert() {
        InsertData insertUtility = new InsertData();
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                insertUtility.insert4Lock(Thread.currentThread());
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                insertUtility.insert4Lock(Thread.currentThread());
            }
        });

        threadA.start();
        threadB.start();
    }

    /**
     * Java并发编程：volatile关键字解析
     * https://www.cnblogs.com/dolphin0520/p/3920373.html
     */
    private volatile int count = 0;

//    private Lock lock = new ReentrantLock();

//    private AtomicInteger count = new AtomicInteger();

    /**
     * synchronized、Lock、AtomicInteger
     */
    private void increase() {
        //情形一：未同步、synchronized同步
        count++;
        //情形二：lock同步
//        try {
//            lock.lock();
//            count++;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        } finally {
//            lock.unlock();
//        }
        //情形三：AtomicInteger同步
//        count.getAndIncrement();
    }

    public static void volatileTest(App app) {
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        app.increase();
                    }
                }
            });
            thread.start();
        }
    }

    /**
     * ThreadLocal测试
     *
     * @throws Exception
     */
    public static void threadLocalTest() throws Exception {
        ThreadLocalModel model = new ThreadLocalModel();

        MyThreadLocal thread = new MyThreadLocal(model);
        MyThreadLocal thread2 = new MyThreadLocal(model);
        thread.start();
        thread2.start();

        thread.join();
        thread2.join();
        System.out.println(Thread.currentThread().getId() + " " + Thread.currentThread().getName());

    }
}
