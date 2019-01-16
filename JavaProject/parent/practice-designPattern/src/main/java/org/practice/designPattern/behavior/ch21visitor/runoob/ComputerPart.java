package org.practice.designPattern.behavior.ch21visitor.runoob;

/**
 * @author yoong
 * <br>
 * @desc ComputerPart
 * <br>
 * @date 2019/1/16 11:02
 */
public interface ComputerPart {

    void accept(ComputerPartVisitor visitor);
}
