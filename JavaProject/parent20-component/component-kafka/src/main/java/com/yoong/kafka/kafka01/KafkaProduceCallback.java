package com.yoong.kafka.kafka01;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

/**
 * @Desc KafkaProduceCallback
 * <p>
 * @Author yoong
 * <p>
 * @Date 2019年7月23日17:59:56
 * <p>
 * @Version 1.0
 */
public class KafkaProduceCallback implements Callback {

    @Override
    public void onCompletion(RecordMetadata recordMetadata, Exception e) {
        System.out.println("KafkaProduceCallback.onCompletion() ");
        System.out.println("KafkaProduceCallback.onCompletion() ");
        System.out.println("KafkaProduceCallback.onCompletion() ");
    }
}
