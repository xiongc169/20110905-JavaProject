package org.practice.designPattern.create.builder.runoob.pack;

import org.practice.designPattern.create.builder.runoob.api.Packing;

/**
 * @author yoong
 * <br>
 * @desc Wrapper
 * <br>
 * @date 2019/1/14 17:14
 */
public class Wrapper implements Packing {

    @Override
    public String pack() {
        return "Wrapper";
    }
}
