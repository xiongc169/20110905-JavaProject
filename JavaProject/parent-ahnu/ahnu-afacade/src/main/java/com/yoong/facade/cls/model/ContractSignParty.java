package com.yoong.facade.cls.model;

import lombok.Data;

/**
 * 合同签署方信息
 *
 * @author yoong
 */
@Data
public class ContractSignParty {

    /**
     * 签署方类型
     */
    private String userType;

    /**
     * 签署方身份证号
     */
    private String identityNo;

    /**
     * 签署方名称
     */
    private String userName;

    /**
     * 签署方手机号
     */
    private String mobileNo;

    /**
     * 签署位置
     */
    private String signLocation;
}
