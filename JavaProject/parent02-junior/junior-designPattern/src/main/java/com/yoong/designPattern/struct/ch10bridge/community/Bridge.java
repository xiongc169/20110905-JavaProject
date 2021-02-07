package com.yoong.designPattern.struct.ch10bridge.community;

import com.yoong.designPattern.struct.ch10bridge.community.api.Source;

public class Bridge {

    private Source source;

    public void method() {
        source.method();
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }
}
