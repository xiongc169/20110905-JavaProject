package org.practice.redis.ch01.java_jedis;

/**
 * @author chaoxiong
 * @desc App
 * @since 2015-10-29 14:50:41
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
