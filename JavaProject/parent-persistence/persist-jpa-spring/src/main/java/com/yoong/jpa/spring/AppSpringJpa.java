package com.yoong.jpa.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Desc AppSpringJpa
 * <p>
 * @Author yoong
 * <p>
 * @Date 2020-5-14 20:45:48
 * <p>
 * @Version 1.0
 */
@SpringBootApplication
public class AppSpringJpa {

    private static SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        System.out.println(sdFormat.format(new Date()) + " JpaSpringApplication Start...");
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(AppSpringJpa.class, args);
        System.out.println(sdFormat.format(new Date()) + " JpaSpringApplication Finished");
    }
}
