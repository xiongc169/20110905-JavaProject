package org.practice.designPattern.create.builder.runoob.api;

/**
 * @author yoong
 * <br>
 * @desc Item
 * <br>
 * @date 2019/1/14 17:13
 */
public interface Item {

    String name();

    Packing packing();

    float price();
}
