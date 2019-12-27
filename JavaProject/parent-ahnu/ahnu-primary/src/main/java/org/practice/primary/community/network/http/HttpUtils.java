package org.practice.primary.community.network.http;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Desc HttpURLConnection与HttpClient浅析
 * PS：GET、POST区别；
 * JDK的java.net包中提供了HTTP协议的基本功能类：HttpUrlConnection，继承自URLConnection；
 * Apache提供了HttpClient，更好的处理Web请求，如Session、Cookie等细节；
 * https://blog.csdn.net/u012838207/article/details/82867701
 * http://www.cnblogs.com/sharpest/p/7831350.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2019年3月14日19:56:57
 * <p>
 * @Version 1.0
 */
public class HttpUtils {

    private static String uri = "http://zacdn-image.cgw360.com/cgw360/cls/credit/603a4e09-77e5-44ad-b096-d02ff2384d2f.jpg";
    private static String filePath = "D:\\Temp\\IO\\image01.jpg";

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            httpUrlConnectionDemo();
            httpClientDemo();
            download(uri, filePath);
            download2(uri, filePath);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * HttpURLConnection GET
     */
    public static void httpUrlConnectionDemo() throws Exception {
        String local = "http://127.0.0.1:8095/push/login";
        String baidu = "http://www.baidu.com";
        String imgUrl = "http://zacdn-image.cgw360.com/cgw360/cls/credit/603a4e09-77e5-44ad-b096-d02ff2384d2f.jpg";

        URL url = new URL(baidu);
        URLConnection conn1 = url.openConnection();
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.connect();
        int code = conn.getResponseCode();
        if (code == 200) {
            //InputStream in = conn.getInputStream();
            // 从流中读取响应信息
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            StringBuilder result = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                result.append(line + "\r\n");
            }
            System.out.println(result.toString());
            reader.close();
            conn.disconnect();
        }
    }

    /**
     * HttpClient
     */
    public static void httpClientDemo() throws Exception {
        String local = "http://127.0.0.1:8095/push/login";
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(local);
        CloseableHttpResponse httpResponse = null;
        httpResponse = httpClient.execute(httpGet);
        System.out.println(httpResponse.getStatusLine());
        HttpEntity entity = httpResponse.getEntity();// 5. 处理响应实体
        if (entity != null) {
            System.out.println("长度：" + entity.getContentLength());
            System.out.println("内容：" + EntityUtils.toString(entity));
        }
        httpResponse.close();
        httpClient.close();
    }

    /**
     * download
     */
    public static void download(String uri, String destFilePath) throws Exception {
        URL url = new URL(uri);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        FileOutputStream fOutStream = new FileOutputStream(destFilePath);
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

    /**
     * download2
     */
    public static void download2(String uri, String destFilePath) throws Exception {
        File file = new File(destFilePath);
        URL url = new URL(uri);
        FileUtils.copyURLToFile(url, file);
    }
}