package org.practice.activemq2.Spring;

import java.util.Date;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

/**
 * @author 20180112002
 *
 * @description Sender.java
 * 
 *              http://blog.csdn.net/jwdstef/article/details/17380471 <br>
 *              JMS Provider\JMS for Spring
 *
 * @date 2018年7月25日
 *
 */
public class Sender {

	public static void main(String[] args) {
		ApplicationContext ctx = new FileSystemXmlApplicationContext("classpath:jms4spring2.xml");
		JmsTemplate jmsTemplate = (JmsTemplate) ctx.getBean("jmsTemplate");

		jmsTemplate.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				MapMessage message = session.createMapMessage();
				message.setString("message", "current system time: " + new Date().getTime());

				return message;
			}
		});
	}

}
