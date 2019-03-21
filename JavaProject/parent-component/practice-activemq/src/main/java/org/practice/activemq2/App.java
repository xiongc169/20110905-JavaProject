package org.practice.activemq2;

import org.practice.activemq2.JMS.MessageReceiver;
import org.practice.activemq2.JMS.MessageSender;

/**
 * @author yoong
 * <br/>
 * @desc 深入浅出消息队列 ActiveMQ
 *       PS：JMS Provider\JMS for Spring
 *       http://blog.csdn.net/jwdstef/article/details/17380471
 * <br/>
 * @date 2015-08-28 09:55:26
 */
public class App {

    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            MessageSender.run();
            MessageReceiver.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Hello World!");
    }
}
