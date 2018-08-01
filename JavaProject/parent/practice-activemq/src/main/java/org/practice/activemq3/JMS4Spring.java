package org.practice.activemq3;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @description App.java <br>
 * 				ActiveMQ入门实例
 *              http://www.cnblogs.com/xwdreamer/archive/2012/02/21/2360818.html
 *              activeMQ连接池的配置
 *              https://blog.csdn.net/zhang89xiao/article/details/50947268
 *              ActiveMQ的简单使用
 *              https://blog.csdn.net/s296850101/article/details/52401405
 * 
 * @author chaoxiong
 * @date 2016年7月21日 下午7:24:57
 */
public class JMS4Spring {

	private static String brokerURL = "tcp://127.0.0.1:61616";
	private static String userName = "admin";
	private static String password = "admin";
	private static String queueName = "second-queue";

	/**
	 * @description TODO
	 * @param args
	 * @return void
	 * @author chaoxiong
	 * @date 2016年7月21日 下午7:24:57
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
