package org.practice.primary.book01.chap14.book02.chap0203;

public class Cinema {

    private Long vacanciesCinema1;
    private Long vacanciesCinema2;

    private Object controlCinema1;
    private Object controlCinema2;

    public Cinema() {
    }

    public Cinema(Long vacancy1, Long vacancy2) {
        this.vacanciesCinema1 = vacancy1;
        this.vacanciesCinema2 = vacancy2;
        this.controlCinema1 = new Object();
        this.controlCinema2 = new Object();
    }

    public Long getVacanciesCinema1() {
        return vacanciesCinema1;
    }

    public Long getVacanciesCinema2() {
        return vacanciesCinema2;
    }

    public boolean sellTicket1(Integer number) {
        synchronized (controlCinema1) {
            if (number < vacanciesCinema1) {
                vacanciesCinema1 -= number;
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean sellTicket2(Integer number) {
        synchronized (controlCinema2) {
            if (number < vacanciesCinema2) {
                vacanciesCinema2 -= number;
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean returnTicket1(Integer number) {
        synchronized (controlCinema1) {
            vacanciesCinema1 += number;
            return true;
        }
    }

    public boolean returnTicket2(Integer number) {
        synchronized (controlCinema2) {
            vacanciesCinema2 += number;
            return true;
        }
    }
}
