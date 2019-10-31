package org.practice.activemq.activemq1;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.text.SimpleDateFormat;

/**
 * @author yoong
 * <br/>
 * @desc http://boy00fly.iteye.com/blog/1103586
 * <br/>
 * @date 2018年7月25日
 */
public class P2PProducer {

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
            boolean isTopic = false;
            boolean isPersistent = false;

            //Queue/Topic 生产者
            producer4P2P(isTopic, isPersistent);
            System.out.println("producer4P2P ending");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Queue/Topic 生产者
     *
     * @param isTopic      消息的传输模型：PTP、Pub/Sub
     * @param isPersistent 是否持久化
     */
    public static void producer4P2P(boolean isTopic, boolean isPersistent) throws Exception {
        //String timeString = format.format(new Date());
        ActiveMQConnectionFactory connFactory = null;
        Connection conn = null;
        Session session = null;
        Destination dest = null;
        MessageProducer producer = null;
        TextMessage message = null;
        try {
            //connFactory = new ActiveMQConnectionFactory(userName, password, brokerUrl);//需认证
            connFactory = new ActiveMQConnectionFactory(brokerUrl);//免认证
            conn = connFactory.createConnection();
            conn.start();// ！！！！！
            /**在connection的基础上创建一个session，同时设置是否支持事务、ACKNOWLEDGE标识。
             • AUTO_ACKNOWLEDGE：自动确认模式。一旦接收方应用程序的方法调用从处理消息处返回，会话对象就会确认消息的接收。
             • CLIENT_ACKNOWLEDGE：客户端确认模式。会话对象依赖于应用程序对被接收的消息调用一个acknowledge()方法。一旦这个方法被调用，会话会确认最后一次确认之后所有接收到的消息。这种模式允许应用程序以一个调用来接收，处理并确认一批消息。注意：在管理控制台中，如果连接工厂的Acknowledge Policy（确认方针）属性被设置为"Previous"（提前），但是你希望为一个给定的会话确认所有接收到的消息，那么就用最后一条消息来调用acknowledge()方法。
             • DUPS_OK_ACKNOWLEDGE：允许副本的确认模式。一旦接收方应用程序的方法调用从处理消息处返回，会话对象就会确认消息的接收；而且允许重复确认。在需要考虑资源使用时，这种模式非常有效。注意：如果你的应用程序无法处理重复的消息的话，你应该避免使用这种模式。如果发送消息的初始化尝试失败，那么重复的消息可以被重新发送。
             • SESSION_TRANSACTED**/
            session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            if (isTopic) {
                dest = session.createTopic("topic-" + timeString);
            } else {
                dest = session.createQueue("queue-" + timeString);
            }
            producer = session.createProducer(dest);//TODO: 控制台创建 目标地址(Destination)
            if (isPersistent) {
                producer.setDeliveryMode(DeliveryMode.PERSISTENT);
            } else {
                producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            }
            message = session.createTextMessage("2018年7月25日16:27:45");
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
