package org.practice.book01.chap12;

import java.io.Serializable;
import java.util.List;

/**
 * @Desc App2
 * @Author
 * @Date
 * @Version 1.0
 */
public class App2 {
    /**
     * 入口函数
     *
     * @param args
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
