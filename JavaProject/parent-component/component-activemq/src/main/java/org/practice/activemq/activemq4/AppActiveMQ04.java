package org.practice.activemq.activemq4;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * @Desc ActiveMQ的简单使用
 * PS：https://www.iteye.com/blog/elim-1893038
 * <p>
 * @Author chaoxiong
 * <p>
 * @Date 2016年7月21日 下午7:24:57
 * <p>
 * @Version 1.0
 */
public class AppActiveMQ04 {

    private static String brokerURL = "tcp://127.0.0.1:61616";
    private static String userName = "admin";
    private static String password = "admin";
    private static String queueName = "second-queue";

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            producer();
            consumer();
            convert();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void producer() {
        try {
            ApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:jms4spring4.xml");
            JmsTemplate jmsTemplate = (JmsTemplate) appContext.getBean("jmsTemplate");
            ActiveMQQueue queue = (ActiveMQQueue) appContext.getBean("queue");
            ActiveMQTopic topic = (ActiveMQTopic) appContext.getBean("topic");
            jmsTemplate.convertAndSend(queue, "2019年10月11日15:28:21");
            jmsTemplate.convertAndSend(topic, "2019年10月11日15:28:21");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void consumer() {
        try {
            ApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:jms4spring4.xml");
            JmsTemplate jmsTemplate = (JmsTemplate) appContext.getBean("jmsTemplate");
            Message msg = jmsTemplate.receive("20130402");
            System.out.println(msg);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void convert() {
        ConsumerMessageListenerAdapter adapter = new ConsumerMessageListenerAdapter();
        adapter.setMessageConverter(new MessageConverter() {
            @Override
            public Message toMessage(Object object, Session session) throws JMSException, MessageConversionException {
                return null;
            }

            @Override
            public Object fromMessage(Message message) throws JMSException, MessageConversionException {
                return null;
            }
        });
    }
}
