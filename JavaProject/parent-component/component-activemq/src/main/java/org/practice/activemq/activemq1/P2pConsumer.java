package org.practice.activemq.activemq1;

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
            System.out.println("consumer4P2P ending");

            //Queue 消费者——MessageListener
            consumerP2PWithListener(isTopic);
            System.out.println("consumer4P2PWithListener ending");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 消费者
     */
    public static void consumerP2P(boolean isTopic) throws Exception {
        //String timeString = format.format(new Date());
        ActiveMQConnectionFactory connFactory = null;
        Connection conn = null;
        Session session = null;
        Destination dest = null;
        MessageConsumer consumer = null;
        try {
            //connFactory = new ActiveMQConnectionFactory(userName, password, brokerUrl);//需认证
            connFactory = new ActiveMQConnectionFactory(brokerUrl);//免认证
            conn = connFactory.createConnection();
            conn.start();// ！！！！！
            session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            if (isTopic) {
                //TODO: 需要先订阅，再发布
                dest = session.createTopic("topic-" + timeString);
            } else {
                dest = session.createQueue("queue-" + timeString);
            }
            consumer = session.createConsumer(dest);//TODO: 控制台 消费者数量加1
            Message message = consumer.receive(1000);
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

    /**
     * Queue 消费者——MessageListener
     */
    public static void consumerP2PWithListener(boolean isTopic) throws Exception {
        //String timeString = format.format(new Date());
        ActiveMQConnectionFactory connFactory = null;
        Connection conn = null;
        Session session = null;
        Destination dest = null;
        MessageConsumer consumer = null;
        try {
            //connFactory = new ActiveMQConnectionFactory(userName, password, brokerUrl);//需认证
            connFactory = new ActiveMQConnectionFactory(brokerUrl);//免认证
            conn = connFactory.createConnection();
            conn.start();// ！！！！！
            session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            if (isTopic) {
                //TODO: 需要先订阅，再发布
                dest = session.createTopic("topic-" + timeString);
            } else {
                dest = session.createQueue("queue-" + timeString);
            }
            consumer = session.createConsumer(dest);//TODO: 控制台 消费者数量加1
            consumer.setMessageListener(new MyMessageListener());
            System.in.read();
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
