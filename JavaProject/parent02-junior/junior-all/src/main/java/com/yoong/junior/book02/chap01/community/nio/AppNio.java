package com.yoong.junior.book02.chap01.community.nio;

import sun.nio.ch.DirectBuffer;

import java.io.RandomAccessFile;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

/**
 * @Desc Java NIO教程
 * https://www.jianshu.com/p/465ecd909f8c
 * Java NIO 教程(一) 概述
 * https://www.jianshu.com/p/f22fa0199f91
 * Java NIO 教程(二) Channel
 * https://www.jianshu.com/p/1ecacad9beb5
 * <p>
 * @Author yoong
 * <p>
 * @Date 2016年4月1日
 * <p>
 * @Version 1.0
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
    private static String panVideo = "D:\\Temp\\IO\\pan.mp4";

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            channelTest(txtFileName);
            transferTest();
            fileChannelTest();
            asynchronousFileChannelTest();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Java NIO 教程(二) Channel
     * PS：FileChannel，从文件中读写数据。
     * DatagramChannel，能通过UDP读写网络中的数据。
     * SocketChannel，能通过TCP读写网络中的数据。
     * ServerSocketChannel，监听新进来的TCP连接，像Web服务器，对每个新进来的连接会创建SocketChannel。
     * https://www.jianshu.com/p/1ecacad9beb5
     */
    public static void channelTest(String fileName) throws Exception {
        RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();
        FileChannel fileChannel02 = FileChannel.open(Paths.get(mp4FileName), StandardOpenOption.READ);
        DatagramChannel datagramChannel = DatagramChannel.open();
        SocketChannel socketChannel = SocketChannel.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        //堆内内存：分配JVM堆内存，属于GC管辖范围，由于需要拷贝所以速度相对较慢
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        ShortBuffer shortBuffer = ShortBuffer.allocate(10);
        IntBuffer intBuffer = IntBuffer.allocate(10);
        LongBuffer longBuffer = LongBuffer.allocate(10);
        FloatBuffer floatBuffer = FloatBuffer.allocate(10);
        DoubleBuffer doubleBuffer = DoubleBuffer.allocate(10);
        CharBuffer charBuffer = CharBuffer.allocate(10);
        //内存映射文件
        ByteBuffer mappedByteBuffer = MappedByteBuffer.allocate(10);

        //DirectByteBuffer 不是 public 的
        //DirectByteBuffer directByteBuffer = new DirectByteBuffer();
        //堆外内存：分配OS本地内存，不属于GC管辖范围，由于不需要内存拷贝所以速度相对较快
        ByteBuffer directByteBuffer = ByteBuffer.allocateDirect(1024);
        //clean()方法能有效及时回收直接缓存
        ((DirectBuffer) directByteBuffer).cleaner().clean();

        ByteBuffer byteBuffer1 = ByteBuffer.allocate((int) fileChannel.size());
        Integer length = fileChannel.read(byteBuffer1);
        System.out.println(length);
        byteBuffer1.flip();
        Charset charset = Charset.forName("utf-8");
        String result = charset.decode(byteBuffer1).toString();
        System.out.println(result);
    }

    /**
     * Java NIO 教程(五) 通道之间的数据传输
     * PS：toChannel.transferFrom(fromChannel);    //transferFrom()方法将数据从源通道传输到FileChannel中
     * fromChannel.transferTo(toChannel);    //transferTo()方法将数据从FileChannel传输到其他的channel中
     * https://www.jianshu.com/p/fdf72be99d76
     */
    public static void transferTest() throws Exception {
        String mp4FileName = "D:\\Temp\\IO\\video.mp4";
        String mp4FileName02 = "D:\\Temp\\IO\\video-02.mp4";
        RandomAccessFile fromFile = new RandomAccessFile(mp4FileName, "rw");
        FileChannel fromChannel = fromFile.getChannel();

        RandomAccessFile toFile = new RandomAccessFile(mp4FileName02, "rw");
        FileChannel toChannel = toFile.getChannel();

        //toChannel.transferFrom(fromChannel, 0, fromChannel.size());
        fromChannel.transferTo(0, fromChannel.size(), toChannel);
    }

    /**
     * Java NIO 教程(七) FileChannel
     * PS：通过使用一个InputStream、OutputStream、RandomAccessFile来获取一个FileChannel实例。
     * https://www.jianshu.com/p/ab7044548e08
     */
    public static void fileChannelTest() throws Exception {
        RandomAccessFile randomAccessFile = new RandomAccessFile(txtFileName01, "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();
        for (int i = 0; i < 100; i++) {
            String line = "This is line " + i + "\r\n";
            byte[] bytes = line.getBytes();
            ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
            buffer.put(bytes);
            buffer.flip();//需要通过flip()方法将Buffer从写模式切换到读模式
            fileChannel.write(buffer);
        }
        fileChannel.close();
    }

    /**
     * Java NIO 教程(十六) Java NIO AsynchronousFileChannel
     * PS：在Java 7中，AsynchronousFileChannel 被添加到Java NIO。AsynchronousFileChannel使读取数据，并异步地将数据写入文件成为可能。
     * https://www.jianshu.com/p/b38f8c596193
     */
    public static void asynchronousFileChannelTest() {
        try {
            //读取数据 - Future
            Path path = Paths.get(panVideo);
            AsynchronousFileChannel aFileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.READ, StandardOpenOption.WRITE);
            ByteBuffer buffer = ByteBuffer.allocate(1024 * 1024 * 1024);
            Future future = aFileChannel.read(buffer, 0);
            while (!future.isDone()) {
                System.out.println(future.isDone());
                Thread.sleep(1000);
            }
            System.out.println(future.isDone());

            //读取数据 - CompletionHandler
            AsynchronousFileChannel aFileChannel02 = AsynchronousFileChannel.open(path, StandardOpenOption.READ, StandardOpenOption.WRITE);
            ByteBuffer buffer02 = ByteBuffer.allocate(1024 * 1024 * 1024);
            aFileChannel02.read(buffer02, 0, buffer02, new CompletionHandler<Integer, ByteBuffer>() {
                @Override
                public void completed(Integer result, ByteBuffer attachment) {
                    attachment.flip();
                    System.out.println(attachment.position());
                    System.out.println(attachment.limit());
                }

                @Override
                public void failed(Throwable exc, ByteBuffer attachment) {

                }
            });
            System.out.println(buffer02.position());
            System.in.read();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
