package org.practice.designPattern.create.ch04builder.runoob.pack;

import org.practice.designPattern.create.ch04builder.runoob.api.Packing;

/**
 * @author yoong
 * <br>
 * @desc Bottle
 * <br>
 * @date 2019/1/14 17:16
 */
public class Bottle implements Packing {

    @Override
    public String pack() {
        return "Bottle";
    }
}
