package org.practice.designPattern.behavior.ch14template.runoob;

/**
 * @author yoong
 * <br>
 * @desc Game
 * <br>
 * @date 2019/1/15 13:53
 */
public abstract class Game {

    abstract void initialize();

    abstract void startPlay();

    abstract void endPlay();

    public final void play() {
        initialize();
        startPlay();
        endPlay();
    }
}
