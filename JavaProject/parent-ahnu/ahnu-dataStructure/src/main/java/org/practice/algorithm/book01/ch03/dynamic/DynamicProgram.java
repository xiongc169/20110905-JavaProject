package org.practice.algorithm.book01.ch03.dynamic;

/**
 * @Desc DynamicProgram
 * <p>
 * @Author yoong
 * <p>
 * @Date 2012-07-04 09:00:00
 * <p>
 * @Version 1.0
 */
public class DynamicProgram {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            int[] array = {33, 24, 12, 5, 1};
            changeMoney(50, array);
            System.out.println(array.length);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void changeMoney(int total, int[] array) {

    }
}
