package org.practice.activemq2;

import org.practice.activemq2.JMS.MessageReceiver;
import org.practice.activemq2.JMS.MessageSender;

/**
 * ActimeMQ API 深入浅出 消息队列 ActiveMQ
 * 
 * @author chaoxiong
 * @version 2015-08-28 09:55:26
 * 
 *          http://blog.csdn.net/jwdstef/article/details/17380471 <br>
 * 			JMS Provider\JMS for Spring
 * 
 */
public class App {
	public static void main(String[] args) {
		try {
			MessageSender.run();
			MessageReceiver.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Hello World!");
	}
}
