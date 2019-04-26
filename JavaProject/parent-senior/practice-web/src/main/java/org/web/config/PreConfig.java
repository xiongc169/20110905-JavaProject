package org.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.web.domain.Account;

/**
 * @Desc PreConfig
 * @Author
 * @Date
 * @Version 1.0
 */
@Configuration
public class PreConfig {

    @Bean
    public Account getAccount() {
        System.out.println("PreConfig.getAccount Start");
        Account account = new Account();
        System.out.println("PreConfig.getAccount End");
        return account;
    }
}
