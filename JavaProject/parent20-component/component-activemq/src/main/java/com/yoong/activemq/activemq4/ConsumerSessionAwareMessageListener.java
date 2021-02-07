package com.yoong.activemq.activemq4;

import org.springframework.jms.listener.SessionAwareMessageListener;

import javax.jms.*;

public class ConsumerSessionAwareMessageListener implements SessionAwareMessageListener {

    private Destination destination;

    @Override
    public void onMessage(Message message, Session session) throws JMSException {
        try {
            TextMessage textMsg = (TextMessage) message;
            System.out.println("ConsumerSessionAwareMessageListener 接收到一个纯文本消息。");
            System.out.println("消息内容是：" + textMsg.getText());

            MessageProducer producer = session.createProducer(destination);
            TextMessage textMessage = session.createTextMessage("Reply");
            producer.send(textMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
