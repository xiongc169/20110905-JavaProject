package com.yoong.netty4.book01.ch0601serialize;

import lombok.Data;

import java.io.Serializable;
import java.nio.ByteBuffer;

@Data
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String userName;
    private int userID;

    public UserInfo buildUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public UserInfo buildUserId(int userId) {
        this.userID = userId;
        return this;
    }

    /**
     * 使用基于ByteBuffer的通用二进制编解码技术对UserInfo对象进行编码
     *
     * @return
     */
    public byte[] codeC() {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        byte[] value = this.userName.getBytes();
        buffer.putInt(value.length);
        buffer.put(value);
        buffer.putInt(this.userID);
        buffer.flip();
        value = null;
        byte[] result = new byte[buffer.remaining()];
        buffer.get(result);
        return result;
    }
}
