package org.practice.designPattern.behavior.ch14template.runoob;

/**
 * @author yoong
 * <br>
 * @desc Football
 * <br>
 * @date 2019/1/15 13:56
 */
public class Football extends Game {

    @Override
    void initialize() {
        System.out.println("Football Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Football Game Started. Enjoy the game!");
    }

    @Override
    void endPlay() {
        System.out.println("Football Game Finished!");
    }
}
