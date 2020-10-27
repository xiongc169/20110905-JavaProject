package org.practice.primary.book01.chap12.ch1202;

import java.util.List;

/**
 * @Desc 《Java核心技术·卷1》12.3、泛型方法
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018年8月20日
 * <p>
 * @Version 1.0
 */
public class ArrayAlg {

    /**
     * 12.4、类型变量的限定 —— extends
     */
    public static <T extends Comparable> T getMiddle(List<T> list) {
        int middle = (0 + list.size()) / 2;
        T t = list.get(middle);
        return t;
    }

}
