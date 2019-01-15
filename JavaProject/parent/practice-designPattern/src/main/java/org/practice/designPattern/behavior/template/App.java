package org.practice.designPattern.behavior.template;

import org.practice.designPattern.behavior.template.runoob.Cricket;
import org.practice.designPattern.behavior.template.runoob.Football;
import org.practice.designPattern.behavior.template.runoob.Game;

/**
 * @author yoong
 * <br>
 * @desc 模板模式
 * http://www.runoob.com/design-pattern/template-pattern.html
 * <br>
 * @date 2019/1/15 13:52
 */
public class App {
    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            runoob_template();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void runoob_template() {
        Game cricket = new Cricket();
        cricket.play();

        Game football = new Football();
        football.play();
    }

}
