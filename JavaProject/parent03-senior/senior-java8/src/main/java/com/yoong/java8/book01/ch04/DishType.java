package com.yoong.java8.book01.ch04;

import java.util.stream.Stream;

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

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static DishType getType(Integer code) {
        DishType type = Stream.of(DishType.values()).filter(item -> item.getCode().intValue() == code).findFirst().orElse(null);
        return type;
    }
}
