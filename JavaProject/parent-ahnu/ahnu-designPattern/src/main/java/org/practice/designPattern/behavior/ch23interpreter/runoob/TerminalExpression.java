package org.practice.designPattern.behavior.ch23interpreter.runoob;

/**
 * @author yoong
 * <br>
 * @desc TerminalExpression
 * <br>
 * @date 2019/1/16 11:54
 */
public class TerminalExpression implements Expression {

    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        if (context.contains(data)) {
            return true;
        }
        return false;
    }
}
