package org.practice.designPattern.behavior.ch21visitor.runoob;

public interface ComputerPart {

    void accept(ComputerPartVisitor visitor);
}
