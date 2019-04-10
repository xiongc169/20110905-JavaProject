package org.practice.book01.chap12;

import java.util.HashMap;
import java.util.Map;

/**
 * @Desc 泛型类
 * @Author
 * @Date
 * @Version 1.0
 */
public class TClass<T> {

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 并不是泛型方法
     */
    public T doubleT(T t) {
        return t;
    }

    /**
     * 泛型方法
     */
    public <U, S> Map<U, S> convert(T t) {
        Map<U, S> map = new HashMap<>();
        return map;
    }

    /**
     * 静态方法无法访问类上定义的泛型
     *
     * @param <T>
     * @return
     */
    public static <T> T staticMethod() {
        T t = null;
        return t;
    }
}
