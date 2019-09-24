package org.practice.activemq1;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTextMessage;

import javax.jms.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author 20180112002
 * @description http://boy00fly.iteye.com/blog/1103586
 * @date 2018年7月25日
 */
public class PSPublisher {

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
            producer4PubSub(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 发布者
     */
    public static void producer4PubSub(boolean isTopic) throws Exception {
        //String timeString = format.format(new Date());
        ActiveMQConnectionFactory connFactory = null;
        Connection conn = null;
        Session session = null;
        Topic topic = null;
        TopicSubscriber consumer = null;
        try {
            connFactory = new ActiveMQConnectionFactory(userName, password, brokerUrl);
            conn = connFactory.createConnection();
            conn.setClientID(UUID.randomUUID().toString());
            conn.start();// ！！！！！
            session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            topic = session.createTopic("topic-" + timeString);
            MessageProducer producer = session.createProducer(topic);//TODO: 控制台创建 目标地址(Destination)
            ActiveMQTextMessage message = new ActiveMQTextMessage();
            message.setText(format.format(new Date()));
            producer.send(message);
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
