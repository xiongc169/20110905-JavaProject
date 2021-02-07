package com.yoong.redis.ch03.java_jedis;

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
public class AppJedis {

    /**
     * 入口函数
     */
    public static void main(String[] args) {

        try {
            RedisPoolClient client = new RedisPoolClient();
            client.KeyOperate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
