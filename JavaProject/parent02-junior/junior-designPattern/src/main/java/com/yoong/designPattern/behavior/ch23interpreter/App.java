package com.yoong.designPattern.behavior.ch23interpreter;

import com.yoong.designPattern.behavior.ch23interpreter.runoob.AndExpression;
import com.yoong.designPattern.behavior.ch23interpreter.runoob.Expression;
import com.yoong.designPattern.behavior.ch23interpreter.runoob.OrExpression;
import com.yoong.designPattern.behavior.ch23interpreter.runoob.TerminalExpression;

/**
 * @Desc 解释器模式 (Interpreter Pattern)
 * http://www.runoob.com/design-pattern/interpreter-pattern.html
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
            interpreter_runoob();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void interpreter_runoob() {
        Expression isMale = getMaleExpression();
        Expression isMarriedWoman = getMarriedWomanExpression();

        System.out.println("John is male? " + isMale.interpret("John"));
        System.out.println("Julie is a married women? " + isMarriedWoman.interpret("Married Julie"));
    }

    //规则：Robert 和 John 是男性
    public static Expression getMaleExpression() {
        Expression robert = new TerminalExpression("Robert");
        Expression john = new TerminalExpression("John");
        return new OrExpression(robert, john);
    }

    //规则：Julie 是一个已婚的女性
    public static Expression getMarriedWomanExpression() {
        Expression julie = new TerminalExpression("Julie");
        Expression married = new TerminalExpression("Married");
        return new AndExpression(julie, married);
    }

}
