package com.yoong.rocketmq.book02;

import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;

/**
 * @Desc 《分布式消息中间件实践·详解消息中间件的高可用、高性能配置和原理》倪炜 著
 * PS：2018年9月出版。
 * https://www.jb51.net/books/695812.html
 * https://www.xz577.com/e/1041.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2020-5-28
 * <p>
 * @Version 1.0
 */
public class AppRocketMQ {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            ConsumeConcurrentlyStatus status = ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            System.out.println("Hello World!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
