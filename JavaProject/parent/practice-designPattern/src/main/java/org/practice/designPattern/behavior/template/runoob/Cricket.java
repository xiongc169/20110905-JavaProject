package org.practice.designPattern.behavior.template.runoob;

/**
 * @author yoong
 * <br>
 * @desc Cricket
 * <br>
 * @date 2019/1/15 13:55
 */
public class Cricket extends Game {

    @Override
    void initialize() {
        System.out.println("Cricket Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket Game Started. Enjoy the game!");
    }

    @Override
    void endPlay() {
        System.out.println("Cricket Game Finished!");
    }

}
