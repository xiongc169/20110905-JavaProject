package org.practice.activemq1;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.text.SimpleDateFormat;
import java.util.UUID;

/**
 * @author yoong
 * <br/>
 * @desc http://boy00fly.iteye.com/blog/1103586
 * <br/>
 * @date 2018年7月25日
 */
public class P2PConsumer {

    private static String userName = "admin";
    private static String password = "admin";
    private static String brokerUrl = "tcp://localhost:61616";
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");
    private static String timeString = "201807250725"; // format.format(new Date());

    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            boolean isTopic = true;
            boolean isPersistent = false;

            //Queue 消费者
            consumer4P2P(isTopic);
            System.out.println("consumer4P2P ending");

            //Queue 消费者——MessageListener
            consumer4P2PWithListener(isTopic);
            System.out.println("consumer4P2PWithListener ending");

            //Topic 消费者
            consumer4PubSub(isTopic);
            System.out.println("consumer4PubSub ending");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 消费者
     */
    public static void consumer4P2P(boolean isTopic) throws Exception {
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
    public static void consumer4P2PWithListener(boolean isTopic) throws Exception {
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
            consumer.setMessageListener(new P2PMessageListener());
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

    /**
     * Topic 消费者
     */
    public static void consumer4PubSub(boolean isTopic) throws Exception {
        //String timeString = format.format(new Date());
        ActiveMQConnectionFactory connFactory = null;
        Connection conn = null;
        Session session = null;
        Topic dest = null;
        MessageConsumer consumer = null;
        try {
            //connFactory = new ActiveMQConnectionFactory(userName, password, brokerUrl);//需认证
            connFactory = new ActiveMQConnectionFactory(brokerUrl);//免认证
            conn = connFactory.createConnection();
            conn.setClientID(UUID.randomUUID().toString());
            conn.start();// ！！！！！
            session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            if (isTopic) {
                //TODO: 需要先订阅，再发布
                dest = session.createTopic("topic-" + timeString);
                consumer = session.createDurableSubscriber(dest, "topic-" + timeString);//TODO: 控制台 消费者数量加1
                Message message = consumer.receive(1000);
                TextMessage text = (TextMessage) message;
                if (text != null) {
                    System.out.println("接收：" + text.getText());
                }
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
}
