package com.yoong.rocketmq.book01.ch03;

import org.apache.rocketmq.client.consumer.DefaultMQPullConsumer;
import org.apache.rocketmq.common.message.MessageQueue;

import java.text.SimpleDateFormat;
import java.util.Set;

/**
 * @Desc 3.1.4、DefaultMQPullConsumer (P30)
 * <p>
 * @Author yoong
 * <p>
 * @Date 2020-10-11
 * <p>
 * @Version 1.0
 */
public class MyPullConsumer {

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
        DefaultMQPullConsumer pullConsumer = new DefaultMQPullConsumer("ConsumerGroup");
        pullConsumer.start();
        Set<MessageQueue> messageQueues = pullConsumer.fetchSubscribeMessageQueues(topic);
        for (MessageQueue item : messageQueues) {
            long offset = pullConsumer.fetchConsumeOffset(item, true);
        }
    }
}
