package com.yoong.designPattern.behavior.ch21visitor;

import com.yoong.designPattern.behavior.ch21visitor.runoob.Computer;
import com.yoong.designPattern.behavior.ch21visitor.runoob.ComputerPart;
import com.yoong.designPattern.behavior.ch21visitor.runoob.ComputerPartVisitor;
import com.yoong.designPattern.behavior.ch21visitor.runoob.ComputerPartVisitorImpl;

/**
 * @Desc 访问者模式 (Visitor Pattern)
 * http://www.runoob.com/design-pattern/visitor-pattern.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2012年7月4日
 * <p>
 * @Version 1.0
 */
public class App {

    /**
     * 入口函数
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
