package org.practice.designPattern.create.ch05prototype.community;

import java.io.*;

public class Prototype implements Cloneable, Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 此处clone方法可以改成任意的名称，因为Cloneable接口是个空接口，可以任意定义实现类的方法名，如cloneA或者cloneB；因为此处的重点是super.clone()
     */
    public Prototype clone() throws CloneNotSupportedException {
        Prototype proto = (Prototype) super.clone();
        return proto;
    }


    /**
     * 深复制
     * https://www.cnblogs.com/maowang1991/archive/2013/04/15/3023236.html
     */
    public Object deepClone() throws IOException, ClassNotFoundException {
        /* 写入当前对象的二进制流 */
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);
        /* 读出二进制流产生的新对象 */
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
    }
}
