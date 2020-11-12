package org.practice.utils;

import com.alibaba.fastjson.JSON;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.Bucket;
import com.aliyun.oss.model.ObjectListing;

import java.util.List;

/**
 * @Desc 云存储客户端
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018年3月30日
 * <p>
 * @Version 1.0
 */
public class OSSUtils {

    private static String ZHONGAN_IMAGE_DOMAIN = "http://img.fincs.net/";
    private static String CHEGUO_IMAGE_DOMAIN = "http://img.fincs.net/";
    private static String NODE_HANGZHOU = "oss-cn-hangzhou.aliyuncs.com";
    private static String NODE_HANGZHOU_INTERNAL = "oss-cn-hzjbp-b-internal.aliyuncs.com";

    private static String accessKeyId = "******";
    private static String accessKeySecret = "******";

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            getBucket();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 快速入门
     * https://helpcdn.aliyun.com/document_detail/32011.html
     */
    public static void upload() {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = "<yourAccessKeyId>";
        String accessKeySecret = "<yourAccessKeySecret>";
        String bucketName = "<yourBucketName>";
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        // 创建存储空间。
        Bucket bucket = ossClient.createBucket(bucketName);
        System.out.println(JSON.toJSONString(bucket));
        // 关闭OSSClient。
        ossClient.shutdown();
    }

    /**
     * GetBucket
     * https://helpcdn.aliyun.com/document_detail/31965.html
     */
    public static void getBucket() {
        //Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://img.fincs.net";
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String bucketName = "test-za";
        String KeyPrefix = "00e4a38d-8d7d-f20d-4cbb-0b93bf1ed936image";

        //创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        //列举文件。 如果不设置KeyPrefix，则列举存储空间下所有的文件。KeyPrefix，则列举包含指定前缀的文件。
        ObjectListing objectListing = ossClient.listObjects(bucketName, KeyPrefix);
        List<com.aliyun.oss.model.OSSObjectSummary> sums = objectListing.getObjectSummaries();
        for (com.aliyun.oss.model.OSSObjectSummary s : sums) {
            System.out.println("\t" + s.getKey());
        }
        //关闭OSSClient。
        ossClient.shutdown();
    }
}
