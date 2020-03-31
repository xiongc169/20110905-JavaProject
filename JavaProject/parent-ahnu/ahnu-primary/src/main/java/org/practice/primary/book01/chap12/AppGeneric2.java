package org.practice.primary.book01.chap12;

import org.practice.primary.book01.chap12.ttype.TMethod;

import java.io.Serializable;
import java.util.List;

/**
 * @Desc App2
 */
public class AppGeneric2 {
    /**
     * 入口函数
     */
    public static void main(String[] args) {
        TMethod tMethod = new TMethod();
        tMethod.getName2(new ComSerialize());
    }

    public static void getString(List<String> aa) {
    }

    public static void getString2(List<Integer> aa) {
    }

    static class ComSerialize implements Comparable, Serializable {

        @Override
        public int compareTo(Object o) {
            return 0;
        }
    }
}
