package org.practice.designPattern.create.ch05prototype.community;

import java.io.Serializable;

public class Prototype implements Cloneable, Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Prototype clone() throws CloneNotSupportedException {
        Prototype proto = (Prototype) super.clone();
        return proto;
    }
}
