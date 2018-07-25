package org.practice.activemq1;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * @author yoong
 *
 * @description http://boy00fly.iteye.com/blog/1103586
 *
 * @date 2018年7月25日
 *
 */
public class P2PProducer {

	public static void main(String[] args) {
		producer4P2P(false);
		System.out.println("producer4P2P ending");
		consumer4P2P(false);
		System.out.println("consumer4P2P ending");
	}

	private static String userName = "admin";
	private static String password = "admin";
	private static String brokerUrl = "tcp://localhost:61616";
	private static SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");

	public static void producer4P2P(boolean topic) {
		String timeString = "20180725164311"; // format.format(new Date());
		Connection conn = null;
		Session session = null;
		Destination dest = null;
		MessageProducer producer = null;
		TextMessage message = null;
		try {
			conn = new ActiveMQConnectionFactory(userName, password, brokerUrl).createConnection();
			conn.start();// ！！！！！
			session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			if (topic) {
				dest = session.createTopic("topic-" + timeString);
			} else {
				dest = session.createQueue("queue-" + timeString);
			}
			producer = session.createProducer(dest);
			message = session.createTextMessage("2018年7月25日16:27:45");
			producer.send(message);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public static void consumer4P2P(boolean topic) {
		String timeString = "20180725164311"; // format.format(new Date());
		Connection conn = null;
		Session session = null;
		Destination dest = null;
		MessageConsumer consumer = null;
		Message message = null;
		try {
			conn = new ActiveMQConnectionFactory(userName, password, brokerUrl).createConnection();
			conn.start();// ！！！！！
			session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			if (topic) {
				dest = session.createTopic("topic-" + timeString);
			} else {
				dest = session.createQueue("queue-" + timeString);
			}
			consumer = session.createConsumer(dest);

			message = consumer.receive(1000);
			TextMessage text = (TextMessage) message;
			if (text != null) {
				System.out.println("接收：" + text.getText());
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
