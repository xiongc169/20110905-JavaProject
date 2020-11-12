package org.practice.primary.book01.chap12.ch1202;

import java.util.HashMap;
import java.util.Map;

public class TClass<T, U, S> {

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
     */
    //public static T staticMethod() {
    //    T t = null;
    //    return t;
    //}
    public static <T> T staticMethod02() {
        T t = null;
        return t;
    }
}
