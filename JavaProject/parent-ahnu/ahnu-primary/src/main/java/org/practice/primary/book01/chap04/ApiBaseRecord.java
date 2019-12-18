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

    static {
        System.out.println("ApiBaseRecord static code block");
    }

    {
        System.out.println("ApiBaseRecord code block");
    }

    public ApiBaseRecord() {
        System.out.println("ApiBaseRecord.ApiBaseRecord()");
    }

    public ApiBaseRecord(String Id) {
        this.Id = Id;
    }

    public static void output() {
        System.out.println("ApiBaseRecord.output");
    }
}
