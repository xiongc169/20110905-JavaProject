package org.practice.netty.community.nio01;

import java.io.RandomAccessFile;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.*;
import java.nio.channels.DatagramChannel;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * Java NIO教程
 * https://www.jianshu.com/p/465ecd909f8c
 * Java NIO 教程(一) 概述
 * https://www.jianshu.com/p/f22fa0199f91
 * Java NIO 教程(二) Channel
 * https://www.jianshu.com/p/1ecacad9beb5
 */
public class AppNio {
    private static String filePath = "D:\\Temp\\IO";

    private static String txtFileName = "D:\\Temp\\IO\\abc.txt";
    private static String txtFileName01 = "D:\\Temp\\IO\\abc01.txt";

    private static String zipFileName = "D:\\Temp\\IO\\xyz.zip";
    private static String zipFileName01 = "D:\\Temp\\IO\\xyz01.zip";

    private static String mp4FileName = "D:\\Temp\\IO\\video.mp4";
    private static String mp4FileName01 = "D:\\Temp\\IO\\video01.mp4";
    private static String mp4FileName02 = "D:\\Temp\\IO\\video02.mp4";

    private static String videoUrl = "http://img.fincs.net/zahy/cls/loan/2019/12/20/a911bc41-90ca-4d5b-b731-f8f1f49f5d1a.mp4";
    private static String videoUrl01 = "http://img.fincs.net/zahy/cls/loan/2019/12/20/4a8a3491-26bc-4a0a-bc58-99a49cc95d45.mp4";
    private static String videoUrl02 = "http://img.fincs.net/zahy/cls/loan/2019/12/6/cca9b111-feba-4129-b4f2-0fcdca8d4635.mp4";
    private static String videoUrl03 = "http://img.fincs.net/zahy/cls/loan/2019/12/6/5ac5a802-9085-484c-9e53-9f32f1816f31.mp4";

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            channelTest(txtFileName);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Channel、Buffer列表
     */
    public static void channelTest(String fileName) throws Exception {
        RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();
        DatagramChannel datagramChannel = DatagramChannel.open();
        SocketChannel socketChannel = SocketChannel.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        ShortBuffer shortBuffer = ShortBuffer.allocate(10);
        IntBuffer intBuffer = IntBuffer.allocate(10);
        LongBuffer longBuffer = LongBuffer.allocate(10);
        FloatBuffer floatBuffer = FloatBuffer.allocate(10);
        DoubleBuffer doubleBuffer = DoubleBuffer.allocate(10);
        CharBuffer charBuffer = CharBuffer.allocate(10);

        ByteBuffer byteBuffer1 = ByteBuffer.allocate((int) fileChannel.size());
        Integer length = fileChannel.read(byteBuffer1);
        System.out.println(length);
        byteBuffer1.flip();
        Charset charset = Charset.forName("utf-8");
        String result = charset.decode(byteBuffer1).toString();
        System.out.println(result);
    }

}
