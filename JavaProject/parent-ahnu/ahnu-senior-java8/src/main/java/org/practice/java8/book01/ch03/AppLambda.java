package org.practice.java8.book01.ch03;

import java.util.function.Consumer;
import java.util.function.Function;
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
            functionalApi0304();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Chap 3.4、使用函数式接口
     */
    public static void functionalApi0304() {
        Predicate predicate01 = (item) -> true;
        Predicate predicate02 = (item) -> {
            return true;
        };

        Consumer consumer01 = (item) -> {
            //System.out.println(item);
        };
        Consumer consumer02 = (item) -> {
            return;
        };

        Function function01 = (item) -> {
            return "function";
        };
        Function function02 = (item) -> "function02";

        Supplier supplier01 = () -> "aaa";
    }
}
