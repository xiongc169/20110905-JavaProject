package org.practice.activemq1;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTextMessage;

import javax.jms.*;

/**
 * @author 20180112002
 * @desc JMS简介与ActiveMQ实战
 * PS：http://boy00fly.iteye.com/blog/1103586
 * @date 2018年7月25日
 */
public class App01 {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            producer();
            consumer();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void producer() {
        try {
            ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("admin", "admin", "tcp://127.0.0.1:61616");
            Connection conn = factory.createConnection();
            conn.start();

            Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("yoong");
            MessageProducer producer = session.createProducer(destination);
            ActiveMQTextMessage msg = new ActiveMQTextMessage();
            msg.setText("2019年9月12日14:58:43");
            producer.send(msg);

            session.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void consumer() {
        try {
            ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("admin", "admin", "tcp://127.0.0.1:61616");
            Connection conn = factory.createConnection();
            conn.start();

            Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("yoong");
            MessageConsumer consumer = session.createConsumer(destination);
            Message msg = consumer.receive(1000);
            if (msg instanceof ActiveMQTextMessage) {
                String text = ((ActiveMQTextMessage) msg).getText();
                System.out.println(text);
            }

            session.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
