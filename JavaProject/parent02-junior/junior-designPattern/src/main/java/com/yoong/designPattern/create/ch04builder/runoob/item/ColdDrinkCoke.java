package com.yoong.designPattern.create.ch04builder.runoob.item;

public class ColdDrinkCoke extends ColdDrink {

    @Override
    public float price() {
        return 30.0f;
    }

    @Override
    public String name() {
        return "Coke";
    }
}
