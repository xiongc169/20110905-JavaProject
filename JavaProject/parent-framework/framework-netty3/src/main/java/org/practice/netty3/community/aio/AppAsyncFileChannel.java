package org.practice.netty3.community.aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Future;

/**
 * @Desc Java AIO基础
 * PS：Java AIO(异步IO)特性是在Java 7引入的。
 * AsynchronousFileChannel: 用于文件异步读写。
 * AsynchronousSocketChannel: 客户端异步socket。
 * AsynchronousServerSocketChannel: 服务器异步socket。
 * AsynchronousDatagramChannel: UDP异步Socket(jdk 7 b118已删除)。
 * https://www.jianshu.com/p/ba619a8ed32aJava
 * NIO 教程(十六) Java NIO AsynchronousFileChannel
 * PS：在Java 7中，AsynchronousFileChannel被添加到Java NIO。AsynchronousFileChannel使读取数据，并异步地将数据写入文件成为可能。
 * https://www.jianshu.com/p/b38f8c596193
 * <p>
 * @Author yoong
 * <p>
 * @Date 2016年4月6日20:26:23
 * <p>
 * @Version 1.0
 */
public class AppAsyncFileChannel {

    private static SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");

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
            //异步读取数据 + Future
            readByAsynchronousFileChannel();
            //异步读取数据 + CompletionHandler
            readByAsynchronousFileChannel02();
            //异步写入数据 + Future
            writeByAsynchronousFileChannel();
            //异步写入数据 + CompletionHandler
            writeByAsynchronousFileChannel02();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 异步读取数据 + Future
     */
    public static void readByAsynchronousFileChannel() throws Exception {
        Path path = Paths.get(txtFileName);
        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);
        //通过Future读取数据
        ByteBuffer buffer = ByteBuffer.allocate(1024 * 1024);
        //read()方法会立即返回，即使读操作还没有完成
        Future<Integer> operation = fileChannel.read(buffer, 0);
        while (!operation.isDone()) {
            System.out.println(sdFormat.format(new Date()) + " operation.isDone() " + operation.isDone());
            Thread.sleep(1000);
        }
        buffer.flip();
        byte[] data = new byte[buffer.limit()];
        buffer.get(data);
        System.out.println(new String(data));
        buffer.clear();
    }

    /**
     * 异步读取数据 + CompletionHandler
     */
    public static void readByAsynchronousFileChannel02() throws Exception {
        Path path = Paths.get(txtFileName);
        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);
        //通过一个CompletionHandler读取数据
        ByteBuffer buffer = ByteBuffer.allocate(1024 * 1024);
        //read()方法会立即返回，即使读操作还没有完成
        fileChannel.read(buffer, 0, buffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                System.out.println(sdFormat.format(new Date()) + " result: " + result);
                attachment.flip();
                byte[] data = new byte[attachment.limit()];
                attachment.get(data);
                System.out.println(sdFormat.format(new Date()) + " data: " + new String(data));
                attachment.clear();
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                System.out.println(sdFormat.format(new Date()) + " failed !!!");
            }
        });
        Thread.sleep(2000);
        System.out.println(sdFormat.format(new Date()) + " finished !!!");
    }

    /**
     * 异步写入数据 + Future
     */
    public static void writeByAsynchronousFileChannel() throws Exception {
        Path path = Paths.get(txtFileName);
        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        long position = 0;
        buffer.put("test data".getBytes());
        buffer.flip();
        Future<Integer> operation = fileChannel.write(buffer, position);
        buffer.clear();
        while (!operation.isDone()) ;
        System.out.println("Write done");
    }

    /**
     * 异步写入数据 + CompletionHandler
     */
    public static void writeByAsynchronousFileChannel02() throws Exception {
        Path path = Paths.get(txtFileName);
        if (!Files.exists(path)) {
            Files.createFile(path);
        }
        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        long position = 0;
        buffer.put("test data".getBytes());
        buffer.flip();
        fileChannel.write(buffer, position, buffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                System.out.println("bytes written: " + result);
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                System.out.println("Write failed");
                exc.printStackTrace();
            }
        });
    }
}
