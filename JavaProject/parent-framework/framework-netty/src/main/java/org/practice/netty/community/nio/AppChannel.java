package org.practice.netty.community.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Java NIO 教程(二) Channel
 * https://www.jianshu.com/p/1ecacad9beb5
 */
public class AppChannel {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void channelTest(String fileName) throws Exception {
        RandomAccessFile file = new RandomAccessFile(fileName, "rw");
        FileChannel channel = file.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate((int) channel.size());
        channel.read(byteBuffer);

    }
}
