package com.yoong.springboot.config.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;

@Component
public class MyJmsListener {

    @JmsListener(containerFactory = "jmsListenerContainerFactory", destination = "yoong-2034")
    public void onMessage(Message message) {
        System.out.println("MyJmsListener: " + message.getClass());
    }
}
