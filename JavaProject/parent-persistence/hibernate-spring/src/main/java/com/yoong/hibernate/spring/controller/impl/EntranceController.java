package com.yoong.hibernate.spring.controller.impl;

import com.yoong.hibernate.spring.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManager;

/**
 * @Desc EntranceController
 * @Author
 * @Date
 * @Version 1.0
 */
@Controller
@RequestMapping("/entrance")
public class EntranceController {

    @Autowired
    private AccountDao accountDao;


    private EntityManager entityManager;

    /**
     * http://127.0.0.1:8095/entrance/enter
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/enter")
    public String enter() {
        accountDao.save();
        return "Enter";
    }
}
