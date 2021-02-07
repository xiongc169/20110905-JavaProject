package com.yoong.facade.cls.model;

import lombok.Data;

/**
 * @Desc RegisterData
 * <p>
 * @Author yoong
 * <p>
 * @Date 2015-07-25 09:00:00
 * <p>
 * @Version 1.0
 */
@Data
public class RegisterData {

    /**
     * 项目主键
     */
    private Integer coCompanyId;

    /**
     * 用户id
     */
    private Long customerId;

    /**
     * 注册编号 (在基金公司注册 产生的注册编号)
     */
    private String registerNo;

    /**
     * 基金公司返回url
     */
    private String linkUrl;

    /**
     * 认证状态，0: 未认证 1:已认证 (基金公司返回状态 中间件转译成这2个)
     */
    private Integer registerStatus;

    /**
     * 注册手机号码
     */
    private String registerMobile;

    /**
     * 身份证号
     */
    private String globalId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 银行预留手机号码
     */
    private String reservedMobile;

    /**
     * 银行卡开户名
     */
    private String bankAccountName;

    /**
     * 银行卡号
     */
    private String bankAccountNo;

    /**
     * 银行名称
     */
    private String bankName;

    /**
     * 银行编号
     */
    private String bankNo;
}
