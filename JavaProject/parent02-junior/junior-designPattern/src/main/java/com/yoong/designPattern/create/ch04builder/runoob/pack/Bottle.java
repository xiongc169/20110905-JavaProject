package com.yoong.designPattern.create.ch04builder.runoob.pack;

import com.yoong.designPattern.create.ch04builder.runoob.api.Packing;

public class Bottle implements Packing {

    @Override
    public String pack() {
        return "Bottle";
    }
}
