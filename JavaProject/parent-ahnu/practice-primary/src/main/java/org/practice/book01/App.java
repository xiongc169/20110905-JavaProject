package org.practice.book01;

import org.practice.book01.chap04.ApiServiceRecord;

/**
 * 《Java核心技术·卷1》
 */
public class App {

    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            int x = 100;
            System.out.println(x);
            doublee(x);
            System.out.println(x);

            ApiServiceRecord record = new ApiServiceRecord();
            record.setBusinessType("BBBBBBBBBBBBBBBBBBBBB");
            System.out.println(record.getBusinessType());
            reference(record);
            System.out.println(record.getBusinessType());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void doublee(int x) {
        x = x * 2;
    }

    private static void reference(ApiServiceRecord record) {
        record.setBusinessType("AAAAAAAAAAAAAAAAAA");
    }
}
