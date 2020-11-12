package com.yoong.springboot.controller;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Desc JmsController
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018年9月20日
 * <p>
 * @Version 1.0
 */
@Controller
@RequestMapping("/jms")
public class JmsController {

    private SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");

    private String destinationName = "yoong-05262034";

    /**
     * 1、SpringBoot自动配置的JmsTemplate；
     * 2、手动配置的JmsTemplate，见JmsConfig；
     */
    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    /**
     * http://localhost:8085/jms/send
     * PS：MyMessageListener\MyJmsListener轮流处理消息
     */
    @ResponseBody
    @RequestMapping("/send")
    public void send(String name) {
        try {
            jmsTemplate.send(destinationName, new MessageCreator() {
                @Override
                public Message createMessage(Session session) throws JMSException {
                    String msg = sdFormat.format(new Date()) + " TextMessage";
                    TextMessage textMessage = session.createTextMessage(msg);
                    return textMessage;
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("send");
    }

    /**
     * http://localhost:8085/jms/sendMessaging
     * PS：MyMessageListener\MyJmsListener轮流处理消息
     */
    @ResponseBody
    @RequestMapping("/sendMessaging")
    public void sendMessaging(String name) {
        try {
            ActiveMQTextMessage textMessage = new ActiveMQTextMessage();
            textMessage.setText(sdFormat.format(new Date()) + " TextMessage");
            jmsMessagingTemplate.convertAndSend(destinationName, textMessage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("sendMessaging");
    }
}
