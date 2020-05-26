package com.yoong.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

@Controller
@RequestMapping("/jms")
public class JmsController {

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");

    @Autowired
    private JmsTemplate jmsTemplate;

    /**
     * http://localhost:8085/jms/send
     */
    @ResponseBody
    @RequestMapping("/send")
    public String login(String name) {
        jmsTemplate.send("yoong-2034", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage("TextMessage");
                return textMessage;
            }
        });
        return "Success";
    }
}
