package com.yoong.springfx.book01.service;

import com.yoong.springfx.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Desc UserServiceImpl
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018年8月20日
 * <p>
 * @Version 1.0
 */
@Service
public class UserServiceImpl {

    @Autowired
    @Qualifier("user_01")
    private User user;

    @Resource
    @Qualifier("user_01")
    private User user2;

    public String getUserInfo() {
        System.out.println(user.getIid());
        System.out.println(user.getUserNo());
        System.out.println(user.getName());
        System.out.println(user.getOrgNo());
        System.out.println(user.getOrgName());
        return user.toString();
    }
}
