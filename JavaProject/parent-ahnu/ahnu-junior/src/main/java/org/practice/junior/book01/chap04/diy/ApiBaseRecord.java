package org.practice.junior.book01.chap04.diy;

import lombok.Data;

@Data
public class ApiBaseRecord {
    private String Id;
    private String requestId;

    static {
        System.out.println("父静态代码块");
    }

    {
        System.out.println("父代码块");
    }

    public ApiBaseRecord() {
        System.out.println("父构造函数");
    }

    public ApiBaseRecord(String Id) {
        this.Id = Id;
    }

    public static void output() {
        System.out.println("父.output");
    }
}
