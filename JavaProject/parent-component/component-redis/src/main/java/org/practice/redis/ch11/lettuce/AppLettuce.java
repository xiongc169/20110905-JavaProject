package org.practice.redis.ch11.lettuce;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;

import java.time.Duration;

public class AppLettuce {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            Duration duration = Duration.ofSeconds(10);
            RedisURI redisURI = new RedisURI("127.0.0.1", 6379, duration);
            RedisClient redisClient = RedisClient.create(redisURI);
            StatefulRedisConnection<String, String> connection = redisClient.connect();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
