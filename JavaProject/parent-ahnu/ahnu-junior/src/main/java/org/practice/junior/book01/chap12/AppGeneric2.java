package org.practice.junior.book01.chap12;

import org.practice.junior.book01.chap12.ch1202.TClass;
import org.practice.junior.book01.chap12.ch1202.TMethod;

import java.util.*;

/**
 * @Desc AppGeneric2
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018年8月20日
 * <p>
 * @Version 1.0
 */
public class AppGeneric2 {

    Map<String, Integer> map1 = new HashMap<>();

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            queryTecent();
            genericEquals();
            tClass();
            tMethod();

            int a = 1;
            String b = "0";
            System.out.println(b.equals(String.valueOf(a)));
            System.out.println(Integer.valueOf(b).equals(a));
            System.out.println(args.length);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 腾讯课堂——泛型
     * javap -v *.class 反编译class文件
     */
    public static void queryTecent() {
        try {
            Map<String, Integer> map2 = new HashMap<>();
            System.out.println(map2.size());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void genericEquals() {
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<Integer> integers = new ArrayList<>();
        System.out.println(strings.getClass() == integers.getClass() ? "Equal Class" : "NonEqual Class");//Equal Class
    }

    public static void getString(List<String> param) {
    }

    //public static void getString(List<Integer> param) {
    //}

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

        TClass<String, String, String> stringClass = new TClass();
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
