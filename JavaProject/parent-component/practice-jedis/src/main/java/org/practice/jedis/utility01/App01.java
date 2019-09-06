package org.practice.jedis.utility01;

/**
 * Java中使用Jedis操作Redis<br>
 * http://www.cnblogs.com/liuling/p/2014-4-19-04.html
 */
public class App01 {

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

            testRedisPool();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void testRedisPool() {
        RedisPoolUtil.getJedis().set("newname", "中文测试");
        System.out.println(RedisPoolUtil.getJedis().get("newname"));
    }
}
