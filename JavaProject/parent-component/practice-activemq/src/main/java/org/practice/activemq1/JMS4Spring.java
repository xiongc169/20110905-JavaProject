package org.practice.activemq1;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Message;

/**
 * @author 20180112002
 * @desc JMS简介与ActiveMQ实战
 * PS：http://boy00fly.iteye.com/blog/1103586
 * @date 2018年7月25日
 */
public class JMS4Spring {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            ClassPathXmlApplicationContext clsContext = new ClassPathXmlApplicationContext(new String[]{"classpath:jms4spring1.xml"});
            clsContext.start();

            //生产者
            JmsTemplate template = (JmsTemplate) clsContext.getBean("myJmsTemplate");
            template.convertAndSend("Hello");

            //消费者
            Message msg = template.receive();
            System.out.println(msg);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
