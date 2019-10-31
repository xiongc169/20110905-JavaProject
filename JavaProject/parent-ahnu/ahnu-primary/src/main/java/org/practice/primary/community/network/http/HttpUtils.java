package org.practice.primary.community.network.http;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Desc HttpUtils
 * HttpURLConnection与HttpClient浅析
 * http://www.cnblogs.com/sharpest/p/7831350.html
 * @Author
 * @Date 2019年3月14日19:56:57
 * @Version 1.0
 */
public class HttpUtils {

    public static void main(String[] args) {
        try {
            //urlConnectionDemo();
            httpClientDemo();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    /**
     * @throws Exception
     */
    public static void urlConnectionDemo() throws Exception {
        String local = "http://127.0.0.1:8095/push/login";
        String imgUrl = "http://zacdn-image.cgw360.com/cgw360/cls/credit/603a4e09-77e5-44ad-b096-d02ff2384d2f.jpg";
        URL url = new URL(local);
        URLConnection conn1 = url.openConnection();
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.connect();
        int code = conn.getResponseCode();
        if (code == 200) {
            //InputStream in = conn.getInputStream();
            // 从流中读取响应信息
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            String result = "";
            while ((line = reader.readLine()) != null) {
                result += line;
            }
            System.out.println(result);
            reader.close();
            conn.disconnect();
        }
    }

    /**
     * @throws Exception
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

    public static void download() throws Exception {
        File file = new File("d:\\aa.jpg");
        URL url = new URL("http://zacdn-image.cgw360.com/cgw360/cls/credit/603a4e09-77e5-44ad-b096-d02ff2384d2f.jpg");
        FileUtils.copyURLToFile(url, file);
    }
}
