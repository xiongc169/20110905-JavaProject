package com.yoong.jpa.hibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Desc JpaHibernateApplication
 * <p>
 * @Author yoong
 * <p>
 * @Date 2020-5-14 20:45:48
 * <p>
 * @Version 1.0
 */
@SpringBootApplication
public class JpaHibernateApplication {

    private static SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        System.out.println(sdFormat.format(new Date()) + " JpaHibernateApplication Start...");
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(JpaHibernateApplication.class, args);
        System.out.println(sdFormat.format(new Date()) + " JpaHibernateApplication Finished");
    }
}
