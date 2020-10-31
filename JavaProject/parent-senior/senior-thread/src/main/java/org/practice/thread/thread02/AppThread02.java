package org.practice.thread.thread02;

import java.text.SimpleDateFormat;

/**
 * @Desc 多线程系列教程
 * https://www.cnblogs.com/dolphin0520/category/1426288.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2015-08-30 09:06:00
 * <p>
 * @Version 1.0
 */
public class AppThread02 {

    //HH表示24小时制 如果换成hh表示12小时制
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            System.out.println(args);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
