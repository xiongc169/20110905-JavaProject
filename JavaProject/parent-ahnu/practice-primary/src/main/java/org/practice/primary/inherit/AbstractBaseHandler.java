package org.practice.primary.inherit;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Desc AbstractBaseHandler
 * @Author
 * @Date 2019年3月28日20:32:17
 * @Version 1.0
 */
public abstract class AbstractBaseHandler<T, V> {

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 非抽象类中不能定义抽象方法
     */

    /**
     * 抽象类的抽象方法
     */
    abstract V handle(T t);

    /**
     * 抽象类的非抽象方法
     */
    public String getTime() {
        return format.format(new Date());
    }
}
