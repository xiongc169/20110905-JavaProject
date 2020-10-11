package com.yoong.rocketmq.book01.ch02;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * @Desc 2.3、发送\接收消息示例 (P13)
 * <p>
 * @Author yoong
 * <p>
 * @Date 2020-10-11
 * <p>
 * @Version 1.0
 */
public class SyncProducer {

    private static String namesrvAddr = "127.0.0.1:5432";

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            syncProduce();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void syncProduce() throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("ProducerGroup01");
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
        //同步发送消息
        SendResult sendResult = producer.send(message);
        producer.shutdown();
        System.out.println(sendResult);
    }
}
