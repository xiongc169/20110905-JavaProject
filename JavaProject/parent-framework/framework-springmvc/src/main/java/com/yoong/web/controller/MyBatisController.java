package com.yoong.web.controller;

import com.yoong.web.mybatis.model.Admin;
import com.yoong.web.mybatis.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Desc MyBatisController.java
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018年8月20日
 * <p>
 * @Version 1.0
 */
@Controller
@RequestMapping("/mybatis")
public class MyBatisController {

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private AdminService adminService;

    /**
     * http://127.0.0.1:8095/mybatis/getTime
     */
    @ResponseBody
    @RequestMapping("/getTime")
    public String getTime(HttpServletRequest request, HttpServletResponse response) {
        String msg = "MyBatisController.getTime() " + format.format(new Date());
        System.out.println(msg);
        return msg;
    }

    /**
     * http://localhost:8095/mybatis/saveAdmin
     */
    @ResponseBody
    @RequestMapping("/saveAdmin")
    public String saveAdmin() {
        Admin admin = new Admin();
        admin.setCreateTime(new Date());
        admin.setModifyTime(new Date());
        admin.setIsDelete(0);
        adminService.insertAdmin(admin);
        return format.format(new Date());
    }
}
