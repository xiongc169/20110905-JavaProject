package org.practice.designPattern.create.ch04builder.runoob.pack;

import org.practice.designPattern.create.ch04builder.runoob.api.Packing;

public class Wrapper implements Packing {

    @Override
    public String pack() {
        return "Wrapper";
    }
}
