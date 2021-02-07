package com.yoong.rocketmq.community01;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.util.List;

/**
 * @Desc java使用rocketMq
 * PS：RcoketMQ 是一款低延迟、高可靠、可伸缩、易于使用的消息中间件，号称消息中间件中的最强者，支持高并发，亿级的消息堆积能力，在高并发的电商，金融等业务场景中多有使用。
 * https://blog.csdn.net/zhangcongyi420/article/details/82593982
 * https://www.cnblogs.com/920913cheng/p/10730497.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2020-5-28
 * <p>
 * @Version 1.0
 */
public class App01 {

    private static String namesrvAddr = "127.0.0.1:5432";

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            producer();
            consumer();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 生产者
     */
    private static void producer() throws Exception {
        //需要一个producer group名字作为构造方法的参数，这里为producer1
        DefaultMQProducer producer = new DefaultMQProducer("producer1");

        //设置NameServer地址,此处应改为实际NameServer地址，多个地址之间用；分隔
        producer.setNamesrvAddr(namesrvAddr);
        producer.setVipChannelEnabled(false);

        //为避免程序启动的时候报错，添加此代码，可以让rocketMq自动创建topickey
        producer.setCreateTopicKey("AUTO_CREATE_TOPIC_KEY");
        producer.start();

        for (int i = 0; i < 10; i++) {
            try {
                //注意：发送前需要创建该Topic
                Message message = new Message("TopicTest", "Tag1", ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
                message.setKeys("key-" + i);
                SendResult sendResult = producer.send(message);
                String concat = String.format("发送的消息ID: %s, 发送状态: %s", sendResult.getMsgId(), sendResult.getSendStatus());
                System.out.println(concat);
            } catch (Exception e) {
                e.printStackTrace();
                Thread.sleep(1000);
            }
        }
        producer.shutdown();
    }

    /**
     * 消费者
     * RocketMQ的消息模式
     * https://www.cnblogs.com/Eternally-dream/p/9959397.html
     */
    private static void consumer() throws Exception {
        //设置消费者组
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("CID_LRW_DEV_SUBS");

        consumer.setVipChannelEnabled(false);
        consumer.setNamesrvAddr(namesrvAddr);
        //设置消费者端消息拉取策略，表示从哪里开始消费
        //consumer.setMessageModel(MessageModel.CLUSTERING);
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);

        //设置消费者拉取消息的策略，*表示消费该topic下的所有消息，也可以指定tag进行消息过滤
        consumer.subscribe("TopicTest", "*");

        //消费者端启动消息监听，一旦生产者发送消息被监听到，就打印消息，和rabbitmq中的handlerDelivery类似
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                for (MessageExt messageExt : msgs) {
                    String body = new String(messageExt.getBody());
                    String concat = String.format("MsgId: %s, Topic: %s, Tag: %s, Key: %s, Body: %s", messageExt.getMsgId(), messageExt.getTopic(), messageExt.getTags(), messageExt.getKeys(), body);
                    System.out.println(concat);
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        //调用start()方法启动consumer
        consumer.start();
        System.out.println("Consumer Started....");
        //consumer.shutdown();
    }
}
