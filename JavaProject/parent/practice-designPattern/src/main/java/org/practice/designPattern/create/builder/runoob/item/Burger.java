package org.practice.designPattern.create.builder.runoob.item;

import org.practice.designPattern.create.builder.runoob.api.Item;
import org.practice.designPattern.create.builder.runoob.api.Packing;
import org.practice.designPattern.create.builder.runoob.pack.Wrapper;

/**
 * @author yoong
 * <br>
 * @desc Burger
 * <br>
 * @date 2019/1/14 17:17
 */
public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
