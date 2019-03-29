package org.practice.primary.generic;

import java.util.Date;

/**
 * @Desc GenericMethod
 * @Author
 * @Date
 * @Version 1.0
 */
public class TMethod {

    public <T> T getGenericResult(Class<T> tClass) {
        if (tClass == Date.class) {
            return (T) new Date();
        } else if (tClass == String.class) {
            return (T) "Hello";
        }
        return null;
    }
}
