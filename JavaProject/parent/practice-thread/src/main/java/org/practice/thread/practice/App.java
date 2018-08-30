package org.practice.thread.practice;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.practice.model.Person;

public class App {

	public static void main(String[] args) {
		concurrentTest();
	}

	/**
	 * Callable,Runnable比较及用法 <br>
	 * http://blog.csdn.net/heyutao007/article/details/19072675
	 *
	 */
	public static void concurrentTest() {
		// InputThread input=new InputThread();
		// input.start();
		// Person person = input.person;
		// if(person==null){}

		ExecutorService pool = Executors.newFixedThreadPool(2);
		InputCallable task = new InputCallable();
		Future f1 = pool.submit(task);
		Person person;
		try {
			person = (Person) f1.get();// 会阻塞当前线程
			f1.cancel(false);
			if (person == null) {
				System.out.println("返回值为空");
			} else {
				System.out.println("返回值不为空");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pool.shutdown();
	}
}
