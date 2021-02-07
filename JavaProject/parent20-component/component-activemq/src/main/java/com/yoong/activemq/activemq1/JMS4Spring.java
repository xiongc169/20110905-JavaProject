package com.yoong.activemq.activemq1;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Message;

/**
 * @Desc JMS简介与ActiveMQ实战
 * PS：https://www.iteye.com/blog/boy00fly-1103586
 * <p>
 * @Author 20180112002
 * <p>
 * @Date 2018年7月25日
 * <p>
 * @Version 1.0
 */
public class JMS4Spring {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            jmsTemplateDemo();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void jmsTemplateDemo() {
        ClassPathXmlApplicationContext clsContext = new ClassPathXmlApplicationContext(new String[]{"classpath:jms4spring1.xml"});

        //生产者，spring-jms封装类JmsTemplate
        JmsTemplate template = (JmsTemplate) clsContext.getBean("myJmsTemplate");
        template.convertAndSend("Hello");

        //消费者，spring-jms封装类JmsTemplate
        Message msg = template.receive();
        System.out.println(msg);
    }
}
