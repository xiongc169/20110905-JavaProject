package com.yoong.springboot.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class AuthConfig {

    @Value("${com.yoong.username}")
    private String userName;

    @Value("${com.yoong.username}")
    private String password;

}
