package org.practice.junior.book01.chap14.book03.chap1001;

import java.util.HashSet;
import java.util.Set;

/**
 * @Desc 《Java并发编程：核心方法与框架-高洪岩》
 * PS：第十章、并发集合框架
 * https://www.jb51.net/books/524956.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2019/1/14 14:30:00
 * <p>
 * @Version 1.0
 */
public class AppConCollection {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            collection1001();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Set接口常用的实现类是HashSet，默认以无序的方式组织元素；LinkedHashSet类可以有序的组织元素；
     */
    private static void collection1001() {
        Set<String> linkedHashSet = new HashSet<>();
        //Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("1");
        linkedHashSet.add("3");
        linkedHashSet.add("1");
        linkedHashSet.add("4");
        linkedHashSet.add("5");
        linkedHashSet.add("7");
        linkedHashSet.add("8");
        linkedHashSet.add("6");
        linkedHashSet.add("0");
        //System.out.println(set.size());
        for (String item : linkedHashSet) {
            System.out.println(item);
        }
    }
}
