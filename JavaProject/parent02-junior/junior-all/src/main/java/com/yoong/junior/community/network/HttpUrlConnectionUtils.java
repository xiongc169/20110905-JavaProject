package com.yoong.junior.community.network;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * @Desc HttpURLConnection 网络编程
 * <p>
 * @Author yoong
 * <p>
 * @Date 2020年9月24日
 * <p>
 * @Version 1.0
 */
public class HttpUrlConnectionUtils {

    private static final String UTF_8 = "UTF-8";

    private static final String ContentType = "Content-Type";

    private static final String ApplicationJson = "application/json";

    private static final String FormData = "application/x-www-form-urlencoded";

    /**
     * Get方法
     */
    public static String get(String url) {
        HttpURLConnection conn = null;
        InputStream inputStream = null;
        String response = null;
        try {
            URL myUrl = new URL(url);
            conn = (HttpURLConnection) myUrl.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(30000);
            conn.setReadTimeout(30000);
            conn.connect();
            int responseCode = conn.getResponseCode();
            inputStream = conn.getInputStream();
            response = IOUtils.toString(inputStream, "UTF-8");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (conn != null) {
                    conn.disconnect();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return response;
    }

    /**
     * Post方法
     */
    public static String postJSON(String url, String params) {
        HttpURLConnection conn = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        String response = null;
        try {
            URL myUrl = new URL(url);
            conn = (HttpURLConnection) myUrl.openConnection();
            conn.setRequestMethod("POST");
            conn.setConnectTimeout(30000);
            conn.setReadTimeout(30000);
            conn.setDoOutput(true);
            conn.setRequestProperty(ContentType, ApplicationJson);
            conn.connect();
            outputStream = conn.getOutputStream();
            outputStream.write(params.getBytes());
            int responseCode = conn.getResponseCode();
            inputStream = conn.getInputStream();
            response = IOUtils.toString(inputStream, "UTF-8");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (conn != null) {
                    conn.disconnect();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return response;
    }

    /**
     * Post方法
     */
    public static String postFormData(String url, Map<String, String> params) throws Exception {
        HttpURLConnection conn = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        String response = null;
        try {
            URL myUrl = new URL(url);
            conn = (HttpURLConnection) myUrl.openConnection();
            conn.setRequestMethod("POST");
            conn.setConnectTimeout(30000);
            conn.setReadTimeout(30000);
            conn.setRequestProperty(ContentType, FormData);
            conn.setDoOutput(true);
            conn.connect();
            outputStream = conn.getOutputStream();
            StringBuilder paramStr = new StringBuilder();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                paramStr.append(entry.getKey() + "=" + entry.getValue() + "&");
            }
            outputStream.write(paramStr.toString().getBytes());
            int responseCode = conn.getResponseCode();
            inputStream = conn.getInputStream();
            response = IOUtils.toString(inputStream, "UTF-8");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (conn != null) {
                    conn.disconnect();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return response;

    }

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            Charset charset = Charset.forName(UTF_8);

            //String url = "http://localhost:8085/user/login?name=123456";
            //get(url);
            //
            //String url02 = "http://localhost:8085/user/register?userName=name01&password=password01";
            //get(url02);

            //服务端用 @RequestBody 标注入参
            //String url03 = "http://localhost:8085/user/register";
            //String paramJson = "{\"userName\":\"userName01\",\"password\":\"password01\"}";
            //postJSON(url03, paramJson);

            //服务端不用 @RequestBody 标注入参
            String url04 = "http://localhost:8085/user/logout";
            HashMap<String, String> paramMap = new HashMap();
            paramMap.put("userName", "userName01");
            paramMap.put("password", "password01");
            postFormData(url04, paramMap);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
