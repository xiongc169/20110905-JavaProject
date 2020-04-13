package org.practice.redis.ch03.java_jedis;

/**
 * java对redis的基本操作
 * https://blog.csdn.net/gdfgdfk/article/details/49429671
 *
 * @author chaoxiong
 * @since 2015-10-29 14:50:41
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
