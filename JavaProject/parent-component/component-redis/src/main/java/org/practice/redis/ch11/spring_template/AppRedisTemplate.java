package org.practice.redis.ch11.spring_template;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Desc Spring + redis
 * https://www.cnblogs.com/tankaixiong/p/3660075.html
 * @Author
 * @Date
 * @Version 1.0
 */
public class AppRedisTemplate {

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring4jedis.xml");
            context.start();
            JedisComponent jedisComponent = (JedisComponent) context.getBean("jedisComponent");
            jedisComponent.setString("sj", format.format(new Date()));
            String value = jedisComponent.getString("sj");
            System.out.println(value);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
