package com.yoong.activemq.activemq2.Topic;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;

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
public class TopicReceiver {
    /**
     * tcp 地址
     */
    public static final String BROKER_URL = "tcp://localhost:61616";

    /**
     * 目标，在ActiveMQ管理员控制台创建 http://localhost:8161/admin/queues.jsp
     */
    public static final String TARGET = "hoo.mq.topic";

    /**
     * 入口函数
     */
    public static void main(String[] args) throws Exception {
        try {
            TopicReceiver.run();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void run() throws Exception {
        TopicConnectionFactory topicConnectionFactory = null;
        TopicConnection topicConnection = null;
        TopicSession topicSession = null;
        Topic topic = null;
        TopicSubscriber topicSubscriber = null;
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
            topic = topicSession.createTopic(TARGET);
            // 创建消息制作者
            topicSubscriber = topicSession.createSubscriber(topic);

            topicSubscriber.setMessageListener(new MessageListener() {
                public void onMessage(Message msg) {
                    if (msg != null) {
                        MapMessage map = (MapMessage) msg;
                        try {
                            System.out.println(map.getLong("time") + "接收#" + map.getString("text"));
                        } catch (JMSException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            // 休眠100ms再关闭
            Thread.sleep(1000 * 100);
            // 提交会话
            topicSession.commit();
        } catch (Exception e) {
            throw e;
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
}
