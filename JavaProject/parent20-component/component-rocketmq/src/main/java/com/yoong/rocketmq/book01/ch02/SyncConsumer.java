package com.yoong.rocketmq.book01.ch02;

import org.apache.rocketmq.client.consumer.DefaultMQPullConsumer;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Desc 2.3、发送\接收消息示例 (P13)
 * <p>
 * @Author yoong
 * <p>
 * @Date 2020-10-11
 * <p>
 * @Version 1.0
 */
public class SyncConsumer {

    private static SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");

    private static String namesrvAddr = "127.0.0.1:5432";

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            consume();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void consume() throws Exception {
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
        pushConsumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                String batchNo = sdFormat.format(new Date());
                for (MessageExt item : msgs) {
                    String concat = String.format("Time: %s, msgId: %s, body: %s", batchNo, item.getMsgId(), new String(item.getBody()));
                    System.out.println(concat);
                    //System.out.println(msgs);
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        pushConsumer.start();
        System.out.println("Consumer启动完成~");
    }
}
