package org.practice.book01.chap12;

/**
 * @Desc TClass
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

    public T doubleT(T t) {
        return t;
    }
}
