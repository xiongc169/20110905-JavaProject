package com.yoong.designPattern.create.ch04builder.runoob.item;

import com.yoong.designPattern.create.ch04builder.runoob.api.Item;
import com.yoong.designPattern.create.ch04builder.runoob.api.Packing;
import com.yoong.designPattern.create.ch04builder.runoob.pack.Wrapper;

public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
