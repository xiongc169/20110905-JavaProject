package com.yoong.facade.cls.model;

import lombok.Data;

/**
 * @Desc QueryData
 * <p>
 * @Author yoong
 * <p>
 * @Date 2015-07-25 09:00:00
 * <p>
 * @Version 1.0
 */
@Data
public class QueryData {

    /**
     *
     */
    private String registerNo;

    /**
     * 用户注册状态，1 已注册，0 未注册，0 包含未注册，处理中，失败等情况
     */
    private String registerStatus;
}
