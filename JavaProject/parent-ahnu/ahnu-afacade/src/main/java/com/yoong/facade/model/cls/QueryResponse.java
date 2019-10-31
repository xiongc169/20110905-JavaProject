package com.yoong.facade.model.cls;

import lombok.Data;

@Data
public class QueryResponse {

    private String code;

    private String msg;

    private QueryData data;
}
