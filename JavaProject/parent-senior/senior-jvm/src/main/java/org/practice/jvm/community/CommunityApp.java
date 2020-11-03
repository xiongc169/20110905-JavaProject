package org.practice.jvm.community;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Desc CommunityApp
 * <p>
 * @Author yoong
 * <p>
 * @Date 2016-04-01 09:00:00
 * <p>
 * @Version 1.0
 */
public class CommunityApp {

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");
    private static String url1 = "http://jdvodbo3swdrr.vod.126.net/jdvodbo3swdrr/59198670-59e1-470c-b3f1-cd5ddf12caf3.mp4";
    private static String url2 = "http://jdvodbo3swdrr.vod.126.net/jdvodbo3swdrr/38ea6328-0580-4df6-8b43-720627c79a9a.mp4";

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            download(url1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 最大堆内存设置为500M：-Xmx500m
     */
    public static void download(String urlStr) throws Exception {
        List<byte[]> byteList = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buffers = new byte[1024 * 1024];
            URL url = new URL(urlStr);
            InputStream inputStream = url.openStream();
            int length = 0;
            while ((length = inputStream.read(buffers)) != -1) {
                byteArrayOutputStream.write(buffers, 0, length);
            }
            byte[] bytes = byteArrayOutputStream.toByteArray();
            byteList.add(bytes);
            System.out.printf("%s: download-%s, length: %s\r\n", format.format(new Date()), i, bytes.length);
        }
    }
}
