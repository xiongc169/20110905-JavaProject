package org.practice.primary.book01.chap04;

import lombok.Data;

/**
 * @Desc ApiBaseRecord
 * @Author
 * @Date
 * @Version 1.0
 */
@Data
public class ApiBaseRecord {

    private String Id;

    private String requestId;

    public ApiBaseRecord() {
        System.out.println("ApiBaseRecord.ApiBaseRecord()");
    }

    public ApiBaseRecord(String Id) {
        this.Id = Id;
    }

    {
        System.out.println("ApiBaseRecord code block");
    }

    static {
        System.out.println("ApiBaseRecord static code block");
    }

}
