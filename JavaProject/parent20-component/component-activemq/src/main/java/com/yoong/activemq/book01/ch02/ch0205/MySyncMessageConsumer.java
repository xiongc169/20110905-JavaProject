package com.yoong.activemq.book01.ch02.ch0205;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 * @Desc MySyncMessageConsumer
 * <p>
 * @Author yoong
 * <p>
 * @Date 2019/1/31 14:19
 * <p>
 * @Version 1.0
 */
public class MySyncMessageConsumer {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            demo();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * chap2.5.1
     */
    private static void demo() throws Exception {
        ConnectionFactory connectionFactory;
        Connection connection = null;
        Session session = null;
        Destination destination;
        MessageConsumer consumer;
        Message message;
        boolean useTransaction = false;
        try {
            Context ctx = new InitialContext();
            connectionFactory = (ConnectionFactory) ctx.lookup("ConnectionFactoryName");
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(useTransaction,
                    Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue("TEST.QUEUE");
            consumer = session.createConsumer(destination);
            message = (TextMessage) consumer.receive(1000);
            System.out.println("Received message: " + message);
        } catch (JMSException jmsEx) {
        } finally {
            session.close();
            connection.close();
        }
    }
}
