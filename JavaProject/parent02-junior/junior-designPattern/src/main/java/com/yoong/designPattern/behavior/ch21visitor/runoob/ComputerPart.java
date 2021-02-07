package com.yoong.designPattern.behavior.ch21visitor.runoob;

public interface ComputerPart {

    void accept(ComputerPartVisitor visitor);
}
