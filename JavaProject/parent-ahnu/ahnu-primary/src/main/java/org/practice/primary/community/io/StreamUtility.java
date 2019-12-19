package org.practice.primary.community.io;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * @author Administrator
 */
public class StreamUtility {

    private static String filePath = "D:\\Temp\\IO";
    private static String fileName = "D:\\Temp\\IO\\abc.txt";
    private static String zipFileName = "D:\\Temp\\IO\\zip.zip";

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            inputStream();
            outputStream();
            reader();
            writer();
            zipStream();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void inputStream() throws IOException {
        InputStream inStream = new FileInputStream(fileName);
        inStream.read();

        InputStream keyboardIn = System.in;
        int in = keyboardIn.read();
    }

    public static void outputStream() {
        try {
            OutputStream outputStream = new FileOutputStream(fileName);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void reader() throws IOException {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferReader.readLine()) != null) {
            System.out.println(line);
        }
    }

    public static void writer() throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        PrintWriter printWriter = new PrintWriter(bufferedWriter);
        printWriter.println("abcdefg");
        printWriter.close();
    }

    public static void zipStream() {
        try {
            InputStream inputStream = new FileInputStream(zipFileName);
            ZipInputStream zipInputStream = new ZipInputStream(inputStream);
            ZipEntry entry = zipInputStream.getNextEntry();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
