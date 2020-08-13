package org.practice.redis.ch02.java_jedis;

/**
 * @Desc Java中使用Jedis操作Redis
 * http://www.cnblogs.com/liuling/p/2014-4-19-04.html
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
            RedisClient rClient = new RedisClient();
            rClient.testString();
            rClient.testList();
            rClient.testSet();
            rClient.testMap();
            rClient.test();

            testRedisPool();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void testRedisPool() {
        RedisPoolClient.getJedis().set("newname", "中文测试");
        System.out.println(RedisPoolClient.getJedis().get("newname"));
    }
}
