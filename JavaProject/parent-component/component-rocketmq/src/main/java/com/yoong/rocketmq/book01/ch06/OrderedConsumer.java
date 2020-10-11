package com.yoong.rocketmq.book01.ch06;

import org.apache.rocketmq.client.consumer.DefaultMQPullConsumer;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @Desc 6.1、顺序消息 (P65)
 * <p>
 * @Author yoong
 * <p>
 * @Date 2020-10-11
 * <p>
 * @Version 1.0
 */
public class OrderedConsumer {

    private static SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");

    private static String namesrvAddr = "127.0.0.1:5432";

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            orderedConsume();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 6.1.2、部分顺序消息 (P65)
     * PS：MessageListenerOrderly
     */
    private static void orderedConsume() throws Exception {
        String topic = "TopicTest";
        String tag = "*";
        //consumerGroup 需要和消息模式(MessageModel)配合使用：Clustering模式下，同一consumerGroup种的每个Consumer只消费锁订阅消息的一部分内容
        DefaultMQPullConsumer pullConsumer = new DefaultMQPullConsumer("ConsumerGroup");
        DefaultMQPushConsumer pushConsumer = new DefaultMQPushConsumer("ConsumerGroup01");
        pushConsumer.setNamesrvAddr(namesrvAddr);
        pushConsumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        //RocketMQ支持两种消息模式：Clustering、Broadcasting。
        pushConsumer.setMessageModel(MessageModel.CLUSTERING);
        pushConsumer.subscribe(topic, tag);
        pushConsumer.registerMessageListener(new MessageListenerOrderly() {
            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs, ConsumeOrderlyContext context) {
                return null;
            }
        });
        pushConsumer.start();
        System.out.println("Consumer启动完成~");
    }
}
