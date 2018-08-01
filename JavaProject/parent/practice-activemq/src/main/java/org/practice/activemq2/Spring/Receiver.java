package org.practice.activemq2.Spring;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

/**
 * @author 20180112002
 *
 * @description Receiver.java
 * 
 *              http://blog.csdn.net/jwdstef/article/details/17380471 <br>
 *              JMS Provider\JMS for Spring
 *
 * @date 2018年7月25日
 *
 */
public class Receiver {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		ApplicationContext ctx = new FileSystemXmlApplicationContext("classpath:jms4spring2.xml");

		JmsTemplate jmsTemplate = (JmsTemplate) ctx.getBean("jmsTemplate");
		while (true) {
			Map<String, Object> map = (Map<String, Object>) jmsTemplate.receiveAndConvert();

			System.out.println("收到消息：" + map.get("message"));
		}
	}

}
