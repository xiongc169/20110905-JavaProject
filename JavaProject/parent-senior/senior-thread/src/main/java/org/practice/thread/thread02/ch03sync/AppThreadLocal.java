package org.practice.thread.thread02.ch03sync;

import org.practice.thread.thread01.model.ThreadLocalModel;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @Desc Java并发编程：深入剖析ThreadLocal
 * https://www.cnblogs.com/dolphin0520/p/3920407.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018年8月29日
 * <p>
 * @Version 1.0
 */
public class AppThreadLocal {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            //threadLocal测试
            threadLocalTest();
            threadLocalTest01();
            threadLocalTest02();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
    ThreadLocal<String> stringLocal = new ThreadLocal<String>();

    private void set() {
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    private long getLong() {
        return longLocal.get();
    }

    private String getString() {
        return stringLocal.get();
    }

    @Deprecated
    public static void threadLocalTest() throws Exception {
        AppThreadLocal app = new AppThreadLocal();
        //报空指针异常
        System.out.println(app.getLong());
        System.out.println(app.getString());

        Thread thread1 = new Thread() {
            public void run() {
                app.set();
                System.out.println(app.getLong());
                System.out.println(app.getString());
            }
        };
        thread1.start();
        thread1.join();

        System.out.println(app.getLong());
        System.out.println(app.getString());
    }

    public static void threadLocalTest01() throws Exception {
        ThreadLocalModel model = new ThreadLocalModel();
        System.out.println("threadId: " + model.getThreadId().get());
        System.out.println("threadName: " + model.getThreadName().get());

        Thread thread1 = new Thread() {
            public void run() {
                System.out.println("threadId: " + model.getThreadId().get());
                System.out.println("threadName: " + model.getThreadName().get());
            }
        };
        thread1.start();
        thread1.join();

        System.out.println("threadId: " + model.getThreadId().get());
        System.out.println("threadName: " + model.getThreadName().get());
    }

    private ThreadLocal<Connection> connection = new ThreadLocal<Connection>() {
        @Override
        protected Connection initialValue() {
            try {
                return DriverManager.getConnection("DB_URL");
            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            }
        }
    };

    public static void threadLocalTest02() throws Exception {
        ThreadLocalModel model = new ThreadLocalModel();
        System.out.println("threadId: " + model.getThreadId().get());
        System.out.println("threadName: " + model.getThreadName().get());

        MyThreadLocal myThreadLocal = new MyThreadLocal(model);
        myThreadLocal.start();
        myThreadLocal.join();

        System.out.println("threadId: " + model.getThreadId().get());
        System.out.println("threadName: " + model.getThreadName().get());
    }
}
