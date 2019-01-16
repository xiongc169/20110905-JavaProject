package org.practice.designPattern.behavior.ch21visitor.runoob;

/**
 * @author yoong
 * <br>
 * @desc Computer
 * <br>
 * @date 2019/1/16 11:03
 */
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
