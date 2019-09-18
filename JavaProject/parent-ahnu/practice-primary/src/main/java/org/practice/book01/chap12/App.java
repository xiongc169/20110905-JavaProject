package org.practice.book01.chap12;

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
            ArrayList<String> strings = new ArrayList<>();
            ArrayList<Integer> integers = new ArrayList<>();
            System.out.println(strings.getClass() == integers.getClass() ? "Equal Class" : "NonEqual Class");

            arrayUtils();
            tClass();
            tMethod();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void arrayUtils() {
        List<String> stringList = Arrays.asList("1111", "2222", "3333", "4444");
        String middle = ArrayUtility.getMiddle(stringList);
        System.out.println(middle);
    }

    /**
     * java 泛型详解-绝对是对泛型方法讲解最详细的
     * https://www.cnblogs.com/coprince/p/8603492.html
     */
    public static void tClass() {
        List list = new ArrayList();
        list.add(100);
        list.add("100");//输出时会有问题

        List<String> strings = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        if (strings.getClass() == integers.getClass()) {
            //泛型只在编译阶段有效。编译后，程序会采取去泛型化的措施。
            //在编译过程中，检验泛型结果后，会将泛型信息擦除，在对象进入、离开方法的边界处，添加类型检查、类型转换的方法。
            System.out.println("class equals");
        }

        TClass intClass = new TClass();
        intClass.setData(100);
        Integer result = (int) intClass.getData();
        System.out.println("result: " + result);

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
