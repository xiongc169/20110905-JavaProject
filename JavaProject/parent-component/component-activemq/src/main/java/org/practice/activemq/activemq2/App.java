package org.practice.activemq.activemq2;

import org.practice.activemq.activemq2.JMS.MessageReceiver;
import org.practice.activemq.activemq2.JMS.MessageSender;

/**
 * @Desc 深入浅出消息队列 ActiveMQ
 * PS：使用发布/订阅域方式发送接收消息
 * ConnectionFactory\Connection\Session\Destination\MessageProducer\MessageConsumer
 * QueueConnectionFactory\QueueConnection\QueueSession\Queue\QueueSender\QueueReceiver
 * TopicConnectionFactory\TopicConnection\TopicSession\Topic\TopicPublisher\TopicSubscriber
 * http://blog.csdn.net/jwdstef/article/details/17380471
 * <p>
 * @Author yoong
 * <p>
 * @Date 2015-08-28 09:55:26
 * <p>
 * @Version 1.0
 */
public class App {

    /**
     * 入口函数
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
