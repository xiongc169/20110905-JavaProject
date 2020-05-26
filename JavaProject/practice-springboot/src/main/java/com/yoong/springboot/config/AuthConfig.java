package com.yoong.springboot.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Desc AuthConfig.java
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018年9月20日
 * <p>
 * @Version 1.0
 */
@Data
@Component
public class AuthConfig {

    @Value("${com.yoong.username}")
    private String userName;

    @Value("${com.yoong.username}")
    private String password;

}
