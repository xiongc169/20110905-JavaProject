package org.practice.springfx.book01.part02_ioc.event;

import java.util.EventObject;

/**
 * @Desc 5.3、容器内部事件发布 (P100)
 * PS: XEventObject
 * <p>
 * @Author yoong
 * <p>
 * @Date 2017-5-10 22:10:00
 * <p>
 * @Version 1.0
 */
public class XEventObject extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public XEventObject(Object source) {
        super(source);
    }
}
