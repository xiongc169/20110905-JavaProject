package org.practice.java8.book02.ch05.ch0505;

public class Trader {
    private String name;
    private String city;

    public Trader(String n, String c) {
        this.name = n;
        this.city = c;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String toString() {
        return "Trader:" + this.name + " in " + this.city;
    }
}
