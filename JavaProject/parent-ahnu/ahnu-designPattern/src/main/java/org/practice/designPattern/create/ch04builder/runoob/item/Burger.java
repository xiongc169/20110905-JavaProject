package org.practice.designPattern.create.ch04builder.runoob.item;

import org.practice.designPattern.create.ch04builder.runoob.api.Item;
import org.practice.designPattern.create.ch04builder.runoob.api.Packing;
import org.practice.designPattern.create.ch04builder.runoob.pack.Wrapper;

public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
