package org.practice.designPattern.create.ch04builder.runoob.item;

/**
 * @author yoong
 * <br>
 * @desc ColdDrinkCoke
 * <br>
 * @date 2019/1/14 17:20
 */
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
