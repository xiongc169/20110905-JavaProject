package com.yoong.springfx.book01.part02_ioc.event;

import java.util.EventObject;

/**
 * @Desc 5.3、容器内部事件发布 (P100)
 * PS: MethodExecutionEvent
 * <p>
 * @Author yoong
 * <p>
 * @Date 2017-5-10 22:10:00
 * <p>
 * @Version 1.0
 */
public class MethodExecutionEvent extends EventObject {

    private String methodName;

    public MethodExecutionEvent(Object source) {
        super(source);
    }

    public MethodExecutionEvent(Object source, String methodName) {
        super(source);
        this.methodName = methodName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
}
