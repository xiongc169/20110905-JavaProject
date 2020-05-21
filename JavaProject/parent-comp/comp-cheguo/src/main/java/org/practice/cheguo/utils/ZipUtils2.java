package org.practice.cheguo.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * @Desc ZipUtils2
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018年3月30日
 * <p>
 * @Version 1.0
 */
public class ZipUtils2 {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            byte[] zipByte;
            zipByte = FileUtils.fileToBytes("E:\\test2.zip");
            byte[] pdfByte = uncompress(zipByte);
            FileUtils.bytesToFile(pdfByte, "E:\\", "1234.pdf");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 使用GZIPInputStream进行GZIP解压缩
     */
    public static byte[] uncompress(byte[] bytes) {
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        ZipInputStream zip = null;
        ByteArrayOutputStream out = null;
        try {
            zip = new ZipInputStream(in);
            out = new ByteArrayOutputStream();
            ZipEntry entry;
            while ((entry = zip.getNextEntry()) != null && !entry.isDirectory()) {
                int n;
                byte[] buffer = new byte[256];
                while ((n = zip.read(buffer, 0, buffer.length)) >= 0) {
                    out.write(buffer, 0, n);
                }
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(in, zip, out);
        }
        return out.toByteArray();
    }

    /**
     * 关闭流
     */
    private static void close(Closeable... closeableList) {
        if (closeableList != null) {
            for (Closeable closeable : closeableList) {
                if (closeable != null) {
                    try {
                        closeable.close();
                    } catch (IOException e) {
                    }
                }
            }
        }
    }
}
