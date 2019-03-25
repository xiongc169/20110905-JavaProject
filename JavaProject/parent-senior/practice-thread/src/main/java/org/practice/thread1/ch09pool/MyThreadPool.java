package org.practice.thread1.ch09pool;

import java.util.concurrent.*;

import org.practice.thread.ch02sync.MyRunnable;
import org.practice.thread.ch02sync.MyThreadFactory;

import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;

/**
 * Java并发编程：线程池的使用<br>
 * http://www.cnblogs.com/dolphin0520/p/3932921.html
 */
public class MyThreadPool {

    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            getByConstructor();
            getByExecutors();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * ThreadPoolExecutor类
     */
    public static void getByConstructor() {
        //创建执行器(ThreadPoolExecutor)方式一：构造函数
        ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 8, 1000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));
        ThreadPoolExecutor pool2 = new ThreadPoolExecutor(5, 10, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), new AbortPolicy());
        for (int i = 0; i < 10; i++) {
            MyRunnable runnable = new MyRunnable();
            pool.execute(runnable);
            System.out.println("线程池中线程数目：" + pool.getPoolSize() + "，队列中等待执行的任务数目：" + pool.getQueue().size() + "，已执行玩别的任务数目：" + pool.getCompletedTaskCount());
        }

        ThreadFactory tFactory = new MyThreadFactory();
        ThreadPoolExecutor pool3 = new ThreadPoolExecutor(1, 1, 1000, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), tFactory);
    }

    /**
     * ExecutorService接口
     */
    public static void getByExecutors() {
        //创建执行器(ThreadPoolExecutor)方式二：Executors的静态方法
        ExecutorService single = Executors.newSingleThreadExecutor();// 创建容量为1的缓冲池
        ExecutorService singleConstructor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

        ExecutorService fixed = Executors.newFixedThreadPool(5);// 创建固定容量大小的缓冲池
        ExecutorService fixedConstructor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

        ExecutorService cache = Executors.newCachedThreadPool();// 创建一个缓冲池，缓冲池容量大小为Integer.MAX_VALUE
        ExecutorService cacheConstructor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
    }
}
