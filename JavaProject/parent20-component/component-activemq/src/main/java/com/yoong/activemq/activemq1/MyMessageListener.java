package com.yoong.activemq.activemq1;

import javax.jms.*;
import java.text.SimpleDateFormat;

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
public class MyMessageListener implements MessageListener {

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");

    @Override
    public void onMessage(Message message) {
        try {
            TextMessage txtMsg = (TextMessage) message;
            System.out.println("MyMessageListener接收：" + txtMsg.getText());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
