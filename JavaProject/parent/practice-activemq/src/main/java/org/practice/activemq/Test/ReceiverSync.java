package org.practice.activemq.Test;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class ReceiverSync {

	private String brokerURL = "tcp://192.168.75.162:61616";

	private String userName = "admin";

	private String password = "admin";

	public void run() {

		ActiveMQConnectionFactory connFactory = null;
		Session session = null;
		Destination destination = null;
		MessageConsumer consumer = null;

		try {
			connFactory = new ActiveMQConnectionFactory(userName, password, brokerURL);
			Connection conn = connFactory.createConnection();
			conn.start();

			session = conn.createSession(true, 0);
			destination = session.createQueue("yoong09191106");

			consumer = session.createConsumer(destination);
			TextMessage message2 = (TextMessage) consumer.receive();
			System.out.println(message2.getText());

			session.commit();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
