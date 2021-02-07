package com.yoong.designPattern.create.ch04builder.runoob.item;

public class ColdDrinkPepsi extends ColdDrink {

    @Override
    public float price() {
        return 35.0f;
    }

    @Override
    public String name() {
        return "Pepsi";
    }
}
