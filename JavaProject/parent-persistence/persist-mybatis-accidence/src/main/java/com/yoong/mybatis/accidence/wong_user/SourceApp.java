package com.yoong.mybatis.accidence.wong_user;

import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.Reflector;
import org.apache.ibatis.reflection.ReflectorFactory;

/**
 * @Desc 《MyBatis技术内幕》
 * <p>
 * @Author Administrator
 * <p>
 * @Date 2018/1/16 16:41
 * <p>
 * @Version 1.0
 */
public class SourceApp {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            reflect0202();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void reflect0202() throws Exception {
        //Class driverClazz = Class.forName("com.mysql.cj.jdbc.Driver");
        Class accountClazz = Class.forName("com.yoong.mybatis.accidence.wong_user.domain.Account");
        Reflector reflector = new Reflector(accountClazz);
        System.out.println(reflector);
        ReflectorFactory reflectorFactory = new DefaultReflectorFactory();

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
