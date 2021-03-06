package com.yoong.activemq.activemq2.Topic;

import javax.jms.DeliveryMode;
import javax.jms.MapMessage;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * @Desc 深入浅出消息队列 ActiveMQ
 * PS：使用发布/订阅域方式发送接收消息
 * http://blog.csdn.net/jwdstef/article/details/17380471
 * <p>
 * @Author yoong
 * <p>
 * @Date 2015-08-28 09:55:26
 * <p>
 * @Version 1.0
 */
public class TopicSender {
    /**
     * 发送次数
     */
    public static final int SEND_NUM = 5;

    /**
     * tcp 地址
     */
    public static final String BROKER_URL = "tcp://localhost:61616";

    /**
     * 目标，在ActiveMQ管理员控制台创建 http://localhost:8161/admin/queues.jsp
     */
    public static final String DESTINATION = "hoo.mq.topic";

    /**
     * 入口函数
     */
    public static void main(String[] args) throws Exception {
        try {
            TopicSender.run();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void run() throws Exception {
        TopicConnectionFactory topicConnectionFactory = null;
        TopicConnection topicConnection = null;
        TopicSession topicSession = null;
        Topic topic = null;
        TopicPublisher topicPublisher = null;
        try {
            // 创建链接工厂
            topicConnectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD, BROKER_URL);
            // 通过工厂创建一个连接
            topicConnection = topicConnectionFactory.createTopicConnection();
            // 启动连接
            topicConnection.start();
            // 创建一个session会话
            topicSession = topicConnection.createTopicSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            // 创建一个消息队列
            topic = topicSession.createTopic(DESTINATION);
            // 创建消息发送者
            topicPublisher = topicSession.createPublisher(topic);
            // 设置持久化模式
            topicPublisher.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            sendMessage(topicSession, topicPublisher);
            // 提交会话
            topicSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭释放资源
            if (topicSession != null) {
                topicSession.close();
            }
            if (topicConnection != null) {
                topicConnection.close();
            }
        }
    }

    public static void sendMessage(TopicSession session, TopicPublisher publisher) throws Exception {
        for (int i = 0; i < SEND_NUM; i++) {
            String message = "Topic发送消息第" + (i + 1) + "条";

            MapMessage map = session.createMapMessage();
            map.setString("text", message);
            map.setLong("time", System.currentTimeMillis());
            publisher.send(map);
            System.out.println(map);

        }
    }
}
