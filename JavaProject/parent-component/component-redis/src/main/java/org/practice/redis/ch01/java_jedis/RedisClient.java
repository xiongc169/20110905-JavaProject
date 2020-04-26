package org.practice.redis.ch01.java_jedis;

import redis.clients.jedis.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chaoxiong
 * @desc 自定义Redis客户端
 * @since 2015-10-29 14:50:41
 */
public class RedisClient {

    private String host = "127.0.0.1";

    private Integer port = 6379;

    private String password = "admin";

    private Jedis jedis;
    private JedisPool jedisPool;
    private Jedis jedisFromPool;
    private ShardedJedis shardedJedis;
    private ShardedJedisPool shardedJedisPool;
    private ShardedJedis shardedJedisFromPool;

    public RedisClient() {
        jedis = new Jedis(host, port);

        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(10);
        jedisPool = new JedisPool(poolConfig, host, port);//new JedisPool(poolConfig, host, port, 1000, "admin");
        jedisFromPool = jedisPool.getResource();

        List<JedisShardInfo> shardInfos = new ArrayList<>();
        JedisShardInfo shard1 = new JedisShardInfo(host, port);
        //shard1.setPassword(password);
        JedisShardInfo shard2 = new JedisShardInfo(host);
        shardInfos.add(shard1);
        shardInfos.add(shard2);
        shardedJedis = new ShardedJedis(shardInfos);

        shardedJedisPool = new ShardedJedisPool(poolConfig, shardInfos);
        shardedJedisFromPool = shardedJedisPool.getResource();
    }

    public void jedisTest() {
        //String auth = jedis.auth(password);
        //System.out.println(auth);

        String result = jedis.set("str01", "string01");
        String str01 = jedis.get("str01");
        System.out.println(result + "  " + str01);

        Long length = jedis.lpush("list01", "item01", "item02", "item03", "item04");
        String item01 = jedis.lpop("list01");
        System.out.println(length + "  " + item01);

        Long effectRows = jedis.setnx("str01", "string01");
        System.out.println(effectRows);
        Long effectRows2 = jedis.setnx("str02", "string02");
        System.out.println(effectRows2);
    }

    public void jedisPoolTest() {
        //String auth = jedisFromPool.auth(password);
        //System.out.println(auth);

        String str01 = jedisFromPool.get("str01");
        System.out.println(str01);
    }

    public void shardJedisTest() {
        String str01 = shardedJedis.get("str01");
        System.out.println(str01);
    }

    public void shardJedisPoolTest() {
        String str01 = shardedJedisFromPool.get("str01");
        System.out.println(str01);
    }
}	
