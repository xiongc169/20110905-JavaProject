package org.practice.redis.ch11.spring_template;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Desc Spring + redis
 * https://blog.csdn.net/qq_37598011/article/details/80903791
 * https://www.cnblogs.com/tankaixiong/p/3660075.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 20130401
 * <p>
 * @Version 1.0
 */
public class AppRedisTemplate {

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            springRedisDemo();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void springRedisDemo() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring4jedis.xml");
        //context.start();
        JedisComponent jedisComponent = (JedisComponent) context.getBean("jedisComponent");

        String sj = format.format(new Date());
        jedisComponent.stringRedisTemplateSet("sj", sj);
        String value = jedisComponent.stringRedisTemplateGet("sj");
        System.out.println(value);

        String sj2 = format.format(new Date());
        jedisComponent.redisTemplateSet("sj2", sj2);
        String value2 = jedisComponent.redisTemplateGet("sj2");
        System.out.println(value2);

        String sj3 = format.format(new Date());
        jedisComponent.redisTemplateSet2("sj3", sj3);
        Object value3 = jedisComponent.redisTemplateGet2("sj3");
        System.out.println(value3);
    }
}
