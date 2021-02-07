package com.yoong.activemq.activemq2.Spring;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

/**
 * @Desc 深入浅出消息队列 ActiveMQ
 * PS：整合Spring实现消息发送和接收
 * http://blog.csdn.net/jwdstef/article/details/17380471
 * <p>
 * @Author yoong
 * <p>
 * @Date 2015-08-28 09:55:26
 * <p>
 * @Version 1.0
 */
public class Receiver {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            ApplicationContext ctx = new FileSystemXmlApplicationContext("classpath:jms4spring2.xml");
            JmsTemplate jmsTemplate = (JmsTemplate) ctx.getBean("jmsTemplate");
            while (true) {
                Map<String, Object> map = (Map<String, Object>) jmsTemplate.receiveAndConvert();
                System.out.println("收到消息：" + map.get("message"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
