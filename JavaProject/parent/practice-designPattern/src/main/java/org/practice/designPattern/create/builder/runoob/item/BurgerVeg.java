package org.practice.designPattern.create.builder.runoob.item;

/**
 * @author yoong
 * <br>
 * @desc BurgerVeg
 * <br>
 * @date 2019/1/14 17:19
 */
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
