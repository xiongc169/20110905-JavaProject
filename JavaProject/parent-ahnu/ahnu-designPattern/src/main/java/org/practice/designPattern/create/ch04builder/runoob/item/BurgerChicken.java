package org.practice.designPattern.create.ch04builder.runoob.item;

/**
 * @author yoong
 * <br>
 * @desc BurgerChicken
 * <br>
 * @date 2019/1/14 17:20
 */
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
