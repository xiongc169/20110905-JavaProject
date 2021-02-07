package com.yoong.designPattern.create.ch04builder.runoob.pack;

import com.yoong.designPattern.create.ch04builder.runoob.api.Packing;

public class Wrapper implements Packing {

    @Override
    public String pack() {
        return "Wrapper";
    }
}
