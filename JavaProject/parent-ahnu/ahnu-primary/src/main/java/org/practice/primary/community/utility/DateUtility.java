package org.practice.primary.community.utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Desc DateUtility
 * @Author
 * @Date
 * @Version 1.0
 */
public class DateUtility {

    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            getTimestamp();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Java获取时间戳：http://tangmingjie2009.iteye.com/blog/1543166 <br>
     * Java时间戳、时间转换：http://www.cnblogs.com/mstk/p/5511057.html <br>
     * java生成时间戳，13位<br>
     * .net生成时间戳，10位
     */
    public static void getTimestamp() {

        // 获取时间戳
        long timestamp = System.currentTimeMillis();
        long timestamp11 = System.currentTimeMillis();
        long timestamp2 = Calendar.getInstance().getTimeInMillis();
        long timestamp3 = new Date().getTime();
        long timestamp33 = new Date().getTime();
        System.out.println(timestamp);
        System.out.println(timestamp2);
        System.out.println(timestamp3);

        // 时间戳转换为时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long timestamp4 = 1509004771699L;
        Date date = new Date(timestamp4);
        String dateStr = simpleDateFormat.format(date);
        System.out.println(dateStr);

        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        String dateStr2 = format.format(new Date());
        System.out.println(dateStr2);
    }
}
