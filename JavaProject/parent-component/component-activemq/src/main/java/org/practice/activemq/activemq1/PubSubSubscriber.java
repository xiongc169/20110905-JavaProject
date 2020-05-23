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
        ActiveMQConnectionFactory connFactory = null;
        Connection conn = null;
        Session session = null;
        Topic dest = null;
        TopicSubscriber consumer = null;
        try {
            //connFactory = new ActiveMQConnectionFactory(brokerUrl); //免认证
            connFactory = new ActiveMQConnectionFactory(userName, password, brokerUrl); //需认证
            conn = connFactory.createConnection();
            conn.setClientID(UUID.randomUUID().toString());
            conn.start();// ！！！！！

            session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            dest = session.createTopic("topic-" + timeString);  //TODO: 需要先订阅，再发布
            consumer = session.createDurableSubscriber(dest, "topicConsumer1"); //TODO: 控制台 消费者数量加1
            Message message = consumer.receive(60 * 1000);
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
            if (conn != null) {
                conn.close();
            }
        }
    }

    /**
     * 订阅者 - MessageListener
     */
    public static void consumerPubSubWithListener() throws Exception {
        //String timeString = format.format(new Date());
        ActiveMQConnectionFactory connFactory = null;
        Connection conn = null;
        Session session = null;
        Topic dest = null;
        TopicSubscriber consumer = null;
        try {
            connFactory = new ActiveMQConnectionFactory(userName, password, brokerUrl);
            conn = connFactory.createConnection();
            conn.setClientID(UUID.randomUUID().toString());
            conn.start();// ！！！！！

            session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            dest = session.createTopic("topic-" + timeString);
            consumer = session.createDurableSubscriber(dest, "topicConsumer1");//TODO: 控制台创建 目标地址(Destination)
            consumer.setMessageListener(new MyMessageListener());
            Integer input = System.in.read();
            System.out.println(input);
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            //不释放资源，应用程序不会停止
            if (session != null) {
                session.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
}
