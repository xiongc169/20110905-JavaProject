package org.practice.java8.book02.ch12;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import static java.time.temporal.TemporalAdjusters.nextOrSame;

/**
 * @Desc 《Java 8实战.pdf》
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018-03-02 09:00:00
 * <p>
 * @Version 1.0
 */
public class DateUtility {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            ch12Demo();
            convert();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void ch12Demo() {
        // java 1.0的时间类库：年份的起始选择是1900年，月份的起始从0开始
        java.util.Date java8PublishDate = new Date(114, 2, 18);// 2014-3-18
        java.util.Date j1Now = new Date();
        System.out.println("date " + java8PublishDate);
        System.out.println("j1Now " + j1Now);

        java.text.SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdFormat.format(java8PublishDate);
        System.out.println(dateStr);

        // java 1.1的时间类库
        java.util.Calendar calendar = Calendar.getInstance();
        System.out.println("calendar " + calendar);

        // java 8的时间类库
        java.time.LocalDate now = LocalDate.now();
        java.time.LocalDate now2 = LocalDate.of(2014, 3, 18);
        System.out.println("now " + now);
        System.out.println("now2 " + now2);

        java.time.LocalTime thisTime = LocalTime.now();
        System.out.println("thisTime " + thisTime);

        java.time.LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime " + localDateTime);

        java.time.Instant instant = Instant.now();
        System.out.println("instant " + instant);
        Instant instant2 = Instant.ofEpochSecond(0);
        System.out.println("instant2 " + instant2);

        java.time.Duration duration = Duration.between(Instant.ofEpochSecond(0), Instant.now());
        System.out.println(duration);

        java.time.LocalDate today = LocalDate.now();
        System.out.println(today);
        LocalDate nextWeek = today.with(nextOrSame(DayOfWeek.SUNDAY));

        String todayString1 = today.format(DateTimeFormatter.BASIC_ISO_DATE);
        String todayString2 = today.format(DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate lDate = LocalDate.parse("20180412", DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(todayString1);
    }

    /**
     * Java中Calendar与Date类型互转
     * https://blog.csdn.net/fz13768884254/article/details/82422752
     * https://blog.csdn.net/qq_36138652/article/details/82430600
     */
    public static void convert() {
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();

        Long timestamp01 = now.getTime();
        Long timestamp02 = calendar.getTimeInMillis();
        System.out.println(timestamp01);
        System.out.println(timestamp02);

        calendar.setTime(now);
        Long timestamp03 = calendar.getTimeInMillis();
        System.out.println(timestamp03);

        now = new Date(calendar.getTimeInMillis());
        now = calendar.getTime();
        System.out.println(now);
    }
}
