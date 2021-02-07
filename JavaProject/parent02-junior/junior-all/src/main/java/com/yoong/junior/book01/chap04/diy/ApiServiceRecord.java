package com.yoong.junior.book01.chap04.diy;

import lombok.Data;

import java.util.Date;

@Data
public class ApiServiceRecord extends ApiBaseRecord {
    private String Id;
    private String requestId;
    private String objectId;
    private String requestParam;
    private String thirdPartyId;
    private String businessType;
    private String responseTxt;
    private Date responseTime;
    private Date createTime;
    private Date modifyTime;

    static {
        System.out.println("子静态代码块");
    }

    {
        System.out.println("子代码块");
    }

    public ApiServiceRecord() {
        System.out.println("子构造函数");
    }

    public ApiServiceRecord(String Id) {
        this.Id = Id;
    }

    public static void output() {
        System.out.println("子.output");
    }
}
