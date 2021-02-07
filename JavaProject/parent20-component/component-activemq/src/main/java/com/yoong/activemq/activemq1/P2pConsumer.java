package com.yoong.activemq.activemq1;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.text.SimpleDateFormat;

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
public class P2pConsumer {

    private static String userName = "admin";
    private static String password = "admin";
    private static String brokerUrl = "tcp://localhost:61616";
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");
    private static String timeString = "201807250725"; // format.format(new Date());

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            boolean isTopic = false;
            boolean isPersistent = false;

            //Queue 消费者
            consumerP2P(isTopic);
            System.out.println("consumerP2P ending");

            //Queue 消费者——MessageListener
            consumerP2PWithListener(isTopic);
            System.out.println("consumerP2PWithListener ending");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 消费者
     */
    public static void consumerP2P(boolean isTopic) throws Exception {
        //JMS接口 - 连接
        ConnectionFactory connectionFactory = null;
        Connection connection = null;
        Session session = null;
        //JMS接口 - 目的地、生产者、消费者
        Destination dest = null;
        MessageConsumer messageConsumer = null;
        //JMS接口 - 消息类型
        TextMessage textMessage = null;

        try {
            //connectionFactory = new ActiveMQConnectionFactory(userName, password, brokerUrl);//需认证
            connectionFactory = new ActiveMQConnectionFactory(brokerUrl);//免认证
            connection = connectionFactory.createConnection();
            connection.start();// ！！！！！

            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            if (isTopic) {
                //TODO: 需要先订阅，再发布
                dest = session.createTopic("topic-" + timeString);
            } else {
                dest = session.createQueue("queue-" + timeString);
            }
            messageConsumer = session.createConsumer(dest);//TODO: 控制台 消费者数量加1
            Message message = messageConsumer.receive(1000);
            textMessage = (TextMessage) message;
            if (textMessage != null) {
                System.out.println("接收：" + textMessage.getText());
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            //不释放资源，应用程序不会停止
            if (session != null) {
                session.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    /**
     * Queue 消费者——MessageListener
     */
    public static void consumerP2PWithListener(boolean isTopic) throws Exception {
        //JMS接口 - 连接
        ConnectionFactory connectionFactory = null;
        Connection connection = null;
        Session session = null;
        //JMS接口 - 目的地、生产者、消费者
        Destination dest = null;
        MessageConsumer messageConsumer = null;
        //JMS接口 - 消息类型
        TextMessage textMessage = null;

        try {
            //connectionFactory = new ActiveMQConnectionFactory(userName, password, brokerUrl);//需认证
            connectionFactory = new ActiveMQConnectionFactory(brokerUrl);//免认证
            connection = connectionFactory.createConnection();
            connection.start();// ！！！！！

            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            if (isTopic) {
                //TODO: 需要先订阅，再发布
                dest = session.createTopic("topic-" + timeString);
            } else {
                dest = session.createQueue("queue-" + timeString);
            }
            messageConsumer = session.createConsumer(dest);//TODO: 控制台 消费者数量加1
            messageConsumer.setMessageListener(new MyMessageListener());
            System.in.read();
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            //不释放资源，应用程序不会停止
            if (session != null) {
                session.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
