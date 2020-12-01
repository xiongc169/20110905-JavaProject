package org.dubbo.consumer.anno.config;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(value = {"org.dubbo.consumer.anno.controller"})
@PropertySource("classpath:anno-consumer.properties")
@EnableDubbo(scanBasePackages = "org.dubbo.consumer.anno.controller")
public class ConsumerConfig {
}
