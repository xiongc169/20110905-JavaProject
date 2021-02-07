package com.yoong.springfx.book01.part02_ioc.event;

import java.util.EventListener;

/**
 * @Desc MethodExecutionEventListener
 * <p>
 * @Author yoong
 * <p>
 * @Date 2017-5-10 22:10:00
 * <p>
 * @Version 1.0
 */
public interface MethodExecutionEventListener extends EventListener {

    void onMethodBegin(MethodExecutionEvent event);

    void onMethodEnd(MethodExecutionEvent event);
}
