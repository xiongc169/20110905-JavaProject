package org.practice.activemq2.JMS;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 使用JMS方式发送接收消息
 * 
 * @author chaoxiong
 * @version 2015-08-28 09:55:26
 * 
 *          http://blog.csdn.net/jwdstef/article/details/17380471
 */
public class MessageSender {

	public static final int SEND_NUM = 5;
	// tcp 地址
	public static final String BROKER_URL = "tcp://localhost:61616";
	// 目标，在ActiveMQ管理员控制台创建 http://localhost:8161/admin/queues.jsp
	public static final String DESTINATION = "com.chaoxiong.activemq";

	/**
	 * 入口函数
	 */
	public static void main(String[] args) throws Exception {
		MessageSender.run();
	}

	public static void run() throws Exception {
		Connection conn = null;
		Session session = null;
		try {
			// 创建链接工厂
			ConnectionFactory connFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD, BROKER_URL);
			// 通过工厂创建一个连接
			conn = connFactory.createConnection();
			// 启动连接
			conn.start();
			// 创建一个session会话
			session = conn.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
			// 创建一个消息队列
			Destination destination = session.createQueue(DESTINATION);
			// 创建消息制作者
			MessageProducer producer = session.createProducer(destination);
			// 设置持久化模式
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			sendMessage(session, producer);
			// 提交会话
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// 关闭释放资源
			if (session != null) {
				session.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}

	public static void sendMessage(Session session, MessageProducer producer) throws Exception {
		for (int i = 0; i < SEND_NUM; i++) {
			String msg = String.format("This is %dth Message", i);
			TextMessage txtMsg = session.createTextMessage(msg);
			producer.send(txtMsg);
		}
	}
}
