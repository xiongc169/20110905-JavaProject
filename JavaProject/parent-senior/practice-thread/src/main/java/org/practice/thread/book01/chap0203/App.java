package org.practice.thread.book01.chap0203;

/**
 *
 */
public class App {

    /**
     * 入口函数
     *
     * @param args
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
