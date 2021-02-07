package com.yoong.designPattern.create.ch04builder.runoob.item;

import com.yoong.designPattern.create.ch04builder.runoob.pack.Bottle;
import com.yoong.designPattern.create.ch04builder.runoob.api.Item;
import com.yoong.designPattern.create.ch04builder.runoob.api.Packing;

public abstract class ColdDrink implements Item {

    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}
