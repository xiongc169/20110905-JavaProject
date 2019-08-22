package org.anno.provider.config;

//import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Desc ProviderConfiguration
 * @Author
 * @Date
 * @Version 1.0
 */
@Configuration
@EnableDubbo(scanBasePackages = "org.anno.provider.serviceImpl")
@PropertySource("classpath:anno-provider.properties")
public class ProviderConfig {


}
