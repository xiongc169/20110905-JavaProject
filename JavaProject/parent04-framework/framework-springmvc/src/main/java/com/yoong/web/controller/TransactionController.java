package com.yoong.web.controller;

import com.yoong.web.mybatis.model.Admin;
import com.yoong.web.mybatis.model.Customer;
import com.yoong.web.mybatis.model.Menu;
import com.yoong.web.mybatis.service.AdminService;
import com.yoong.web.mybatis.service.CustomerService;
import com.yoong.web.mybatis.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @Desc 《精通Spring 4.x企业应用开发实战》陈雄华 林开雄 文建国 著  Chap 11.4
 * <p>
 * @Author yoong
 * <p>
 * @Date 2016-7-11
 * <p>
 * @Version 1.0
 */
@Controller
@RequestMapping("/tx")
public class TransactionController {

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Autowired
    private AdminService adminService;

    @Autowired
    @Qualifier("transactionProxyFactoryBean")
    private CustomerService customerService;

    @Autowired
    private MenuService menuService;

    /**
     * chap 11.4、编程式的事务管理
     * http://localhost:8095/tx/addAdmin
     */
    @ResponseBody
    @RequestMapping("/addAdmin")
    public void addAdmin() {
        Object object = transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    Admin admin = new Admin();
                    admin.setCreateTime(new Date());
                    admin.setModifyTime(new Date());
                    admin.setIsDelete(0);
                    adminService.insertAdmin(admin);
                    //double aa = 10 / 0;
                    System.out.println(admin.getId());
                } catch (Exception ex) {
                    transactionStatus.setRollbackOnly();
                }
            }
        });
        System.out.println(object);
    }

    /**
     * chap 11.5.2、使用XML 配置 声明式事务 —— 使用原始的TransactionProxyFactoryBean
     * http://localhost:8095/tx/addCustomer
     */
    @ResponseBody
    @RequestMapping("/addCustomer")
    public void addCustomer() {
        Customer customer = new Customer();
        customer.setCreateTime(new Date());
        customer.setModifyTime(new Date());
        customer.setIsDelete(0);
        customerService.insertCustomer(customer);
        System.out.println(customer.getId());
    }

    /**
     * chap 11.5.3、使用XML 配置 声明式事务 —— 基于aop/tx命名空间的配置
     * http://localhost:8095/tx/addMenu
     */
    @ResponseBody
    @RequestMapping("/addMenu")
    public void addMenu() {
        Menu menu = new Menu();
        menu.setCreateTime(new Date());
        menu.setModifyTime(new Date());
        menu.setIsDelete(0);
        menuService.insertMenu(menu);
        System.out.println(menu.getId());
    }
}
