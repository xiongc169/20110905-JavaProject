package org.practice.activemq.activemq2.P2P;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * @Desc 深入浅出消息队列 ActiveMQ
 * PS：使用JMS方式发送接收消息
 * http://blog.csdn.net/jwdstef/article/details/17380471
 * <p>
 * @Author yoong
 * <p>
 * @Date 2015-08-28 09:55:26
 * <p>
 * @Version 1.0
 */
public class QueueReceiver {

    /**
     * tcp 地址
     */
    public static final String BROKER_URL = "tcp://localhost:61616";

    /**
     * 目标，在ActiveMQ管理员控制台创建 http://localhost:8161/admin/queues.jsp
     */
    public static final String TARGET = "hoo.mq.queue";

    /**
     * 入口函数
     */
    public static void main(String[] args) throws Exception {
        try {
            QueueReceiver.run();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void run() throws Exception {
        QueueConnectionFactory queueConnectionFactory = null;
        QueueConnection queueConnection = null;
        QueueSession queueSession = null;
        Queue queue = null;
        javax.jms.QueueReceiver queueReceiver = null;
        try {
            // 创建链接工厂
            queueConnectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD, BROKER_URL);
            // 通过工厂创建一个连接
            queueConnection = queueConnectionFactory.createQueueConnection();
            // 启动连接
            queueConnection.start();
            // 创建一个session会话
            queueSession = queueConnection.createQueueSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            // 创建一个消息队列
            queue = queueSession.createQueue(TARGET);
            // 创建消息制作者
            queueReceiver = queueSession.createReceiver(queue);

            queueReceiver.setMessageListener(new MessageListener() {
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
            // 休眠10s再关闭
            Thread.sleep(1000 * 10);
            // 提交会话
            queueSession.commit();
        } catch (Exception e) {
            throw e;
        } finally {
            // 关闭释放资源
            if (queueSession != null) {
                queueSession.close();
            }
            if (queueConnection != null) {
                queueConnection.close();
            }
        }
    }
}
