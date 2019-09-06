package org.practice.jedis.utility02;

/**
 * java对redis的基本操作
 * https://blog.csdn.net/gdfgdfk/article/details/49429671
 *
 * @author chaoxiong
 * @since 2015-10-29 14:50:41
 */
public class App02 {

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
