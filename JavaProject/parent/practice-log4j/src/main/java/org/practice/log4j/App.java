package org.practice.log4j;

import org.apache.log4j.Logger;

/**
 * Hello world!
 *
 */
public class App {
	private static Logger logger = Logger.getLogger(App.class);

	public static void main(String[] args) {
		logger.debug("This is debug log");
		logger.info("This is info log");
		logger.warn("This is warn log");
		logger.error("This is error log");
		System.out.println("Hello World!");
	}
}
