package com.yoong.practice.kafka01;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Collections;
import java.util.Properties;

/**
 * @Desc KafkaConsumer
 * @Author
 * @Date 2019年7月23日14:29:42
 * @Version 1.0
 */
public class KafkaConsume {

    public static String topic = "test";

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            //消费消息
            KafkaConsume.consume();
            System.out.println("Consume End");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 消费消息
     */
    public static void consume() {
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.88.128:9092");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "test");

        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(properties);
        kafkaConsumer.subscribe(Collections.singletonList(topic));// 订阅消息

        try {
            for (int i = 0; i < 10; i++) {
                ConsumerRecords<String, String> records = kafkaConsumer.poll(100);
                for (ConsumerRecord<String, String> record : records) {
                    System.out.println(String.format("topic:%s, offset:%d, 消息:%s ", record.topic(), record.offset(), record.value()));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
