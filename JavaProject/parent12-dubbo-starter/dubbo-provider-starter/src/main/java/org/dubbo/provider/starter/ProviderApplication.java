package org.dubbo.provider.starter;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Desc ProviderApplication
 * <p>
 * @Author yoong
 * <p>
 * @Date 2021年6月30日
 * <p>
 * @Version 1.0
 */
@EnableDubboConfig
@DubboComponentScan("org.dubbo.provider.starter.service")
@SpringBootApplication
public class ProviderApplication {

    private static SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        System.out.println(sdFormat.format(new Date()) + " ProviderApplication Start...");
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(ProviderApplication.class, args);
        System.out.println(sdFormat.format(new Date()) + " ProviderApplication Finished");
    }
}
