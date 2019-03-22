package org.practice.designPattern.behavior.ch21visitor.runoob;

/**
 * @author yoong
 * <br>
 * @desc Keyboard
 * <br>
 * @date 2019/1/16 11:03
 */
public class Keyboard implements ComputerPart {

    @Override
    public void accept(ComputerPartVisitor visitor) {
        visitor.visit(this);
    }
}
