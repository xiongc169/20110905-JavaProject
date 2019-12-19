package com.yoong.facade.cls.model;

import lombok.Data;

@Data
public class QueryResponse {

    private String code;

    private String msg;

    private QueryData data;
}
