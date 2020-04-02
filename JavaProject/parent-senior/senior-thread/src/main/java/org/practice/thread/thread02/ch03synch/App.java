package org.practice.thread.thread02.ch03synch;

import org.practice.thread.thread01.model.ThreadLocalModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yoong
 * <br/>
 * @desc Java并发编程：synchronized <br>
 *       http://www.cnblogs.com/dolphin0520/p/3923737.html <br>
 *       Java并发编程：Lock <br>
 *       http://www.cnblogs.com/dolphin0520/p/3923167.html
 *       Java并发编程：volatile关键字解析
 *       https://www.cnblogs.com/dolphin0520/p/3920373.html
 * <br/>
 * @date 2018年8月29日
 *
 */
public class App {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        //测试代码
        try {
            insertTest();
            synchronizedInsert();
            lockInsert();

            //volatile测试
            App app = new App();
            volatileTest(app);
            while (Thread.activeCount() > 1) {
                //保证前面的线程都执行完
                //System.out.println("Thread.activeCount(): " + Thread.activeCount());
                Thread.yield();
            }
            System.out.println("Thread.activeCount(): " + Thread.activeCount());
            System.out.println(app.count);

            //threadLocal测试
            threadLocalTest();
            threadLocalTest01();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void insertTest() {
        //调用 普通插入 方法
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

    public static void synchronizedInsert() {
        //调用 同步插入(synchronized方法、代码块) 方法
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

    public static void lockInsert() {
        //调用 同步插入(lock) 方法
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

    private Lock lock = new ReentrantLock();

    private AtomicInteger atomicCount = new AtomicInteger();

    public static void volatileTest(App app) {
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        //app.increase();
                        //app.synIncrease();
                        //app.lockIncrease();
                        app.atomicIncrease();
                    }
                }
            });
            thread.start();
        }
    }

    private void increase() {
        //情形一：未同步
        count++;
    }

    private synchronized void synIncrease() {
        //情形二：synchronized同步
        count++;
    }

    private void lockIncrease() {
        //情形三：lock同步
        try {
            lock.lock();
            count++;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void atomicIncrease() {
        //情形四：AtomicInteger同步
        atomicCount.getAndIncrement();
    }

    /**
     * Java并发编程：深入剖析ThreadLocal
     * https://www.cnblogs.com/dolphin0520/p/3920407.html
     */
    ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
    ThreadLocal<String> stringLocal = new ThreadLocal<String>();

    public void set() {
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public long getLong() {
        return longLocal.get();
    }

    public String getString() {
        return stringLocal.get();
    }

    public static void threadLocalTest() throws Exception {
        App app = new App();
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
        model.set();
        System.out.println("threadId: " + model.getThreadId().get());
        System.out.println("threadName: " + model.getThreadName().get());

        Thread thread1 = new Thread() {
            public void run() {
                model.set();
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
}
