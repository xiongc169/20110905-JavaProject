package org.practice.springfx.book01.part02_ioc.event;

/**
 * @Desc SimpleMethodExecutionEventListener
 * <p>
 * @Author yoong
 * <p>
 * @Date 2017-5-10 22:10:00
 * <p>
 * @Version 1.0
 */
public class SimpleMethodExecutionEventListener implements MethodExecutionEventListener {

    @Override
    public void onMethodBegin(MethodExecutionEvent event) {
        String methodName = event.getMethodName();
        System.out.println("start to execute the method:" + methodName);
    }

    @Override
    public void onMethodEnd(MethodExecutionEvent event) {
        String methodName = event.getMethodName();
        System.out.println("finished to execute the method:" + methodName);
    }
}
