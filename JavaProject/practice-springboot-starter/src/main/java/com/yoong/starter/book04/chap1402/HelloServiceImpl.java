package com.yoong.starter.book04.chap1402;

import org.springframework.stereotype.Component;

@Component
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello() {
        return "Hello";
    }

}
