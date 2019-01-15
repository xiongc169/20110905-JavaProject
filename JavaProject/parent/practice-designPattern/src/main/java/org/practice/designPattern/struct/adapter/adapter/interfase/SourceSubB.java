package org.practice.designPattern.struct.adapter.adapter.interfase;

/**
 * @author yoong
 * <br>
 * @desc SourceSubB
 * <br>
 * @date 2019/1/15 10:34
 */
public class SourceSubB extends AbstractWrapper {
    @Override
    public void methodB() {
        System.out.println("This is SourceSubB.methodB()");
    }
}
