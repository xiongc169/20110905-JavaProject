package org.practice.thread.book01.chap0102;

public class Calculator implements Runnable {

	private int number;

	public Calculator(int number) {
		this.number = number;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.printf("%s: %d * %d = %d\n", Thread.currentThread().getName(), number, i, number * i);
			// if (number == 5 && i == 9) {
			// System.exit(0);
			// }
		}
	}
}
