package org.practice.java8.book02.ch04;

public enum DishType {
    MEAT(1, "MEAT"),
    FISH(2, "FISH"),
    OTHER(3, "OTHER");

    private Integer code;

    private String name;

    DishType(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
}
