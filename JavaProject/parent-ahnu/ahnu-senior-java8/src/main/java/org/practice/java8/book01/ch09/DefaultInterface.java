package org.practice.java8.book01.ch09;

/**
 * @Desc 《Java 8实战.pdf》
 * 第九章、默认方法
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018-03-02 09:00:00
 * <p>
 * @Version 1.0
 */
@FunctionalInterface
public interface DefaultInterface {

    default String getName() {
        return this.getName();
    }

    default Class getClazz() {
        return this.getClass();
    }

    String convert(String input);
}
