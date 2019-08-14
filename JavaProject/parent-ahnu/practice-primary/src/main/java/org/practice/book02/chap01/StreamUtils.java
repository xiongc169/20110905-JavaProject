package org.practice.book02.chap01;

import java.io.*;
import java.util.Properties;

/**
 * @Desc 《Java核心技术·卷2·高级特性·第9版》
 * 第一章、流与文件
 * @Author
 * @Date
 * @Version 1.0
 */
public class StreamUtils {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            String file = "D:\\home\\upload\\report.txt";
            String dest = "D:\\home\\upload\\report2.txt";

            //1.1.1、读写字节
            String srcPath = "D:\\home\\upload\\5f9d5038-a73f-4e84-8050-3ae187585f01.mp4";
            byte[] bytes = readBytes(srcPath);
            String destPath = "D:\\home\\upload\\5f9d5038-a73f-4e84-8050-3ae187585f02.mp4";
            writeBytes(destPath, bytes);

            //1.1.3、组合流过滤器
            String userDir = System.getProperty("user.dir");
            Properties properties = System.getProperties();
            System.out.println(userDir);
            System.out.println(properties.size());
            composedStream(file);

            //1.2.1、文本输出
            writer(dest, "Java");
            reader(dest);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 1.1.1、读写字节
     */
    public static byte[] readBytes(String filePath) {
        try {
            FileInputStream smallStream = new FileInputStream("D:\\home\\upload\\small.txt");
            //FileInputStream smallStream = new FileInputStream(filePath);
            int smallAvailable = smallStream.available();
            System.out.println(smallAvailable);
            for (int i = 0; i < 10; i++) {
                System.out.println(smallStream.read());
                System.out.println(smallStream.available());
            }

            ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int n = 0;
            while ((n = smallStream.read(buffer)) != -1) {
                byteOutput.write(buffer, 0, n);
            }
            byte[] result = byteOutput.toByteArray();
            System.out.println(result.length);

            FileInputStream reportStream = new FileInputStream("D:\\home\\upload\\report.txt");
            FileInputStream videoStream = new FileInputStream(filePath);

            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * 1.1.1、读写字节
     */
    public static byte[] writeBytes(String path, byte[] bytes) {
        try {
            File destFile = new File(path);
            if (!destFile.exists()) {
                destFile.createNewFile();
            }
            FileOutputStream videoStream = new FileOutputStream(path);
            videoStream.write(bytes);
            videoStream.flush();
            videoStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * 1.1.3、组合流过滤器
     */
    public static void composedStream(String filePath) {
        try {
            FileInputStream fileStream = new FileInputStream(filePath);
            int result = fileStream.read();
            System.out.println(result);

            DataInputStream dataStream = new DataInputStream(fileStream);
            Integer result1 = dataStream.readInt();
            System.out.println(result1);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 1.2.1、文本输出
     */
    public static void writer(String filePath, String content) throws Exception {
        File dest = new File(filePath);
        if (!dest.exists()) {
            dest.createNewFile();
        }
        Writer fileWriter = new FileWriter(filePath);

        PrintWriter printWriter = new PrintWriter(dest);
        printWriter.append(content);
        printWriter.flush();

        InputStreamReader reader = new InputStreamReader(System.in);
        OutputStreamWriter writer2 = new OutputStreamWriter(System.out);
    }

    /**
     * 1.2.2、文本输入
     */
    public static void reader(String filePath) throws Exception {
        char[] buffer = new char[4096];
        Reader fileReader = new FileReader(filePath);
        Reader stringReader = new StringReader(filePath);
        int n = 0;
        while ((n = fileReader.read(buffer)) != -1) {
            System.out.println("aa: " + buffer);
        }
    }

    /**
     * 1.6、操作文件
     */
    public static void fileTest() {
        File report = new File("D:\\home\\upload2");
        System.out.println("report.isDirectory() " + report.isDirectory());
        System.out.println("report.isFile() " + report.isFile());
        System.out.println("report.exists() " + report.exists());
        if (!report.exists()) {
            boolean result = report.mkdir();
            System.out.println("report.mkdir() " + result);
        }
    }
}
