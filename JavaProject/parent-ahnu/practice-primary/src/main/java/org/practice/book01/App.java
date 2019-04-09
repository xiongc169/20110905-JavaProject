package org.practice.book01;


import org.practice.book01.chap03.DataType;
import org.practice.book01.chap12.ArrayUtility;
import org.practice.book01.chap12.TClass;
import org.practice.book01.chap12.TMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 《Java核心技术·卷1》
 */
public class App {

    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            deepClone();
            arrayUtils();
            tClass();
            tMethod();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void deepClone() {
        DataType dataType = new DataType();
        dataType.deepClone = "2019年4月2日20:22:42";
        DataType dataType2 = new DataType();
        dataType2 = dataType.clone();
        dataType2.deepClone = "2019年4月2日20:23:13";

        System.out.println(dataType.deepClone);
        System.out.println(dataType2.deepClone);
    }

    public static void arrayUtils() {
        List<String> stringList = Arrays.asList("1111", "2222", "3333", "4444");
        String middle = ArrayUtility.getMiddle(stringList);
        System.out.println(middle);
    }

    public static void tClass() {
        List list = new ArrayList();
        list.add(100);
        list.add("100");

        TClass intClass = new TClass();
        intClass.setData(100);
        Integer result = (int) intClass.getData();

        TClass<String> stringClass = new TClass();
        stringClass.setData("100");
        String result2 = stringClass.getData();
    }

    public static void tMethod() {
        TMethod gMethod = new TMethod();
        Date date = gMethod.<Date>getGenericResult(Date.class);
        String hello = gMethod.<String>getGenericResult(String.class);
        System.out.println(date);
        System.out.println(hello);
    }
}
