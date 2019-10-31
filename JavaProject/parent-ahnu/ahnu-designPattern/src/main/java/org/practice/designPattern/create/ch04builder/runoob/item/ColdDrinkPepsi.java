package org.practice.designPattern.create.ch04builder.runoob.item;

/**
 * @author yoong
 * <br>
 * @desc ColdDrinkPepsi
 * <br>
 * @date 2019/1/14 17:21
 */
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
