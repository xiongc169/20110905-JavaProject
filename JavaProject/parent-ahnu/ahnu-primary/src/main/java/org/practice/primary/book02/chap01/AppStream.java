package org.practice.primary.book02.chap01;

import java.io.*;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Scanner;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * @Desc 《Java核心技术·卷2·高级特性·第9版》第一章、流与文件
 * PS：标准的IO(BIO)基于字节流、字符流(Stream)进行操作的，而NIO是基于通道(Channel)、缓冲区(Buffer)进行操作；
 * <p>
 * @Author yoong
 * <p>
 * @Date 2015年6月25日
 * <p>
 * @Version 1.0
 */
public class AppStream {

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
            //1.1.1、读写字节
            byte[] bytes = inputStream0101(txtFileName);
            outputStream0101(bytes, mp4FileName01);

            //1.1.3、组合流过滤器
            String userDir = System.getProperty("user.dir");
            Properties properties = System.getProperties();
            System.out.println("userDir  " + userDir);
            System.out.println("properties.size  " + properties.size());
            composedStream0101(txtFileName);

            //1.2.1、文本输出
            reader0102(txtFileName);
            writer0102(txtFileName01, "Java");

            //1.6、文件操作
            fileTest0106(txtFileName);

            systemIn();
            download(videoUrl, mp4FileName01, mp4FileName02);
            download02(videoUrl, mp4FileName01);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 1.1.1、读写字节(字节流)
     * PS：文件读取为字节数组
     */
    public static byte[] inputStream0101(String filePath) {
        try {
            //TODO: 输入流实现类
            FileInputStream fileInputStream = new FileInputStream(filePath);
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            PushbackInputStream pushbackInputStream = new PushbackInputStream(fileInputStream);
            byte[] buf = new byte[4096];
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(buf);

            //获取文件大小，单位：字节Byte/1024 = KB/1024 = MB
            int available = fileInputStream.available();
            System.out.println("available  " + available);
            for (int i = 0; i < 10; i++) {
                System.out.println(fileInputStream.read());
                System.out.println(fileInputStream.available());
            }

            //文件读取为字节数组
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            //1024 * 1024 Byte = 1024 KB = 1MB
            byte[] buffer = new byte[1024 * 1024];
            int n = 0;
            while ((n = fileInputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, n);
            }
            byte[] result = byteArrayOutputStream.toByteArray();
            System.out.println("result.length  " + result.length);

            //关闭输入流
            byteArrayOutputStream.close();
            fileInputStream.close();
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * 1.1.1、读写字节(字节流)
     * PS：字节数组输出到文件
     */
    public static void outputStream0101(byte[] bytes, String destPath) {
        try {
            File destFile = new File(destPath);
            if (!destFile.exists()) {
                destFile.createNewFile();
            }
            //TODO: 输出流实现类
            FileOutputStream fileOutputStream = new FileOutputStream(destPath);
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);

            //字节数组输出到文件
            fileOutputStream.write(bytes);
            fileOutputStream.flush();
            //关闭输出流
            fileOutputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 1.1.3、组合流过滤器
     */
    public static void composedStream0101(String filePath) {
        try {
            //文本内容为：abcdefghijklmnopqrstuvwxyz
            FileInputStream fileInputStream = new FileInputStream(filePath);
            //int result = fileInputStream.read();//a=97
            //System.out.println("result  " + result);

            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            //Integer result1 = dataInputStream.readInt();//1633837924
            //System.out.println("result1  " + result1);
            //char char1 = dataInputStream.readChar();//慢
            //System.out.println("char1  " + char1);
            String line = dataInputStream.readLine();//abcdefghijklmnopqrstuvwxyz
            System.out.println("line  " + line);

            dataInputStream.close();
            fileInputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 1.2.2、文本输入(字符流)
     * PS：StringReader\FileReader\InputStreamReader
     */
    public static void reader0102(String filePath) throws Exception {
        //TODO: Reader实现类
        StringReader stringReader = new StringReader(filePath);
        FileReader fileReader = new FileReader(filePath);
        InputStreamReader streamReader = new InputStreamReader(new FileInputStream(filePath), "UTF-8");
        char[] charBuff = new char[4096];
        CharArrayReader charArrayReader = new CharArrayReader(charBuff);

        //System.out.println(stringReader.read());
        char[] charBuffer = new char[4096];
        int length = stringReader.read(charBuffer);
        String result = new String(charBuffer, 0, length);
        System.out.println("result1: " + result);//filePath的值

        char[] charBuffer2 = new char[4096];
        int length2 = fileReader.read(charBuffer2);
        String result2 = new String(charBuffer2, 0, length2);
        System.out.println("result2: " + result2);//filePath的文本的内容

        char[] charBuffer3 = new char[4096];
        int length3 = streamReader.read(charBuffer3);
        String result3 = new String(charBuffer3, 0, length3);
        System.out.println("result3: " + result3);//filePath的文本的内容
    }

    /**
     * 1.2.1、文本输出(字符流)
     */
    public static void writer0102(String filePath, String content) throws Exception {
        File dest = new File(filePath);
        if (!dest.exists()) {
            dest.createNewFile();
        }
        //TODO: Writer实现类
        StringWriter stringWriter = new StringWriter();
        FileWriter fileWriter = new FileWriter(filePath, true);
        OutputStreamWriter streamWriter = new OutputStreamWriter(new FileOutputStream(filePath), "UTF-8");
        PrintWriter printWriter = new PrintWriter(dest);
        CharArrayWriter charArrayWriter = new CharArrayWriter();

        char[] charBuffer = new char[4096];
        stringWriter.write(charBuffer);

        fileWriter.append("2019年8月15日10:25:40");
        fileWriter.flush();

        streamWriter.write("2019年8月16日10:25:40");
        streamWriter.flush();

        printWriter.append(content);
        printWriter.flush();
    }

    /**
     * 1.6、操作文件
     * PS：File、Path、Paths、Files
     */
    public static void fileTest0106(String txtFileName) throws Exception {
        File file = new File(txtFileName);
        System.out.println("report.isDirectory() " + file.isDirectory());
        System.out.println("report.isFile() " + file.isFile());
        System.out.println("report.exists() " + file.exists());
        if (file.isDirectory()) {
            boolean result = file.mkdir();
            System.out.println("file.mkdir() " + result);
        } else {
            boolean result = file.createNewFile();
            System.out.println("file.createNewFile() " + result);
        }

        Path path = Paths.get("D:", "Temp", "IO", "abc02.txt");
        boolean isDelete = Files.deleteIfExists(path);
        System.out.println("isDelete  " + isDelete);
        FileSystem fileSystem = path.getFileSystem();
        System.out.println(fileSystem.getSeparator());
    }

    /**
     * java中System.in和System.out快速学会使用
     * https://blog.csdn.net/qq_34173549/article/details/79671792
     * java从控制台获得输入
     * https://blog.csdn.net/joananjin/article/details/79418110
     */
    public static void systemIn() throws Exception {
        InputStream systemIn = System.in;
        PrintStream systemOut = System.out;
        //封装System.in，从控制台读取字符串
        BufferedReader reader = new BufferedReader(new InputStreamReader(systemIn));
        String line = reader.readLine();
        //调用System.out
        systemOut.println("line  " + line);
        systemOut.write(line.getBytes());
        //从控制台读取字符串
        Scanner scanner = new Scanner(System.in);
        String line2 = scanner.nextLine();
        System.out.println(line2);
    }

    /**
     * IO流【7】--- 通过IO流实现网络资源下载，通过URL地址下载图片等
     * https://blog.csdn.net/lexiaowu/article/details/98786701
     */
    public static void download(String srcVideo, String videoPath, String videoPath01) throws Exception {
        int n = 0;
        byte[] buffer = new byte[1024 * 1024];
        URL url = new URL(srcVideo);
        InputStream inputStream = new BufferedInputStream(url.openStream());
        //下载一
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while ((n = inputStream.read(buffer)) != -1) {
            byteArrayOutputStream.write(buffer, 0, n);
        }
        byte[] videoBytes = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();

        FileOutputStream video = new FileOutputStream(videoPath);
        video.write(videoBytes);
        video.close();

        //下载二：java.io.IOException: Resetting to invalid mark
        //inputStream.reset();
        //FileOutputStream video01 = new FileOutputStream(videoPath01);
        //while ((n = inputStream.read(buffer)) != -1) {
        //    video01.write(buffer, 0, n);
        //}
        //video01.close();
        inputStream.close();
    }

    /**
     * IO流【2】--- 文件拷贝/复制
     * https://blog.csdn.net/lexiaowu/article/details/98647923
     */
    public static void download02(String srcVideo, String videoPath) throws Exception {
        URL url = new URL(srcVideo);
        InputStream inputStream = url.openStream();
        FileOutputStream localVideo = new FileOutputStream(videoPath);
        byte[] buffer = new byte[1024 * 1024];
        int n = 0;
        while ((n = inputStream.read(buffer)) != -1) {
            localVideo.write(buffer, 0, n);
        }
        inputStream.close();
        localVideo.flush();
        localVideo.close();
    }
}
