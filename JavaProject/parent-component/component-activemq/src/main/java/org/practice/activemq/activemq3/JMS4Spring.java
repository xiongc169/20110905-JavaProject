package org.practice.activemq.activemq3;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.jms.*;

/**
 * @Desc ActiveMQ的简单使用
 * PS：https://blog.csdn.net/s296850101/article/details/52401405
 * <p>
 * @Author yoong
 * <p>
 * @Date 2016年7月21日 下午7:24:57
 * <p>
 * @Version 1.0
 */
public class JMS4Spring {

    private static String brokerURL = "tcp://127.0.0.1:61616";
    private static String userName = "admin";
    private static String password = "admin";
    private static String queueName = "second-queue";

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            ApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:jms4spring3.xml");

            // ConnectionFactory ：连接工厂，JMS 用它创建连接
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(userName, password, brokerURL);
            ConnectionFactory connectionFactory2 = (ConnectionFactory) appContext.getBean("activemqConnectionFactory");

            Connection connection = connectionFactory2.createConnection();
            // 启动
            connection.start();
            // 获取操作连接
            Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue(queueName);

            // 得到消息生成者【发送者】
            MessageProducer producer = session.createProducer(destination);
            // 设置不持久化，此处学习，实际根据项目决定
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            for (int i = 1; i <= 5; i++) {
                TextMessage message = session.createTextMessage("ActiveMq 发送的消息" + i);
                // 发送消息到目的地方
                System.out.println("发送消息：" + "ActiveMq 发送的消息" + i);
                producer.send(message);
            }
            session.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
