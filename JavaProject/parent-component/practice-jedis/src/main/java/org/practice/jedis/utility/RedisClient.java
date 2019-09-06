package org.practice.jedis.utility;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * @author chaoxiong
 * @desc 自定义Redis客户端
 * @since 2015-10-29 14:50:41
 */
public class RedisClient {
    /**
     *
     */
    private Jedis jedis;
    /**
     *
     */
    private JedisPool jedisPool;
    /**
     *
     */
    private ShardedJedis shardedJedis;
    /**
     *
     */
    private ShardedJedisPool shardedJedisPool;

    /**
     *
     */
    private void initialPool() {
        JedisPoolConfig config = new JedisPoolConfig();
        //config.setMaxActive(20);
        config.setMaxIdle(5);
        //config.setMaxWait(1000L);
        config.setTestOnBorrow(false);
        jedisPool = new JedisPool(config, "127.0.0.1", 6379);
    }

    /**
     *
     */
    public RedisClient() {
        initialPool();
        jedis = jedisPool.getResource();
    }

    public void KeyOperate() {
        System.out.println("----------------------------------------------------");
        String data = "{\"msgType\":1,\"spyid\":\"500002\",\"srid\":\"200002\",\"platformid\":3,\"recordTime\":\"20150717134523\"}";
        jedis.rpush("shwltest", data);
        System.out.println("----------------------------------------------------");
    }
}	
