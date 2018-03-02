package org.practice.thread2.chap0113;

public class App {

	public static void main(String[] args) {

		MyThreadFactory factory = new MyThreadFactory("chaoxiong");

		Task task = new Task();
		Thread thread = factory.newThread(task);
	}

}
