package org.practice.spring.ioc.event;

import java.util.EventObject;

/**
 * @Desc TODO: 5.3、容器内部事件发布
 * PS: XEventObject
 * @Author
 * @Date
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
