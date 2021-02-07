package com.yoong.kafka.kafka01;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * @Desc KafkaProducer
 * <p>
 * @Author yoong
 * <p>
 * @Date 2019年7月23日14:29:42
 * <p>
 * @Version 1.0
 */
public class KafkaProduce {

    public static String topic = "test";

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            //发送消息
            produce();
            System.out.println("Produce End");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 发送消息
     */
    public static void produce() {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.88.128:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(properties);

        try {
            KafkaProduceCallback callback = new KafkaProduceCallback();
            for (int i = 0; i < 10; i++) {
                String msg = "Hello, Kafka " + i;
                ProducerRecord<String, String> record = new ProducerRecord<>(topic, msg);
                //同步发送
                RecordMetadata data = kafkaProducer.send(record).get();
                //异步发送
                //kafkaProducer.send(record, callback);
                System.out.println("消息发送成功:" + msg);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            System.out.println("Close Producer");
            kafkaProducer.close();
            System.out.println("Close Producer Successfully");
        }
    }
}
