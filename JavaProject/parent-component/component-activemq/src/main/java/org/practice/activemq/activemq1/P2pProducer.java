package org.practice.activemq.activemq1;

import org.apache.activemq.*;
import org.apache.activemq.command.*;

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
public class P2pProducer {

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

            //JMS核心类、ActiveMQ核心类
            jms2ActiveMQ();

            //Queue/Topic 生产者
            producerP2P(isTopic, isPersistent);
            System.out.println("producerP2P ending");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * jms、spring-jms、activeMQ核心类
     */
    private static void jms2ActiveMQ() throws Exception {
        //JMS接口 - 连接
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:616161");
        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession();
        //JMS接口 - 目的地、生产者、消费者
        Destination dest = session.createQueue("");
        Queue queue = session.createQueue("");
        Topic topic = session.createTopic("");
        MessageProducer messageProducer = session.createProducer(queue);
        MessageConsumer messageConsumer = session.createConsumer(queue);
        TopicSubscriber topicSubscriber = session.createDurableSubscriber(topic, "");
        //JMS接口 - 消息类型
        StreamMessage streamMessage = new ActiveMQStreamMessage();
        MapMessage mapMessage = new ActiveMQMapMessage();
        TextMessage textMessage = new ActiveMQTextMessage();
        ObjectMessage objectMessage = new ActiveMQObjectMessage();
        BytesMessage bytesMessage = new ActiveMQBytesMessage();

        //ActiveMQ接口 - 连接
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:616161");
        ActiveMQConnection activeMQConnection = null;
        ActiveMQSession activeMQSession = null;
        //ActiveMQ接口 - 目的地、生产者、消费者
        ActiveMQDestination activeMQDestination = null;
        ActiveMQQueue activeMQQueue = null;
        ActiveMQTopic activeMQTopic = null;
        ActiveMQMessageProducer activeMQMessageProducer = null;
        ActiveMQMessageConsumer activeMQMessageConsumer = null;
        //ActiveMQ接口 - 消息类型
        ActiveMQStreamMessage activeMQStreamMessage = new ActiveMQStreamMessage();
        ActiveMQMapMessage activeMQMapMessage = new ActiveMQMapMessage();
        ActiveMQTextMessage activeMQTextMessage = new ActiveMQTextMessage();
        ActiveMQObjectMessage activeMQObjectMessage = new ActiveMQObjectMessage();
        ActiveMQBytesMessage activeMQBytesMessage = new ActiveMQBytesMessage();

        //JMS接口 - 发布者、订阅者
        TopicPublisher topicPublisher = activeMQSession.createPublisher(activeMQTopic);
        TopicSubscriber topicSubscriber01 = activeMQSession.createSubscriber(activeMQTopic);
    }

    /**
     * Queue/Topic 生产者
     */
    public static void producerP2P(boolean isTopic, boolean isPersistent) throws Exception {
        //JMS接口 - 连接
        ConnectionFactory connectionFactory = null;
        Connection connection = null;
        Session session = null;
        //JMS接口 - 目的地、生产者、消费者
        Destination dest = null;
        MessageProducer messageProducer = null;
        //JMS接口 - 消息类型
        TextMessage textMessage = null;

        try {
            //connectionFactory = new ActiveMQConnectionFactory(userName, password, brokerUrl);//需认证
            connectionFactory = new ActiveMQConnectionFactory(brokerUrl);//免认证
            connection = connectionFactory.createConnection();
            connection.start();// ！！！！！

            /**在connection的基础上创建一个session，同时设置是否支持事务、ACKNOWLEDGE标识。
             • AUTO_ACKNOWLEDGE：自动确认模式。一旦接收方应用程序的方法调用从处理消息处返回，会话对象就会确认消息的接收。
             • CLIENT_ACKNOWLEDGE：客户端确认模式。会话对象依赖于应用程序对被接收的消息调用一个acknowledge()方法。一旦这个方法被调用，会话会确认最后一次确认之后所有接收到的消息。这种模式允许应用程序以一个调用来接收，处理并确认一批消息。注意：在管理控制台中，如果连接工厂的Acknowledge Policy（确认方针）属性被设置为"Previous"（提前），但是你希望为一个给定的会话确认所有接收到的消息，那么就用最后一条消息来调用acknowledge()方法。
             • DUPS_OK_ACKNOWLEDGE：允许副本的确认模式。一旦接收方应用程序的方法调用从处理消息处返回，会话对象就会确认消息的接收；而且允许重复确认。在需要考虑资源使用时，这种模式非常有效。注意：如果你的应用程序无法处理重复的消息的话，你应该避免使用这种模式。如果发送消息的初始化尝试失败，那么重复的消息可以被重新发送。
             • SESSION_TRANSACTED**/
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            if (isTopic) {
                dest = session.createTopic("topic-" + timeString);
            } else {
                dest = session.createQueue("queue-" + timeString);
            }
            messageProducer = session.createProducer(dest);//TODO: 控制台创建 目标地址(Destination)
            if (isPersistent) {
                messageProducer.setDeliveryMode(DeliveryMode.PERSISTENT);
            } else {
                messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            }
            textMessage = session.createTextMessage("2018年7月25日16:27:45");
            messageProducer.send(textMessage);
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            //不释放资源，应用程序不会停止
            if (session != null) {
                session.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
