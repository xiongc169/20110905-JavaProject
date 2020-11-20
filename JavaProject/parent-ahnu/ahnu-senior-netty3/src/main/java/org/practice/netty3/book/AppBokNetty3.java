package org.practice.netty3.book;

/**
 * @Desc AppBokNetty3
 * PS：2009-7 ~ 2016-6
 * <p>
 * @Author yoong
 * <p>
 * @Date 2016年6月1日
 * <p>
 * @Version 1.0
 */
public class AppBokNetty3 {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            instanceofTest();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void instanceofTest() {
        Integer integer = 10;
        boolean instanceOf = integer instanceof Integer;
        boolean isInstance = Integer.class.isInstance("");
        System.out.println(instanceOf);
        System.out.println(isInstance);
    }
}
