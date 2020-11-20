package org.practice.junior.community.encrypt;

import java.io.IOException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import sun.misc.BASE64Decoder;

/**
 * @Desc EncryptUtility.java
 * <p>
 * @Author yoong
 * <p>
 * @Date 2016年5月27日 下午4:42:51
 * <p>
 * @Version 1.0
 */
public class RSAUtility {

    /**
     * RSA加密方式
     */
    static String RSA = "RSA";

    /**
     * 公钥
     */
    static String key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCA5xCau7f76VPU+DNxDBLyJkpCnfT8IxSi024rAqc+psStGWLLMN0LHhet8zdpZ1wtltAycEZLZnwdQiCWCTMdHX7YExWqXBQjQhkJf9njKxom5T9cDIY06Z8Vl+pvLTK4RmjMLLJAcRzu40Ifq8G2jobK3k2g2dUKHFj0sfvjfQIDAQAB";

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            String result = encryptPublic("!25sAqe849qwezd", key);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @date 2016年5月27日 下午4:47:04
     */
    private static String byteArr2HexStr(byte[] arrB) throws Exception {
        int iLen = arrB.length;
        // 每个byte用两个字符才能表示，所以字符串的长度是数组长度的两倍
        StringBuffer sb = new StringBuffer(iLen * 2);
        for (int i = 0; i < iLen; i++) {
            int intTmp = arrB[i];
            // 把负数转换为正数
            while (intTmp < 0) {
                intTmp = intTmp + 256;
            }
            // 小于0F的数需要在前面补0
            if (intTmp < 16) {
                sb.append("0");
            }
            sb.append(Integer.toString(intTmp, 16));
        }
        return sb.toString();
    }

    /**
     * @param key 公钥：MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCA5xCau7f76VPU+DNxDBLyJkpCnfT8IxSi024rAqc+psStGWLLMN0LHhet8zdpZ1wtltAycEZLZnwdQiCWCTMdHX7YExWqXBQjQhkJf9njKxom5T9cDIY06Z8Vl+pvLTK4RmjMLLJAcRzu40Ifq8G2jobK3k2g2dUKHFj0sfvjfQIDAQAB
     * @date 2016年5月27日 下午4:47:10
     */
    private static PublicKey getPublicKey(String key) throws Exception {
        byte[] keyBytes = decryptBase64(key);

        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA);
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        return publicKey;
    }

    /**
     * @param str 待加密串，如密码：!25sAqe849qwezd
     * @param key 公钥，如：MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCA5xCau7f76VPU+DNxDBLyJkpCnfT8IxSi024rAqc+psStGWLLMN0LHhet8zdpZ1wtltAycEZLZnwdQiCWCTMdHX7YExWqXBQjQhkJf9njKxom5T9cDIY06Z8Vl+pvLTK4RmjMLLJAcRzu40Ifq8G2jobK3k2g2dUKHFj0sfvjfQIDAQAB
     * @date 2016年5月27日 下午4:47:16
     */
    public static String encryptPublic(String str, String key) throws Exception {
        /** 得到Cipher对象来实现对源数据的RSA加密 */
        PublicKey publicKey = getPublicKey(key);
        Cipher cipher = Cipher.getInstance(RSA);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] b = str.getBytes();
        /** 执行加密操作 */
        byte[] b1 = cipher.doFinal(b);
        String encoder = byteArr2HexStr(b1);
        return encoder;
    }

    private static byte[] decryptBase64(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] bytes = null;
        try {
            bytes = decoder.decodeBuffer(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }
}
