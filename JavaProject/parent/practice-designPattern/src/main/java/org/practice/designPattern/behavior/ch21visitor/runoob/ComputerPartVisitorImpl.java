package org.practice.designPattern.behavior.ch21visitor.runoob;

/**
 * @author yoong
 * <br>
 * @desc ComputerPartVisitorImpl
 * <br>
 * @date 2019/1/16 11:02
 */
public class ComputerPartVisitorImpl implements ComputerPartVisitor {

    @Override
    public void visit(ComputerPart part) {

        System.out.printf("ComputerPartVisitorImpl.visit(): %s %s \n", part, part.getClass());
    }
}
