package org.practice.redis.ch11.lettuce;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisFuture;
import io.lettuce.core.RedisURI;
import io.lettuce.core.SetArgs;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.async.RedisAsyncCommands;
import io.lettuce.core.api.reactive.RedisReactiveCommands;
import io.lettuce.core.api.sync.RedisCommands;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * @Desc Redis高级客户端Lettuce详解
 * https://www.cnblogs.com/throwable/p/11601538.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2016-3-31 14:50:41
 * <p>
 * @Version 1.0
 */
public class AppLettuce {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            lettuceDemo();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void lettuceDemo() throws Exception {
        //【连接Redis】
        RedisURI uri01 = RedisURI.create("redis://localhost/");
        RedisURI uri02 = RedisURI.builder().withHost("localhost").withPort(6379).build();
        RedisURI uri03 = new RedisURI("localhost", 6379, 60, TimeUnit.SECONDS);

        Duration duration = Duration.ofSeconds(10);
        RedisURI redisURI = new RedisURI("127.0.0.1", 6379, duration);

        //【基本使用】Lettuce使用的时候依赖于四个主要组件：RedisURI、RedisClient(RedisClusterClient)、Connection、RedisCommands
        RedisClient redisClient = RedisClient.create(redisURI);
        StatefulRedisConnection<String, String> connection = redisClient.connect();

        //【API】Lettuce主要提供三种API：
        //同步(sync)：RedisCommands
        //异步(async)：RedisAsyncCommands
        //反应式(reactive)：RedisReactiveCommands
        RedisCommands<String, String> redisCommands = connection.sync();
        RedisAsyncCommands<String, String> redisAsyncCommands = connection.async();
        RedisReactiveCommands<String, String> redisReactiveCommands = connection.reactive();

        //【同步API】
        String syncPong = redisCommands.ping();
        System.out.println(syncPong);

        SetArgs setArgs = SetArgs.Builder.nx().ex(5);
        redisCommands.set("name", "chao");
        String syncName = redisCommands.get("name");
        System.out.println(syncName);

        //【异步API】
        RedisFuture asyncPongFuture = redisAsyncCommands.ping();
        Object asyncPong = asyncPongFuture.get();
        System.out.println(asyncPongFuture.isDone());
        System.out.println(asyncPong);

        SetArgs setArgs02 = SetArgs.Builder.nx().ex(5);
        redisAsyncCommands.set("name", "chao", setArgs02);
        RedisFuture name = redisAsyncCommands.get("name");
        System.out.println(name.get());

        //【反应式API】
        Mono reactivePingMono = redisReactiveCommands.ping();
        System.out.println(reactivePingMono.cache());

        connection.close();
    }
}
