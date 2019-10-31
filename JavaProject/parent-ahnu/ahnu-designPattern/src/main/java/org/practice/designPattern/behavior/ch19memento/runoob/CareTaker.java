package org.practice.designPattern.behavior.ch19memento.runoob;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yoong
 * <br>
 * @desc CareTaker
 * <br>
 * @date 2019/1/15 15:57
 */
public class CareTaker {

    List<Memento> mementoList = new ArrayList<>();

    public void add(Memento state) {
        mementoList.add(state);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }
}
