package com.yoong.facade.cls.model;

import lombok.Data;

/**
 * @Desc QueryResponse
 * <p>
 * @Author yoong
 * <p>
 * @Date 2015-07-25 09:00:00
 * <p>
 * @Version 1.0
 */
@Data
public class QueryResponse {

    private String code;

    private String msg;

    private QueryData data;
}
