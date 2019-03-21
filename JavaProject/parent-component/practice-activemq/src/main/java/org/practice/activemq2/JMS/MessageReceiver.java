package org.practice.activemq2.JMS;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * @author yoong
 * <br/>
 * @desc 深入浅出消息队列 ActiveMQ
 *       PS：使用JMS方式发送接收消息
 *       http://blog.csdn.net/jwdstef/article/details/17380471
 * <br/>
 * @date 2015-08-28 09:55:26
 */
public class MessageReceiver {

    public static final String BROKER_URL = "tcp://localhost:61616";

    public static final String DESTINATION = "com.chaoxiong.activemq";

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            MessageReceiver.run();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void run() throws Exception {
        Connection connection = null;
        Session session = null;
        try {
            // 创建链接工厂
            ConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD, BROKER_URL);
            // 通过工厂创建一个连接
            connection = factory.createConnection();
            // 启动连接
            connection.start();
            // 创建一个session会话
            session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            // 创建一个消息队列
            Destination destination = session.createQueue(DESTINATION);
            // 创建消息制作者
            MessageConsumer consumer = session.createConsumer(destination);

            while (true) {
                // 接收数据的时间（等待） 100 ms
                Message message = consumer.receive(1000);
                TextMessage text = (TextMessage) message;
                if (text != null) {
                    System.out.println("接收：" + text.getText());
                } else {
                    break;
                }
            }
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
