package org.practice.designPattern.behavior.ch21visitor;

import org.practice.designPattern.behavior.ch21visitor.runoob.Computer;
import org.practice.designPattern.behavior.ch21visitor.runoob.ComputerPart;
import org.practice.designPattern.behavior.ch21visitor.runoob.ComputerPartVisitor;
import org.practice.designPattern.behavior.ch21visitor.runoob.ComputerPartVisitorImpl;

/**
 * @author yoong
 * <br>
 * @desc 访问者模式 (Visitor Pattern)
 * http://www.runoob.com/design-pattern/visitor-pattern.html
 * <br>
 * @date 2019/1/15 16:36
 */
public class App {

    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            visitor_runoob();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void visitor_runoob() {
        ComputerPartVisitor visitor = new ComputerPartVisitorImpl();
        ComputerPart computer = new Computer();
        computer.accept(visitor);
    }
}
