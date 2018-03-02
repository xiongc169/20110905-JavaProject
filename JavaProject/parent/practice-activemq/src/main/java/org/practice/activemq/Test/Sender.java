package org.practice.activemq.Test;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Sender {

	private String brokerURL = "tcp://192.168.75.162:61616";
	private String userName = "admin";
	private String password = "admin";

	public void Send() throws JMSException {

		ActiveMQConnectionFactory connFactory = null;
		Connection conn = null;
		Session session = null;
		Destination destination = null;
		MessageProducer procedure = null;

		try {
			connFactory = new ActiveMQConnectionFactory(userName, password, brokerURL);
			conn = connFactory.createConnection();
			conn.start();

			session = conn.createSession(true, Session.AUTO_ACKNOWLEDGE);
			destination = session.createQueue("yoong09191106");
			procedure = session.createProducer(destination);

			TextMessage message = session.createTextMessage("Hello");
			procedure.send(message);
			session.commit();
		} catch (Exception ex) {
			if (session != null) {
				session.rollback();
				session.close();
				session = null;
			}
		}
	}

}
