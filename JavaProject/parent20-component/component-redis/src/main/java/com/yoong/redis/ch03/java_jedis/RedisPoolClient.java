package com.yoong.redis.ch03.java_jedis;

import redis.clients.jedis.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @Desc java对redis的基本操作
 * https://blog.csdn.net/gdfgdfk/article/details/49429671
 * <p>
 * @Author yoong
 * <p>
 * @Date 2015-10-29 14:50:41
 * <p>
 * @Version 1.0
 */
public class RedisPoolClient {
    /**
     * 非切片客户端连接
     */
    private Jedis jedis;
    /**
     * 非切片连接池
     */
    private JedisPool jedisPool;
    /**
     * 切片客户端连接
     */
    private ShardedJedis shardedJedis;
    /**
     * 切片连接池
     */
    private ShardedJedisPool shardedJedisPool;

    /**
     *
     */
    public RedisPoolClient() {
        initialPool();
        initialShardedPool();
        jedis = jedisPool.getResource();
        shardedJedis = shardedJedisPool.getResource();
    }

    /**
     * 初始化非切片池
     */
    private void initialPool() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        //poolConfig.setMaxActive(20);
        poolConfig.setMaxIdle(5);
        //poolConfig.setMaxWait(1000L);
        poolConfig.setTestOnBorrow(false);
        jedisPool = new JedisPool(poolConfig, "127.0.0.1", 6379, 1000, "123456");
    }

    /**
     * 初始化切片池
     */
    private void initialShardedPool() {
        // 池基本配置
        JedisPoolConfig config = new JedisPoolConfig();
        //config.setMaxActive(20);
        config.setMaxIdle(5);
        //config.setMaxWait(1000l);
        config.setTestOnBorrow(false);
        // slave链接
        JedisShardInfo shareInfo1 = new JedisShardInfo("127.0.0.1", 6379, "master");
        shareInfo1.setPassword("123456");
        List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
        shards.add(shareInfo1);
        // 构造池
        shardedJedisPool = new ShardedJedisPool(config, shards);
    }

    public void KeyOperate() {
        System.out.println("======================key==========================");
        // 清空数据
        // System.out.println("清空库中所有数据：" + jedis.flushDB());
        // 判断key否存在
        System.out.println("判断key999键是否存在：" + shardedJedis.exists("name"));
        System.out.println("新增key001,value001键值对：" + shardedJedis.set("name", "value001"));
        System.out.println("判断key001是否存在：" + shardedJedis.exists("name"));
        // 输出系统中所有的key
        System.out.println("新增key002,value002键值对：" + shardedJedis.set("name2", "value002"));
        System.out.println("系统中所有键如下：");
        Set<String> keys = jedis.keys("*");
        Iterator<String> it = keys.iterator();
        while (it.hasNext()) {
            String key = it.next();
            System.out.println(key);
        }
        // 删除某个key,若key不存在，则忽略该命令。
        System.out.println("系统中删除key002: " + jedis.del("key002"));
        System.out.println("判断key002是否存在：" + shardedJedis.exists("key002"));
        // 设置 key001的过期时间
        System.out.println("设置 key001的过期时间为5秒:" + jedis.expire("key001", 5));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        // 查看某个key的剩余生存时间,单位【秒】.永久生存或者不存在的都返回-1
        System.out.println("查看key001的剩余生存时间：" + jedis.ttl("key001"));
        // 移除某个key的生存时间
        System.out.println("移除key001的生存时间：" + jedis.persist("key001"));
        System.out.println("查看key001的剩余生存时间：" + jedis.ttl("key001"));
        // 查看key所储存的值的类型
        System.out.println("查看key所储存的值的类型：" + jedis.type("key001"));
        /*
         * 一些其他方法：1、修改键名：jedis.rename("key6", "key0");
         * 2、将当前db的key移动到给定的db当中：jedis.move("foo", 1)
         */
    }

    public void StringOperate() {
    }

    public void ListOperate() {
    }

    public void SetOperate() {
    }

    public void SortedSetOperate() {
    }

    public void HashOperate() {
    }

    public void dispose() {
        //jedisPool.returnResource(jedis);
        //shardedJedisPool.returnResource(shardedJedis);
    }
}
