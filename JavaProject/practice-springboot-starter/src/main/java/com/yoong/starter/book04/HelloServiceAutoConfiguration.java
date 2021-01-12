package com.yoong.starter.book04;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.yoong.starter.book04.chap1402")
public class HelloServiceAutoConfiguration {

    public HelloServiceAutoConfiguration() {
        System.out.println("HelloServiceAutoConfiguration()");
    }
}
