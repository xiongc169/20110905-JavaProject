package org.practice.book01.ch04.ch0404;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTextMessage;

import javax.jms.*;

/**
 * @Desc VmProducer
 * @Author
 * @Date
 * @Version 1.0
 */
public class VmProducer {
    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            vmProducer();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void vmProducer() throws Exception {
        Connection conn = null;
        Session session = null;
        try {
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("vm:broker:(tcp://127.0.0.1:7777)");
            conn = connectionFactory.createConnection();
            conn.start();
            session = conn.createSession(false, 1);
            Destination vmQueue = session.createQueue("vmQueue");
            MessageProducer producer = session.createProducer(vmQueue);
            ActiveMQTextMessage txtMsg = new ActiveMQTextMessage();
            txtMsg.setText("2019年9月20日16:08:38");
            producer.send(txtMsg);
            Integer input = System.in.read();
            System.out.println(input);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
}
