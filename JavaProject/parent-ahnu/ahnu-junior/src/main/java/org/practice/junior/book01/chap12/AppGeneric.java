package org.practice.junior.book01.chap12;

import org.practice.junior.book01.chap12.ch1202.ArrayAlg;
import org.practice.junior.book01.chap12.ch1202.Pair;
import org.practice.junior.book01.chap12.ch1202.TMethod;
import org.practice.junior.book01.chap12.ch1205.DateInterval;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Desc 《Java核心技术·卷1》第十二章、泛型程序设计
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018年8月20日
 * <p>
 * @Version 1.0
 */
public class AppGeneric {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            generic1201();
            genericClass1202();
            extends1204();
            polymorphic1205();
            wildcard1208();
            reflect1209();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void generic1201() {
        List arrayList = new ArrayList();
        arrayList.add(1111);
        arrayList.add("1111");
        arrayList.add(new File(""));
    }

    public static void genericClass1202() {
        //12.2、泛型类
        Pair<String> pair = new Pair<>();
        //12.3、泛型方法
        List<String> stringList = Arrays.asList("1111", "2222", "3333", "4444");
        String middle = ArrayAlg.getMiddle(stringList);
        System.out.println(middle);
    }

    /**
     * 12.4、类型变量的限定 —— extends
     */
    public static void extends1204() {
        TMethod tMethod = new TMethod();
        tMethod.getName2(null);

        List<String> stringList = Arrays.asList("1111", "2222", "3333", "4444");
        String middle = ArrayAlg.getMiddle(stringList);
        System.out.println(middle);
    }

    /**
     * 12.5、泛型代码和虚拟机
     */
    public static void polymorphic1205() {
        DateInterval interval = new DateInterval();
        interval.setSecond(new Date());
    }

    /**
     * 12.8、通配符 —— extends\super
     */
    public static void wildcard1208() {
        Pair<?> pair = new Pair<>();
        Pair<? extends Date> pair01 = new Pair<>();
        Pair<? super Date> pair02 = new Pair<>();
    }

    /**
     * 12.9、反射和泛型
     */
    public static void reflect1209() {
    }
}
