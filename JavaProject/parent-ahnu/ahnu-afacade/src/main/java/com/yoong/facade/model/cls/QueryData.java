package com.yoong.facade.model.cls;

import lombok.Data;

/**
 * @author yoong
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
