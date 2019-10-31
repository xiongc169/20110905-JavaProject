package org.practice.activemq.activemq2.Test;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Receiver {

    private static String brokerURL = "tcp://127.0.0.1:61616";
    private static String userName = "admin";
    private static String password = "admin";
    private static String queueName = "yoong09191106";

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            // Receiver.receiveSync();
            Receiver.receiveAsync();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 同步接收消息
     */
    public static void receiveSync() {
        ActiveMQConnectionFactory connFactory = null;
        Session session = null;
        Destination destination = null;
        MessageConsumer consumer = null;

        try {
            connFactory = new ActiveMQConnectionFactory(userName, password, brokerURL);
            Connection conn = connFactory.createConnection();
            conn.start();

            session = conn.createSession(true, 0);
            destination = session.createQueue(queueName);

            consumer = session.createConsumer(destination);
            TextMessage message2 = (TextMessage) consumer.receive();
            System.out.println(message2.getText());

            session.commit();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    /**
     * 异步接收消息
     */
    public static void receiveAsync() {
        ActiveMQConnectionFactory connFactory = null;
        Session session = null;
        Destination destination = null;
        MessageConsumer consumer = null;

        try {
            connFactory = new ActiveMQConnectionFactory(userName, password, brokerURL);
            Connection conn = connFactory.createConnection();
            conn.start();

            session = conn.createSession(true, 0);
            destination = session.createQueue(queueName);

            consumer = session.createConsumer(destination);
            consumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    TextMessage message2 = (TextMessage) message;
                    try {
                        System.out.println(message2.getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            });

            session.commit();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
