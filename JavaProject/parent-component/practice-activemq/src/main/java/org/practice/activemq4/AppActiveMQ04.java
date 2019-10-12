package org.practice.activemq4;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Message;

/**
 * @author chaoxiong
 * <br/>
 * ActiveMQ的简单使用
 * https://www.iteye.com/blog/elim-1893038
 * <br/>
 * @date 2016年7月21日 下午7:24:57
 */
public class AppActiveMQ04 {

    private static String brokerURL = "tcp://127.0.0.1:61616";
    private static String userName = "admin";
    private static String password = "admin";
    private static String queueName = "second-queue";

    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            ApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:jms4spring4.xml");
            JmsTemplate jmsTemplate = (JmsTemplate) appContext.getBean("jmsTemplate");
            ActiveMQQueue queue = (ActiveMQQueue) appContext.getBean("queue");
            ActiveMQTopic topic = (ActiveMQTopic) appContext.getBean("topic");
            jmsTemplate.convertAndSend(queue, "2019年10月11日15:28:21");
            jmsTemplate.convertAndSend(topic, "2019年10月11日15:28:21");

            Message msg = jmsTemplate.receive("20130402");
            System.out.println(msg);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
