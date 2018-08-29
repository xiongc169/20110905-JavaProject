package org.practice.thread.ch01primary;

import java.util.concurrent.FutureTask;

import org.practice.thread.ch02primary.MyThread;
import org.practice.thread.model.Person;

/**
 * Java总结篇系列：Java多线程（一）<br>
 * http://www.cnblogs.com/lwbqqyumidi/p/3804883.html
 * 
 * @author Administrator
 *
 */
public class App {

	public static void main(String[] args) {

		long threadId = Thread.currentThread().getId();
		String threadName = Thread.currentThread().getName();

		MyThread myThread1 = new MyThread();
		Thread myThread2 = new Thread(myThread1);
		Thread myThread3 = new Thread(myThread1);
		Thread myThread4 = new Thread(myThread1);
		Thread myThread5 = new Thread(myThread1);
		Thread myThread6 = new Thread(myThread1);
		Thread myThread7 = new Thread(myThread1);
		Thread myThread8 = new Thread(myThread1);
		Thread myThread9 = new Thread(myThread1);

		myThread2.start();
		myThread3.start();
		myThread4.start();
		myThread5.start();
		myThread6.start();
		myThread7.start();
		myThread8.start();
		myThread9.start();

		System.out.println("Current ThreadId: " + threadId + "; Current ThreadName: " + threadName);

	}

	public static void test() {
		// 1.Thread 测试
		MyThread myThread = new MyThread();
		myThread.start();

		ThreadLocal local = new ThreadLocal();
		// 2.Runnable 测试
		MyRunnable myRunnable = new MyRunnable();
		Thread runnableThread = new Thread(myRunnable);
		runnableThread.start();

		// 3.Thread + Runnable 测试
		MyRunnable myRunnable2 = new MyRunnable();
		MyThread myThread2 = new MyThread(myRunnable2);
		myThread2.start();

		// 4.Callable + FutureTask 测试
		try {
			MyCallable myCallable = new MyCallable();
			FutureTask ftask = new FutureTask(myCallable);
			Thread taskThread = new Thread(ftask);
			taskThread.start();

			Object result = ftask.get();
			System.out.println(result);
		} catch (Exception ex) {
			String msg = ex.getMessage();
			System.out.println(msg);
		}
	}

	public static void threadTest() throws InterruptedException {
		System.out.println("threadTest Begin");

		Person person = new Person("chaoxiong", 25, 25);
		for (int i = 0; i < 10; i++) {
			MyThread thread = new MyThread(person);
			thread.start();
			thread.join();
			Thread.interrupted();
			thread.isInterrupted();
			thread.interrupt();
			Thread.currentThread().isInterrupted();
		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("threadTest End");
	}

}
