package org.practice.thread2.chap0104;

public class PrimeTask implements Runnable {

	private long number;

	public PrimeTask(long number) {
		this.number = number;
	}

	public void run() {

		while (true) {
			if (isPrime(number)) {
				System.out.printf("Number %d is prime \n", number);
			}

			// Thread.interrupted()
			// Thread.currentThread().isInterrupted()
			if (Thread.currentThread().isInterrupted()) {
				System.out.printf("PrimeTask has been interrupted \n");
//				System.out.printf("Thread.interrupted() " + Thread.interrupted());
				System.out.printf("Thread.currentThread().isInterrupted()" + Thread.currentThread().isInterrupted());
				System.exit(0);
				// return;
			}
			number++;
		}
	}

	private boolean isPrime(long number) {

		if (number >= 1 && number <= 2)
			return true;

		for (int i = 2; i < number; i++) {
			if (number % i == 0)
				return false;
		}

		return true;
	}

}
