package com.yoong.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.yoong.web.hibernate.entity.Account;

/**
 * @Desc PreConfig
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018年8月20日
 * <p>
 * @Version 1.0
 */
@Configuration
public class PreConfig {

    @Bean
    public Account accountBean() {
        System.out.println("PreConfig.getAccount Start");
        Account account = new Account();
        System.out.println("PreConfig.getAccount End");
        return account;
    }
}
