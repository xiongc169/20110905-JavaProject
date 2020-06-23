package org.practice.designPattern.behavior.ch22mediator.runoob;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatRoom {

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");

    public static void showMessage(User user, String message) {
        System.out.printf("%s: [%s]--[%s]\n", format.format(new Date()), user.getName(), message);
    }
}
