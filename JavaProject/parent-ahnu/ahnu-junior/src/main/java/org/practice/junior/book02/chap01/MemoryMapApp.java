package org.practice.junior.book02.chap01;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.zip.CRC32;

/**
 * @Desc 《Java核心技术·卷2·高级特性·第9版》1.7、内存映射文件
 * https://www.jb51.net/books/328275.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2015年6月25日
 * <p>
 * @Version 1.0
 */
public class MemoryMapApp {

    private static String filePath = "D:\\Temp\\IO";

    private static String txtFileName = "D:\\Temp\\IO\\abc.txt";
    private static String txtFileName01 = "D:\\Temp\\IO\\abc01.txt";

    private static String zipFileName = "D:\\Temp\\IO\\xyz.zip";
    private static String zipFileName01 = "D:\\Temp\\IO\\xyz01.zip";

    //fileSize = 2.5M, checksum = 558886614, cost = 5605\48\4757\32
    private static String mp4FileName = "D:\\Temp\\IO\\video.mp4";
    private static String mp4FileName01 = "D:\\Temp\\IO\\video01.mp4";
    private static String mp4FileName02 = "D:\\Temp\\IO\\video02.mp4";

    private static String videoUrl = "http://img.fincs.net/zahy/cls/loan/2019/12/20/a911bc41-90ca-4d5b-b731-f8f1f49f5d1a.mp4";
    private static String videoUrl01 = "http://img.fincs.net/zahy/cls/loan/2019/12/20/4a8a3491-26bc-4a0a-bc58-99a49cc95d45.mp4";
    private static String videoUrl02 = "http://img.fincs.net/zahy/cls/loan/2019/12/6/cca9b111-feba-4129-b4f2-0fcdca8d4635.mp4";
    private static String videoUrl03 = "http://img.fincs.net/zahy/cls/loan/2019/12/6/5ac5a802-9085-484c-9e53-9f32f1816f31.mp4";

    //fileSize = 60.3M, checksum = 3592482099, cost = 116012\354\113710\279
    private static String rtJar = "D:\\Program Files\\Java\\jdk1.8.0_112\\jre\\lib\\rt.jar";//60.3M

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            //1.7、内存映射文件
            long start1 = System.currentTimeMillis();
            checksumInputStream();
            long span1 = System.currentTimeMillis() - start1;
            System.out.println("checksumInputStream: " + span1);

            long start2 = System.currentTimeMillis();
            checksumBufferInputStream();
            long span2 = System.currentTimeMillis() - start2;
            System.out.println("checksumBufferInputStream: " + span2);

            long start3 = System.currentTimeMillis();
            checksumRandomAccessFile();
            long span3 = System.currentTimeMillis() - start3;
            System.out.println("checksumRandomAccessFile: " + span3);

            long start4 = System.currentTimeMillis();
            checksumMemoryMappedFile();
            long span4 = System.currentTimeMillis() - start4;
            System.out.println("checksumMemoryMappedFile: " + span4);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Long checksumInputStream() throws IOException {
        CRC32 crc32 = new CRC32();
        try (FileInputStream fileInputStream = new FileInputStream(rtJar)) {
            int bytee = -1;
            while ((bytee = fileInputStream.read()) != -1) {
                crc32.update(bytee);
            }
            System.out.println("checksumInputStream: " + crc32.getValue());
            return crc32.getValue();
        }
    }

    public static Long checksumBufferInputStream() throws IOException {
        CRC32 crc32 = new CRC32();
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(rtJar))) {
            int bytee = -1;
            while ((bytee = bufferedInputStream.read()) != -1) {
                crc32.update(bytee);
            }
            System.out.println("checksumBufferInputStream: " + crc32.getValue());
            return crc32.getValue();
        }
    }

    public static Long checksumRandomAccessFile() throws IOException {
        CRC32 crc32 = new CRC32();
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(rtJar, "r")) {
            int bytee = -1;
            while ((bytee = randomAccessFile.read()) != -1) {
                crc32.update(bytee);
            }
            System.out.println("checksumRandomAccessFile: " + crc32.getValue());
            return crc32.getValue();
        }
    }

    public static Long checksumMemoryMappedFile() throws IOException {
        CRC32 crc32 = new CRC32();
        try (FileChannel fileChannel = FileChannel.open(Paths.get(rtJar), StandardOpenOption.READ)) {
            MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());
            while (mappedByteBuffer.hasRemaining()) {
                crc32.update(mappedByteBuffer.get());
            }
            //Error
            //int bytee = -1;
            //while ((bytee = mappedByteBuffer.get()) != -1) {
            //    crc32.update(bytee);
            //}
            System.out.println("checksumMemoryMappedFile: " + crc32.getValue());
            return crc32.getValue();
        }
    }
}
