package com.yoong.jvm;

/**
 * @Desc AppJvm
 * <p>
 * @Author yoong
 * <p>
 * @Date 2016-04-01 09:00:00
 * <p>
 * @Version 1.0
 */
public class AppJvm {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            System.out.println(args.length);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
