package org.practice.activemq.activemq2.Spring;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

/**
 * @author yoong
 * <br/>
 * @desc 深入浅出消息队列 ActiveMQ
 * PS：整合Spring实现消息发送和接收
 * http://blog.csdn.net/jwdstef/article/details/17380471
 * <br/>
 * @date 2015-08-28 09:55:26
 */
public class Sender {

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");

    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            ApplicationContext ctx = new FileSystemXmlApplicationContext("classpath:jms4spring2.xml");
            JmsTemplate jmsTemplate = (JmsTemplate) ctx.getBean("jmsTemplate");

            jmsTemplate.send(new MessageCreator() {
                public Message createMessage(Session session) throws JMSException {
                    MapMessage message = session.createMapMessage();
                    message.setString("message", "current system time: " + format.format(new Date()));
                    return message;
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
