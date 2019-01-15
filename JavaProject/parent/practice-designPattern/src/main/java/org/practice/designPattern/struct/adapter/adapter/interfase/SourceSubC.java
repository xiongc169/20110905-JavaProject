package org.practice.designPattern.struct.adapter.adapter.interfase;

/**
 * @author yoong
 * <br>
 * @desc SourceSubC
 * <br>
 * @date 2019/1/15 10:34
 */
public class SourceSubC extends AbstractWrapper {

    @Override
    public void methodC() {
        System.out.println("This is SourceSubC.methodC()");
    }
}
