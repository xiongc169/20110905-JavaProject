package org.practice.designPattern.behavior.ch21visitor.runoob;

public class Keyboard implements ComputerPart {

    @Override
    public void accept(ComputerPartVisitor visitor) {
        visitor.visit(this);
    }
}
