package org.practice.designPattern.behavior.ch23interpreter.runoob;

/**
 * @author yoong
 * <br>
 * @desc OrExpression
 * <br>
 * @date 2019/1/16 11:55
 */
public class OrExpression implements Expression {

    private Expression expr1 = null;
    private Expression expr2 = null;

    public OrExpression(Expression expr1, Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public boolean interpret(String context) {
        return expr1.interpret(context) || expr2.interpret(context);
    }
}
