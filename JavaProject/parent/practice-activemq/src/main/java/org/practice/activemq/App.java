package org.practice.activemq;

import org.practice.activemq.JMS.MessageReceiver;
import org.practice.activemq.JMS.MessageSender;

/**
 * ActimeMQ API 深入浅出 消息队列 ActiveMQ
 * 
 * @author chaoxiong
 * @version 2015-08-28 09:55:26
 * 
 *          http://blog.csdn.net/jwdstef/article/details/17380471
 * 
 */
public class App {
	public static void main(String[] args) {
		try {
			MessageSender.run();
			MessageReceiver.run();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Hello World!");
	}
}
