package org.practice.primary.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author yoong
 * <br>
 * @desc 泛型类、泛型方法、
 * <br>
 * @date 2019/1/31 19:22
 */
public class App {

    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            List<String> stringList = Arrays.asList("1111", "2222", "3333", "4444");
            String middle = ArrayUtility.getMiddle(stringList);
            System.out.println(middle);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
