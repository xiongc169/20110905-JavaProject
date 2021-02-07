package com.yoong.designPattern.behavior.ch21visitor.runoob;

public class Monitor implements ComputerPart {

    @Override
    public void accept(ComputerPartVisitor visitor) {
        visitor.visit(this);
    }
}
