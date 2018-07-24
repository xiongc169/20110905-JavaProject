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

		log.debug("This is debug 2018年7月24日18:05:56");
		log.info("This is info 2018年7月24日18:06:15");
		log.error("This is error 2018年7月24日18:06:19");
	}
}
