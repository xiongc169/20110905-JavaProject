package org.practice.log4j;

import org.apache.log4j.Logger;

/**
 * Hello world!
 *
 */
public class App {
	private static Logger logger = Logger.getLogger(App.class);

	public static void main(String[] args) {
		logger.debug("This is LOG4J DEBUG 2018-7-25 11:19:59");
		logger.info("This is LOG4J INFO 2018-7-25 11:19:59");
		logger.warn("This is LOG4J WARN 2018-7-25 11:19:59");
		logger.error("This is LOG4J ERROR 2018-7-25 11:19:59");
		System.out.println("LOG4J Ending");
	}
}
