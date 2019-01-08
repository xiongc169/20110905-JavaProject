package org.practice.thread1.ch07container;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Java并发编程：阻塞队列 <br>
 * http://www.cnblogs.com/dolphin0520/p/3932906.html
 * 
 * @author Administrator
 *
 */
public class MyBlockingQueue {

	/**
	 * 入口函数
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		// 常见阻塞队列
		ArrayBlockingQueue arrayQueue = new ArrayBlockingQueue(10);
		LinkedBlockingQueue linkedQueue = new LinkedBlockingQueue();
		PriorityBlockingQueue priorityQueue = new PriorityBlockingQueue();
		DelayQueue delayQueue = new DelayQueue();
		SynchronousQueue synchronousQueue = new SynchronousQueue();

		// 常见线程池及其构造函数
		ExecutorService single = Executors.newSingleThreadExecutor();
		ExecutorService singleConstructor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

		ExecutorService fixed = Executors.newFixedThreadPool(10);
		ExecutorService fixedConstructor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

		ExecutorService cache = Executors.newCachedThreadPool();
		ExecutorService cacheConstructor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());

	}

}
