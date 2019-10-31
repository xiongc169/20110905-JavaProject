package org.practice.activemq.activemq2.Test;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Sender {

    private static String brokerURL = "tcp://127.0.0.1:61616";
    private static String userName = "admin";
    private static String password = "admin";
    private static String queueName = "yoong09191106";
    private static int NUM = 10;

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            Sender.send();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public static void send() throws JMSException {
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
            destination = session.createQueue(queueName);
            procedure = session.createProducer(destination);

            for (int i = 0; i < NUM; i++) {
                TextMessage message = session.createTextMessage("Hello World " + i);
                procedure.send(message);
            }
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
