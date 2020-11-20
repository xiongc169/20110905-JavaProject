package org.dubbo.provider.anno.config;

//import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableDubbo(scanBasePackages = "org.anno.provider.serviceImpl")
@PropertySource("classpath:anno-provider.properties")
public class ProviderConfig {


}
