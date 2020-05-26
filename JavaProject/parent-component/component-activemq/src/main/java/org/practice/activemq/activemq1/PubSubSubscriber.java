package org.practice.activemq.activemq1;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.text.SimpleDateFormat;
import java.util.UUID;

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
public class PubSubSubscriber {

    private static String userName = "admin";
    private static String password = "admin";
    private static String brokerUrl = "tcp://localhost:61616";
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");
    private static String timeString = "201808250825"; // format.format(new Date());

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            boolean isTopic = true;
            consumerPubSub(isTopic);
            consumerPubSubWithListener();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 订阅者
     */
    public static void consumerPubSub(boolean isTopic) throws Exception {
        //JMS接口 - 连接
        ConnectionFactory connectionFactory = null;
        Connection connection = null;
        Session session = null;
        Topic topic = null;
        MessageConsumer messageConsumer = null;
        TopicSubscriber topicSubscriber = null;
        try {
            //connectionFactory = new ActiveMQConnectionFactory(brokerUrl); //免认证
            connectionFactory = new ActiveMQConnectionFactory(userName, password, brokerUrl); //需认证
            connection = connectionFactory.createConnection();
            connection.setClientID(UUID.randomUUID().toString());
            connection.start();// ！！！！！

            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            topic = session.createTopic("topic-" + timeString);  //TODO: 需要先订阅，再发布
            messageConsumer = session.createDurableSubscriber(topic, "topicConsumer1"); //TODO: 控制台 消费者数量加1
            Message message = messageConsumer.receive(60 * 1000);
            TextMessage text = (TextMessage) message;
            if (text != null) {
                System.out.println("接收：" + text.getText());
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            //不释放资源，应用程序不会停止
            //TODO：创建Topic连接后，释放资源，消费者数据也不会减1
            if (session != null) {
                session.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    /**
     * 订阅者 - MessageListener
     */
    public static void consumerPubSubWithListener() throws Exception {
        //JMS接口 - 连接
        ConnectionFactory connectionFactory = null;
        Connection connection = null;
        Session session = null;
        Topic topic = null;
        TopicSubscriber topicSubscriber = null;
        try {
            connectionFactory = new ActiveMQConnectionFactory(userName, password, brokerUrl);
            connection = connectionFactory.createConnection();
            connection.setClientID(UUID.randomUUID().toString());
            connection.start();// ！！！！！

            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            topic = session.createTopic("topic-" + timeString);
            topicSubscriber = session.createDurableSubscriber(topic, "topicConsumer1");//TODO: 控制台创建 目标地址(Destination)
            topicSubscriber.setMessageListener(new MyMessageListener());
            Integer input = System.in.read();
            System.out.println(input);
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
