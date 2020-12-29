package com.yoong.mybatis.api.source;

import org.apache.ibatis.jdbc.SQL;

public class Chap04 {

    public static void ognl040302() throws Exception {

        //OgnlUtils.
        String mysql = new SQL() {
            {
                SELECT("*");
                FROM("a");
                INNER_JOIN("b on a.id=b.id");
                WHERE("a.age>10");
            }
        }.toString();
    }

}
