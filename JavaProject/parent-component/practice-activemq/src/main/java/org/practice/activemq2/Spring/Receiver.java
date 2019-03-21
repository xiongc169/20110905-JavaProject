package org.practice.activemq2.Spring;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

/**
 * @author yoong
 * <br/>
 * @desc 深入浅出消息队列 ActiveMQ
 *       PS：整合Spring实现消息发送和接收
 *       http://blog.csdn.net/jwdstef/article/details/17380471
 * <br/>
 * @date 2015-08-28 09:55:26
 */
public class Receiver {

    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext ctx = new FileSystemXmlApplicationContext("classpath:jms4spring2.xml");

        JmsTemplate jmsTemplate = (JmsTemplate) ctx.getBean("jmsTemplate");
        while (true) {
            Map<String, Object> map = (Map<String, Object>) jmsTemplate.receiveAndConvert();

            System.out.println("收到消息：" + map.get("message"));
        }
    }

}
