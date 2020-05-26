package org.practice.activemq.activemq1;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTextMessage;

import javax.jms.*;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class PubSubPublisher {

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
            producerPubSub(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 发布者
     */
    public static void producerPubSub(boolean isTopic) throws Exception {
        //JMS接口 - 连接
        ConnectionFactory connFactory = null;
        Connection conn = null;
        Session session = null;
        Topic topic = null;
        MessageProducer producer = null;
        try {
            connFactory = new ActiveMQConnectionFactory(userName, password, brokerUrl);
            conn = connFactory.createConnection();
            conn.setClientID(UUID.randomUUID().toString());
            conn.start();// ！！！！！

            session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            topic = session.createTopic("topic-" + timeString);
            producer = session.createProducer(topic);//TODO: 控制台创建 目标地址(Destination)

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
