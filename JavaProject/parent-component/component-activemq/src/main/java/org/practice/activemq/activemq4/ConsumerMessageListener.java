package org.practice.activemq.activemq4;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class ConsumerMessageListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            TextMessage textMsg = (TextMessage) message;
            System.out.println("ConsumerMessageListener 接收到一个纯文本消息。");
            System.out.println("消息内容是：" + textMsg.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
