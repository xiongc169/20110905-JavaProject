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
 * @author yoong
 * <br/>
 * @desc 深入浅出消息队列 ActiveMQ
 *       PS：使用点对点方式发送接收消息
 *       http://blog.csdn.net/jwdstef/article/details/17380471
 * <br/>
 * @date 2015-08-28 09:55:26
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
        QueueConnection connection = null;
        QueueSession session = null;
        try {
            // 创建链接工厂
            QueueConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD, BROKER_URL);
            // 通过工厂创建一个连接
            connection = factory.createQueueConnection();
            // 启动连接
            connection.start();
            // 创建一个session会话
            session = connection.createQueueSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            // 创建一个消息队列
            Queue queue = session.createQueue(TARGET);
            // 创建消息制作者
            javax.jms.QueueReceiver receiver = session.createReceiver(queue);

            receiver.setMessageListener(new MessageListener() {
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
            session.commit();
        } catch (Exception e) {
            throw e;
        } finally {
            // 关闭释放资源
            if (session != null) {
                session.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}