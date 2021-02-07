package com.yoong.web.mybatis.service.impl;

import com.yoong.web.mybatis.mapper.AdminMapper;
import com.yoong.web.mybatis.model.Admin;
import com.yoong.web.mybatis.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Desc AdminServiceImpl.java
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018年8月20日
 * <p>
 * @Version 1.0
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin insertAdmin(Admin admin) {
        int effectRows = adminMapper.insert(admin);
        System.out.println("effectRows: " + effectRows + ", Id: " + admin.getId());

        admin.setId(null);
        int effectRows2 = adminMapper.insert(admin);
        System.out.println("effectRows2: " + effectRows2 + ", Id: " + admin.getId());
        return admin;
    }
}
