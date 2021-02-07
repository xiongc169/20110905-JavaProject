package com.yoong.designPattern.behavior.ch21visitor.runoob;

public class Computer implements ComputerPart {

    ComputerPart[] parts;


    public Computer() {
        parts = new ComputerPart[]{new Keyboard(), new Monitor(), new Mouse()};
    }

    @Override
    public void accept(ComputerPartVisitor visitor) {
        for (int i = 0; i < parts.length; i++) {
            visitor.visit(parts[i]);
        }
    }
}
