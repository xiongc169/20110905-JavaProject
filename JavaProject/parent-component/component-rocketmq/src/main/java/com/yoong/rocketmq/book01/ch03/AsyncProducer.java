package com.yoong.rocketmq.book01.ch03;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;

import java.util.List;

/**
 * @Desc 3.2、不同类型的生产者 (P34)
 * <p>
 * @Author yoong
 * <p>
 * @Date 2020-10-11
 * <p>
 * @Version 1.0
 */
public class AsyncProducer {

    private static String namesrvAddr = "127.0.0.1:5432";

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            asyncProduce0302();
            asyncProduce030203();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 3.2.1、异步发送消息 +  3.2.2、发送延迟消息
     */
    private static void asyncProduce0302() throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("ProducerGroup01");
        producer.setInstanceName("instance01");
        producer.setRetryTimesWhenSendFailed(3);
        producer.setNamesrvAddr(namesrvAddr);
        producer.start();
        //构造消息
        String topic = "TopicTest";
        String tag = "tag01";
        String key = "key01";
        Integer flag = 0;
        String body = "This is a message";
        Boolean waitStoreMsgOK = true;
        Message message = new Message(topic, tag, key, flag, body.getBytes(), waitStoreMsgOK);
        //3.2.2、发送延迟消息
        message.setDelayTimeLevel(5);
        //异步发送消息
        producer.send(message, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println(sendResult);
            }

            @Override
            public void onException(Throwable e) {
                System.out.println(e);
            }
        });
        //producer.shutdown();
        System.out.println("sendResult");
    }

    /**
     * 3.2.3、自定义消息发送规则 + 6.1.2、部分顺序消息 (P65)
     * PS：MessageQueueSelector
     */
    private static void asyncProduce030203() throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("ProducerGroup01");
        producer.setInstanceName("instance01");
        producer.setRetryTimesWhenSendFailed(3);
        producer.setNamesrvAddr(namesrvAddr);
        producer.start();
        //构造消息
        String topic = "TopicTest";
        String tag = "tag01";
        String key = "key01";
        Integer flag = 0;
        String body = "This is a message";
        Boolean waitStoreMsgOK = true;
        Message message = new Message(topic, tag, key, flag, body.getBytes(), waitStoreMsgOK);
        //3.2.2、发送延迟消息
        message.setDelayTimeLevel(5);
        //异步发送消息
        Integer orderId = 1;
        producer.send(message, new MessageQueueSelector() {
            @Override
            public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
                for (MessageQueue queue : mqs) {
                    if (queue.getQueueId() == orderId.intValue()) {
                        return queue;
                    }
                }
                return null;
            }
        }, orderId);
        //producer.shutdown();
        System.out.println("sendResult");
    }
}
