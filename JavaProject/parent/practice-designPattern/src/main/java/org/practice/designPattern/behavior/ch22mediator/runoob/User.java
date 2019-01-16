package org.practice.designPattern.behavior.ch22mediator.runoob;

/**
 * @author yoong
 * <br>
 * @desc User
 * <br>
 * @date 2019/1/16 11:44
 */
public class User {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name) {
        this.name = name;
    }

    public void sendMessage(String message) {
        ChatRoom.showMessage(this, message);
    }
}
