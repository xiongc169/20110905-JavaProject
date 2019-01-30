package org.practice.java8.book02.ch12;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import static java.time.temporal.TemporalAdjusters.nextOrSame;

public class DateUtility {

    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            ch12Demo();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void ch12Demo() {
        // java 1.0的时间类库
        Date java8PublishDate = new Date(114, 2, 18);
        Date j1Now = new Date();
        System.out.println("date " + java8PublishDate);
        System.out.println("j1Now " + j1Now);

        // java 1.1的时间类库
        Calendar calendar = Calendar.getInstance();
        System.out.println("calendar " + calendar);

        // java 8的时间类库
        LocalDate now = LocalDate.now();
        LocalDate now2 = LocalDate.of(2014, 3, 18);
        System.out.println("now " + now);
        System.out.println("now2 " + now2);

        LocalTime thisTime = LocalTime.now();
        System.out.println("thisTime " + thisTime);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime " + localDateTime);

        Instant instant = Instant.now();
        System.out.println("instant " + instant);
        Instant instant2 = Instant.ofEpochSecond(0);
        System.out.println("instant2 " + instant2);

        Duration duration = Duration.between(Instant.ofEpochSecond(0), Instant.now());
        System.out.println(duration);

        LocalDate today = LocalDate.now();
        System.out.println(today);
        LocalDate nextWeek = today.with(nextOrSame(DayOfWeek.SUNDAY));

        String todayString1 = today.format(DateTimeFormatter.BASIC_ISO_DATE);
        String todayString2 = today.format(DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate lDate = LocalDate.parse("20180412", DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(todayString1);
    }
}
