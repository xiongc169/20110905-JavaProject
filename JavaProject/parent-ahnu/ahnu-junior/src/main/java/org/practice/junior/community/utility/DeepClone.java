package org.practice.junior.community.utility;

import java.util.ArrayList;
import java.util.List;

import org.practice.junior.community.domain.Dictionary;

/**
 * @Desc Java中的深拷贝(深复制)和浅拷贝(浅复制)
 * <p>
 * @Author yoong
 * <p>
 * @Date 2015-08-30 09:06:00
 * <p>
 * @Version 1.0
 */
public class DeepClone {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            deepClone();
            hashCodeTest();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Java中对象的深复制、浅复制介绍
     * http://www.jb51.net/article/62909.htm
     * http://rogerfederer.iteye.com/blog/1748752
     */
    public static void deepClone() {
        List<Dictionary> dictList = new ArrayList<Dictionary>();
        Dictionary dict = new Dictionary("no001", "name001");
        Dictionary dict2 = new Dictionary("no002", "name002");
        dictList.add(dict);
        dictList.add(dict2);
        System.out.println(dict.getDictionaryNo() + dict.getName());

//        Dictionary dict3 = (Dictionary) dict.clone();
//        dict3.setDictionaryNo("no003");
//        dict3.setName("name003");
//        System.out.println(dict.getDictionaryNo() + dict.getName());
//        System.out.println(dict3.getDictionaryNo() + dict3.getName());

        List<Dictionary> dictList2 = new ArrayList<Dictionary>();
        for (Dictionary item : dictList) {
            Dictionary newitem = (Dictionary) item.clone();
            dictList2.add(newitem);
        }
        //深拷贝，修改不影响原始数据
        dictList2.get(0).setDictionaryNo("list2-no001");
        System.out.println(dict.getDictionaryNo() + dict.getName());
        //浅拷贝，修改影响原始数据
        List<Dictionary> dictList3 = dictList;
        dictList3.get(0).setDictionaryNo("list3-no001");
        System.out.println(dict.getDictionaryNo() + dict.getName());
    }

    /**
     * hashCode测试
     * java对象克隆以及深拷贝和浅拷贝
     * http://www.cnblogs.com/xuanxufeng/p/6558330.html
     */
    public static void hashCodeTest() {
        Dictionary dict = new Dictionary();
        int hashCode = dict.hashCode();
        System.out.println("hashCode " + hashCode);

        Dictionary dict2 = new Dictionary("12", "12");
        int hashCode2 = dict2.hashCode();
        System.out.println("hashCode2 " + hashCode2);

        Dictionary dict3 = new Dictionary("12", "12");
        int hashCode3 = dict3.hashCode();
        System.out.println("hashCode3 " + hashCode3);

        Dictionary dict4 = dict3;
        int hashCode4 = dict4.hashCode();//等于hashCode3
        System.out.println("hashCode4 " + hashCode4);

        Dictionary dict5 = (Dictionary) dict3.clone();
        int hashCode5 = dict5.hashCode();//不等于hashCode3
        System.out.println("hashCode5 " + hashCode5);
    }
}
