package org.practice.thread2.chap0404;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class App {

	public static void main(String[] args) {

		Random random = new Random();
		List<Future<Integer>> resultList = new ArrayList<Future<Integer>>();
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

		for (int i = 0; i < 10; i++) {

			int num = random.nextInt(10);
			FactorialCalculator calculator = new FactorialCalculator(num);
			Future<Integer> result = executor.submit(calculator);
			resultList.add(result);
		}

		do {
			for (int i = 0; i < resultList.size(); i++) {
				Future<Integer> result = resultList.get(i);
				System.out.printf("Thread: %s, Status: %s \n", Thread.currentThread().getName(), result.isDone());
			}

		} while (executor.getCompletedTaskCount() < resultList.size());

		for (int i = 0; i < resultList.size(); i++) {
			Future<Integer> result = resultList.get(i);
			try {
				Integer number = result.get();
				System.out.printf("Thread: %s, result: %s \n", Thread.currentThread().getName(), number);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		executor.shutdown();
	}

}
