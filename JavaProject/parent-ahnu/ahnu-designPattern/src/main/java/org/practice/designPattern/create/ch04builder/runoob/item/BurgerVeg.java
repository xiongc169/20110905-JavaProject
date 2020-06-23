package org.practice.designPattern.create.ch04builder.runoob.item;

public class BurgerVeg extends Burger {

    @Override
    public float price() {
        return 25.0f;
    }

    @Override
    public String name() {
        return "Veg Burger";
    }
}
