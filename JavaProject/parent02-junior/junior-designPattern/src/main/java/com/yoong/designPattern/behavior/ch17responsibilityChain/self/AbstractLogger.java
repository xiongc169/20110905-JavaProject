package com.yoong.designPattern.behavior.ch17responsibilityChain.self;

public abstract class AbstractLogger {

    public AbstractLogger next = null;

    public abstract void write();
}
