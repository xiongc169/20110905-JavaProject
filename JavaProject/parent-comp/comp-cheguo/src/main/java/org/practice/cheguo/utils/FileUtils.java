package org.practice.cheguo.utils;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * https://www.cnblogs.com/DylanZ/p/6269042.html<br>
 * java 中 byte[]、File、InputStream 互相转换
 *
 * @author yoong
 */
public class FileUtils {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            byte[] bytes = fileToBytes("E:\\test2.zip");
            System.out.println(bytes.length);

            bytesToFile(bytes, "E:\\", "test3.zip");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 文件、字节数组转换
     * https://www.cnblogs.com/pcheng/p/6913535.html
     *
     * @param fileName
     * @return
     */
    public static byte[] fileToBytes(String fileName) {
        File file = new File(fileName);
        try {
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream(fis.available());
            byte[] buffer = new byte[100000];
            int n;
            while ((n = fis.read(buffer)) != -1) {
                bos.write(buffer, 0, n);
            }
            fis.close();
            byte[] data = bos.toByteArray();
            bos.close();
            return data;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void bytesToFile(byte[] bytes, String filePath, String fileName) {
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file = null;
        try {
            File dir = new File(filePath);
            if (!dir.exists() && dir.isDirectory()) {// 判断文件目录是否存在
                dir.mkdirs();
            }
            file = new File(filePath + "\\" + fileName);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 文件转换为数组
     * https://www.cnblogs.com/cnblogszs/p/6405403.html
     *
     * @param filePath
     * @return
     * @throws IOException
     */
    public static byte[] InputStream2ByteArray(String filePath) throws IOException {

        InputStream in = new FileInputStream(filePath);
        byte[] data = toByteArray(in);
        in.close();

        return data;
    }

    public static byte[] toByteArray(InputStream in) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024 * 4];
        int n = 0;
        while ((n = in.read(buffer)) != -1) {
            out.write(buffer, 0, n);
        }
        return out.toByteArray();
    }
}
