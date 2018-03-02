package org.practice.thread2.chap0104;

public class PrimeTask implements Runnable {

	private long number;

	public PrimeTask(long number) {
		this.number = number;
	}

	public void run() {

		while (true) {
			if (isPrime(number)) {
				System.out.printf("Prime: %d \n", number);

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			number++;
		}
	}

	private boolean isPrime(long number) {

//		System.out.printf("Prime: %d ;", number);
		if (number >= 1 && number <= 2)
			return true;

		for (int i = 2; i < number; i++) {
			if (number % i == 0)
				return false;
		}

		return true;
	}

}
