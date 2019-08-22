package org.anno.consumer.config;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Desc ConsumerConfig
 * @Author
 * @Date
 * @Version 1.0
 */
@Configuration
@ComponentScan(value = {"org.anno.consumer.controller"})
@PropertySource("classpath:anno-consumer.properties")
@EnableDubbo(scanBasePackages = "org.anno.consumer.controller")
public class ConsumerConfig {
}
