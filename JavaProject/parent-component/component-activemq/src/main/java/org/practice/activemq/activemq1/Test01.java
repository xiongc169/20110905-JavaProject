package org.practice.activemq.activemq1;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTextMessage;

import javax.jms.*;

/**
 * @Desc JMS简介与ActiveMQ实战
 * PS：https://www.iteye.com/blog/boy00fly-1103586
 * <p>
 * @Author 20180112002
 * <p>
 * @Date 2018年7月25日
 * <p>
 * @Version 1.0
 */
public class Test01 {

    private static String userName = "admin";
    private static String password = "admin";
    private static String brokerURL = "tcp://127.0.0.1:61616";

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            //生产者
            producer();
            //消费者
            consumer();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void producer() {
        try {
            //JMS接口 - 连接
            ConnectionFactory factory = new ActiveMQConnectionFactory(userName, password, brokerURL);
            Connection conn = factory.createConnection();
            conn.start();

            Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("yoong");
            MessageProducer producer = session.createProducer(destination); //TODO: 控制台创建 目标地址(Destination)
            TextMessage msg = new ActiveMQTextMessage();
            msg.setText("2019年9月12日14:58:43");
            producer.send(msg); //Number Of Pending Messages、Messages Enqueued 数量+1

            session.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void consumer() {
        try {
            //JMS接口 - 连接
            ConnectionFactory factory = new ActiveMQConnectionFactory(userName, password, brokerURL);
            Connection conn = factory.createConnection();
            conn.start();

            Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("yoong");
            MessageConsumer consumer = session.createConsumer(destination); //TODO: 控制台 消费者数量+1
            Message msg = consumer.receive(1000);   //Number Of Pending Messages 数量-1，Messages Dequeued 数量+1
            //msg.acknowledge();
            if (msg instanceof TextMessage) {
                String text = ((TextMessage) msg).getText();
                System.out.println(text);
            }

            session.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
