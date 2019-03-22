package org.practice.designPattern.behavior.ch23interpreter.runoob;

/**
 * @author yoong
 * <br>
 * @desc Expression
 * <br>
 * @date 2019/1/16 11:54
 */
public interface Expression {

    boolean interpret(String context);
}
