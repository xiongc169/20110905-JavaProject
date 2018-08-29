package org.practice.thread.ch03pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.practice.thread.ch02primary.MyRunnable;
import org.practice.thread.model.Person;
import org.practice.thread.practice.InputCallable;

import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;

public class MyThreadPool {

	/**
	 * Java并发编程：线程池的使用<br>
	 * http://www.cnblogs.com/dolphin0520/p/3932921.html
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		threadPoolExecutor();
	}

	/**
	 * ThreadPoolExecutor类
	 */
	public static void threadPoolExecutor() {
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
	public static void otherPool() {
		ExecutorService single = Executors.newSingleThreadExecutor();// 创建容量为1的缓冲池
		ExecutorService fixed = Executors.newFixedThreadPool(5);// 创建固定容量大小的缓冲池
		ExecutorService cache = Executors.newCachedThreadPool();// 创建一个缓冲池，缓冲池容量大小为Integer.MAX_VALUE
	}
}
