package org.practice.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App {

	private static Logger log = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		log.debug("This is SLF4J DEBUG 2018-7-25 11:19:59");
		log.info("This is SLF4J INFO 2018-7-25 11:20:10");
		log.warn("This is SLF4J WARN 2018-7-25 11:20:16");
		log.error("This is SLF4J ERROR 2018-7-25 11:20:21");
		System.out.println("SLF4J Ending");
	}
}
