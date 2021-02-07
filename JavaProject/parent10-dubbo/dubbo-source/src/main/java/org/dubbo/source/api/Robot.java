package org.dubbo.source.api;

import com.alibaba.dubbo.common.extension.SPI;

@SPI
public interface Robot {
    void sayHello();
}
