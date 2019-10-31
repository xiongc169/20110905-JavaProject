package org.practice.primary.book01.chap12;

import java.io.Serializable;
import java.util.Date;

/**
 * @Desc TMethod
 * @Author
 * @Date
 * @Version 1.0
 */
public class TMethod {

    private Object data;

    public <T> T getInstance() {
        this.data = data;
        return (T) data;
    }

    public <T> void getName(T t) {
        this.data = data;
    }

    public <T extends Comparable & Serializable> void getName2(T data) {
        this.data = data;
    }

    public <T> T getGenericResult(Class<T> tClass) {
        if (tClass == Date.class) {
            return (T) new Date();
        } else if (tClass == String.class) {
            return (T) "Hello";
        }
        return null;
    }

}
