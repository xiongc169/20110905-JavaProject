package com.yoong.netty4.book01.ch1301file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            RandomAccessFile access = new RandomAccessFile("", "");
            FileChannel file = access.getChannel();

            Path path = Paths.get("");
            AsynchronousFileChannel asynChannel = AsynchronousFileChannel.open(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
