package org.practice.junior.book01.chap14.thread01.ch07concurrent;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.*;

/**
 * @Desc Java并发包
 * http://blog.csdn.net/heyutao007/article/details/5672804
 * <p>
 * @Author yoong
 * <p>
 * @Date 2015-08-30 09:06:00
 * <p>
 * @Version 1.0
 */
public class AppConcurrent {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        //测试
        try {
            executorServiceDemo();
            lockDemo();
            concurrentCollectionDemo();
            atomicIntegerDemo();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Executors类，能够获得多种线程池的实例
     */
    public static void executorServiceDemo() {
        ExecutorService cachedPool = Executors.newCachedThreadPool(); // 创建一个缓冲池，缓冲池容量大小为Integer.MAX_VALUE
        ExecutorService singlePool = Executors.newSingleThreadExecutor(); // 创建容量为1的缓冲池
        ExecutorService fixedPool = Executors.newFixedThreadPool(10); // 创建固定容量大小的缓冲池
        //execute()方法，入参Runnable，无返回值
        //submit()方法，入参Runnable\Callable，有返回值
        cachedPool.execute(new Runnable() {
            @Override
            public void run() {

            }
        });
        cachedPool.submit(new Runnable() {
            @Override
            public void run() {

            }
        });
        cachedPool.submit(new Callable<Object>() {
            public Object call() throws Exception {
                return null;
            }
        });
    }

    /**
     * Lock类，锁定某个对象，常用的有ReentrantLock；
     * Condition类
     * Lock代替了synchronized，后者代替了wait\notify\notifyAll
     */
    public static void lockDemo() {
        Lock lk = new ReentrantLock();
        lk.lock();
        try {
            int a = 0;
        } catch (Exception e) {
        } finally {
            lk.unlock();
        }

        Condition notnull = lk.newCondition();
        Condition notempty = lk.newCondition();
    }

    /**
     * 并发集合类
     * http://www.cnblogs.com/huangfox/archive/2012/08/16/2642666.html
     */
    public static void concurrentCollectionDemo() {
        ConcurrentHashMap<String, String> hashMap = new ConcurrentHashMap<String, String>();
        hashMap.put("key", "map");
        String obj = hashMap.get("key");
        hashMap.put("key", "map_new");
        obj = hashMap.get("key");

        ConcurrentLinkedQueue<String> linkedQueue = new ConcurrentLinkedQueue<String>();
        CopyOnWriteArrayList<String> arraylist = new CopyOnWriteArrayList<String>();
        CopyOnWriteArraySet<String> arraySet = new CopyOnWriteArraySet<String>();
        ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(20);
    }

    /**
     * java.util.concurrent.atomic提供了很多工具类，可以以原子方式更新变量
     * AtomicInteger，一个提供原子操作的Integer的类
     */
    public static void atomicIntegerDemo() {
        AtomicInteger ai = new AtomicInteger(0);

        int i1 = ai.get();
        System.out.println(i1);

        int i2 = ai.getAndSet(5);
        System.out.println(i2);

        int i3 = ai.get();
        System.out.println(i3);

        int i4 = ai.getAndIncrement();
        System.out.println(i4);

        System.out.println(ai.get());
    }
}
