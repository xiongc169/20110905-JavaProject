package org.practice.thread2.chap0402;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server {

	private ThreadPoolExecutor threadPool;

	public Server() {
		threadPool = (ThreadPoolExecutor) Executors.newCachedThreadPool();
	}

	public void executeTaks(Task task) {

		threadPool.execute(task);

		System.out.printf("Server: Pool Size %d\n", threadPool.getPoolSize());
		System.out.printf("Server: Active Size %d\n", threadPool.getActiveCount());
		System.out.printf("Server: Completed Size %d\n", threadPool.getCompletedTaskCount());

	}

	public void endServer() {
		threadPool.shutdown();
	}

}
