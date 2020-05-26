package com.yoong.springboot.listener;

import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;

@Component
public class MyMessageListener implements MessageListener {

    public void onMessage(Message message) {
        System.out.println("MyMessageListener: " +message.getClass());
    }
}
