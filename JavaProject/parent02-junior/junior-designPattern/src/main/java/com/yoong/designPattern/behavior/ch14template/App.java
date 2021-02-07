package com.yoong.designPattern.behavior.ch14template;

import com.yoong.designPattern.behavior.ch14template.runoob.Cricket;
import com.yoong.designPattern.behavior.ch14template.runoob.Football;
import com.yoong.designPattern.behavior.ch14template.runoob.Game;

/**
 * @Desc 模板模式
 * http://www.runoob.com/design-pattern/template-pattern.html
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
            template_runoob();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void template_runoob() {
        Game cricket = new Cricket();
        cricket.play();

        Game football = new Football();
        football.play();
    }

}
