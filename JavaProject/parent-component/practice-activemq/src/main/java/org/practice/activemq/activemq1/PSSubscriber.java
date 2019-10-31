package org.practice.activemq.activemq1;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.text.SimpleDateFormat;
import java.util.UUID;

/**
 * @author 20180112002
 * @description http://boy00fly.iteye.com/blog/1103586
 * @date 2018年7月25日
 */
public class PSSubscriber {

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
            consumer4PubSub(isTopic);
            consumer4PubSubWithListener();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 订阅者
     */
    public static void consumer4PubSub(boolean isTopic) throws Exception {
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
            consumer = session.createDurableSubscriber(dest, "topicConsumer1");
            Message message = consumer.receive(60 * 1000);
            TextMessage text = (TextMessage) message;
            if (text != null) {
                System.out.println("接收：" + text.getText());
            }
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

    public static void consumer4PubSubWithListener() throws Exception {
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
            consumer.setMessageListener(new P2PMessageListener());
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
