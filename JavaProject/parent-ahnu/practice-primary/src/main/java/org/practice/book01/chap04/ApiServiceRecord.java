package org.practice.book01.chap04;

import lombok.Data;

import java.util.Date;

/**
 * @Desc ApiServiceRecord
 * @Author
 * @Date
 * @Version 1.0
 */
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


    public ApiServiceRecord() {
        System.out.println("ApiServiceRecord.ApiServiceRecord()");
    }

    public ApiServiceRecord(String Id) {
        this.Id = Id;
    }

    {
        System.out.println("ApiServiceRecord code block");
    }

    static {
        System.out.println("ApiServiceRecord static code block");
    }
}
