package com.yoong.starter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Desc SpringBootStarterApp
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018年9月20日
 * <p>
 * @Version 1.0
 */
//@SpringBootApplication
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan(basePackages = "com.yoong.*")
//@Controller
//@EnableJms
public class SpringBootStarterApp {

    private static SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        System.out.println(sdFormat.format(new Date()) + " SpringBootStarterApp Start...");
        //ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(SpringBootStarterApp.class, args);
        System.out.println(sdFormat.format(new Date()) + " SpringBootStarterApp Finished");
    }
}
