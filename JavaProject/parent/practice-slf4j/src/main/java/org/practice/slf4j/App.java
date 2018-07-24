package org.practice.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		// Logger log = LoggerFactory.getLogger(App.class);
		// log.debug("debug");
		// log.info("info");
		// log.error("error");

		Logger logger = LoggerFactory.getLogger(App.class);
		logger.info("Hello World");
		System.out.println("Hello World!");
	}
}
