package org.practice.designPattern.create.builder.runoob.item;

import org.practice.designPattern.create.builder.runoob.api.Item;
import org.practice.designPattern.create.builder.runoob.api.Packing;
import org.practice.designPattern.create.builder.runoob.pack.Bottle;

/**
 * @author yoong
 * <br>
 * @desc ColdDrink
 * <br>
 * @date 2019/1/14 17:18
 */
public abstract class ColdDrink implements Item {

    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}
