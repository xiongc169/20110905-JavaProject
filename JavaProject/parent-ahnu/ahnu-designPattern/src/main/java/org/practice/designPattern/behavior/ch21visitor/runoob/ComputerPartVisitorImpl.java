package org.practice.designPattern.behavior.ch21visitor.runoob;

public class ComputerPartVisitorImpl implements ComputerPartVisitor {

    @Override
    public void visit(ComputerPart part) {

        System.out.printf("ComputerPartVisitorImpl.visit(): %s %s \n", part, part.getClass());
    }
}
