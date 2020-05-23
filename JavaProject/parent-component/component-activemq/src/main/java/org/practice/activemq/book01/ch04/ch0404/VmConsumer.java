package org.practice.activemq.book01.ch04.ch0404;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTextMessage;

import javax.jms.*;

/**
 * @Desc VmConsumer
 * <p>
 * @Author yoong
 * <p>
 * @Date 2019/1/31 14:19
 * <p>
 * @Version 1.0
 */
public class VmConsumer {
    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            vmConsumer();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void vmConsumer() throws Exception {
        Connection conn = null;
        Session session = null;
        try {
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:7777");
            conn = connectionFactory.createConnection();
            conn.start();
            session = conn.createSession(false, 1);
            Destination vmQueue = session.createQueue("vmQueue");
            MessageConsumer consumer = session.createConsumer(vmQueue);
            ActiveMQTextMessage txtMsg = (ActiveMQTextMessage) consumer.receive(3000);
            String msg = txtMsg.getText();
            System.out.println(msg);
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
