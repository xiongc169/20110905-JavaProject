package org.practice.designPattern.behavior.responsibilityChain;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		responsibleChain();

	}

	public static void responsibleChain() {
		FileLogger file = new FileLogger(3, null);
		ErrorLogger error = new ErrorLogger(2, file);
		ConsoleLogger console = new ConsoleLogger(1, error);

		console.logger(5, "1234");
	}
}
