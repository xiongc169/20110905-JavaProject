package org.practice.thread3.chap1001;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author yoong
 * <br>
 * @desc CollectionUtility
 * <br>
 * @date 2019/1/14 14:33
 */
public class CollectionUtility {

    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            collection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Set接口常用的实现类是HashSet，默认以无序的方式组织元素；LinkedHashSet类可以有序的组织元素；
     */
    private static void collection() {
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
