package org.practice.thread.book02.chap0203;

/**
 * @Desc 《Java 7并发编程实战手册》
 * PS：2.3、使用非依赖属性实现同步
 * https://www.jb51.net/books/404868.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2015-08-30 09:00:00
 * <p>
 * @Version 1.0
 */
public class AppMultiSync {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            cinemaTest();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void cinemaTest() throws Exception {
        Cinema cinema = new Cinema(20l, 20l);
        TicketOffice1 office1 = new TicketOffice1(cinema);
        Thread thread1 = new Thread(office1);

        TicketOffice2 office2 = new TicketOffice2(cinema);
        Thread thread2 = new Thread(office2);

        thread1.join();
        thread2.join();

        System.out.println("cinema.getVacanciesCinema1(): " + cinema.getVacanciesCinema1());
        System.out.println("cinema.getVacanciesCinema2(): " + cinema.getVacanciesCinema2());
    }
}
