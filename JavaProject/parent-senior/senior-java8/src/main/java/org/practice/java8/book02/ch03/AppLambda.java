package org.practice.java8.book02.ch03;

import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Desc 《Java 8实战.pdf》
 * 第三章、Lambda表达式
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018-03-02 09:00:00
 * <p>
 * @Version 1.0
 */
public class AppLambda {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            functionalApi();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void functionalApi() {
        Predicate predicate = (t) -> true;
        Supplier supplier = () -> "aaa";
    }
}
