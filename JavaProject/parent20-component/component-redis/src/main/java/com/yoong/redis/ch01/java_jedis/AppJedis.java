package com.yoong.redis.ch01.java_jedis;

/**
 * @Desc AppJedis
 * <p>
 * @Author yoong
 * <p>
 * @Date 2015-10-29 14:50:41
 * <p>
 * @Version 1.0
 */
public class AppJedis {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            RedisClient redisClient = new RedisClient();
            redisClient.jedisTest();
            redisClient.jedisPoolTest();
            redisClient.shardJedisTest();
            redisClient.shardJedisPoolTest();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
