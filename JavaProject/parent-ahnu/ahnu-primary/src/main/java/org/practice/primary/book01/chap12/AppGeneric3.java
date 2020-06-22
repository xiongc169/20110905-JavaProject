package org.practice.primary.book01.chap12;

import java.util.HashMap;
import java.util.Map;

/**
 * @Desc App3
 * @Author
 * @Date
 * @Version 1.0
 */
public class AppGeneric3 {

    Map<String, Integer> map1 = new HashMap<>();

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
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
    public static void queryTecent(String[] args) {
        try {
            Map<String, Integer> map2 = new HashMap<>();
            System.out.println(map2.size());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
