package org.practice.jedis.utility;

/**
 * @author chaoxiong
 * @desc App
 * @since 2015-10-29 14:50:41
 */
public class App {

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
