package org.practice.thread.ch02primary;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import org.practice.thread.model.Account;
import org.practice.thread.model.Person;
import org.practice.thread.practice.InputCallable;

/**
 * 
 * @author Administrator
 *
 */
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		accountTest();
	}

	public static void myThreadTest() {
		MyThread myThread = new MyThread();
		// for (int i = 0; i < 10; i++) {
		// Thread thread = new Thread(myThread);
		// thread.start();
		// }
		Thread threadA = new Thread(myThread);
		Thread threadB = new Thread(myThread);
		Thread threadC = new Thread(myThread);
		Thread threadD = new Thread(myThread);
		threadA.start();
		threadB.start();
		threadC.start();
		threadD.start();
	}

	public static void myRunnable() {
		for (int i = 0; i < 10; i++) {
			MyRunnable myRun = new MyRunnable();
			Thread myTh = new Thread(myRun);
			myTh.start();
		}
	}

	public static void callableTest() {

		InputCallable myCallable = new InputCallable();
		FutureTask ft = new FutureTask(myCallable);
		Thread thread = new Thread(ft);
		thread.start();

		try {
			Person p = (Person) ft.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 线程安全测试 http://www.cnblogs.com/lwbqqyumidi/p/3821389.html
	 */
	public static void accountTest() {
		Account account = new Account("123456", 1000);
		AccountRunnable drawMoneyRunnable = new AccountRunnable(account, 700);
		Thread myThread1 = new Thread(drawMoneyRunnable);
		Thread myThread2 = new Thread(drawMoneyRunnable);
		myThread1.start();
		myThread2.start();
		// System.out.printf("Balance: %f \n", account.getBalance());
	}
}
