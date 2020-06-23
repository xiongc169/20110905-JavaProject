package org.practice.designPattern.create.ch04builder.runoob.item;

public class BurgerChicken extends Burger {

    @Override
    public float price() {
        return 50.5f;
    }

    @Override
    public String name() {
        return "Chicken Burger";
    }
}
