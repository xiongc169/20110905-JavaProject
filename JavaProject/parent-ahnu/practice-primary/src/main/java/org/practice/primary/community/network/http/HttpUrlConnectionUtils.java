package org.practice.primary.community.network.http;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Desc HttpUrlConnectionUtils
 * @Author
 * @Date
 * @Version 1.0
 */
public class HttpUrlConnectionUtils {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            String uri = "http://zacdn-image.cgw360.com/cgw360/cls/credit/603a4e09-77e5-44ad-b096-d02ff2384d2f.jpg";
            get(uri);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void get(String uri) throws Exception {
        URL url = new URL(uri);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        FileOutputStream fOutStream = new FileOutputStream("D:\\aa.jpg");
        if (conn.getResponseCode() == 200) {
            InputStream ins = conn.getInputStream();
            byte[] buffer = new byte[4096];
            int n = 0;
            while ((n = ins.read(buffer)) != -1) {
                byteStream.write(buffer, 0, n);
            }
            byte[] result = byteStream.toByteArray();
            fOutStream.write(result);
            fOutStream.flush();
        }
    }
}
