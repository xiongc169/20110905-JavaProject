package org.practice.primary.community.encrypt;

import java.security.Security;
import java.util.Date;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author yoong
 * <p>
 * @version 1.0
 * <p>
 * @desc 使用DES算法实现加密和解密
 * http://blog.csdn.net/lisheng19870305/article/details/68944485
 * HexUtil工具类
 * http://www.cnblogs.com/wangbogo/archive/2012/07/10/2584506.html
 * http://www.cnblogs.com/supperwu/archive/2012/05/22/2512877.html
 * .NET版本
 * <p>
 * @date 2012年4月2日
 */
public class DesUtil {

    private static final String Algorithm = "DES"; // 定义 加密算法,可用:DES,DESede,Blowfish

    /**
     * 入口函数
     */
    public static void main(String arg[]) {
        String strKey1 = "a" + String.valueOf((new Date()).getTime()) + "cd";
        String str = "20091113110733558370857489968539";
        String s3 = encrypt(str, hex2byte(strKey1));
        String s4 = decrypt(s3, hex2byte(strKey1));
        System.out.println(strKey1);
        System.out.println(s3);
        System.out.println(s4);
    }

    // 加密！！！！！！
    public static String encrypt(String str, byte[] key) {
        Security.addProvider(new com.sun.crypto.provider.SunJCE());
        byte[] encrypt = encryptMode(key, str.getBytes());
        return byte2hex(encrypt);
    }

    // 加密
    public static byte[] EncryptRetByte(byte[] src, byte[] key) {
        Security.addProvider(new com.sun.crypto.provider.SunJCE());
        byte[] encrypt = encryptMode(key, src);
        return encrypt;
    }

    // 解密！！！！！！
    public static String decrypt(String str, byte[] key) {
        Security.addProvider(new com.sun.crypto.provider.SunJCE());
        byte[] decrypt = decryptMode(key, hex2byte(str));
        return new String(decrypt);
    }

    // src为被加密的数据缓冲区（源）
    public static byte[] encryptMode(byte[] keybyte, byte[] src) {
        try {
            // 生成密钥
            SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);
            // 加密
            Cipher c1 = Cipher.getInstance(Algorithm);
            c1.init(Cipher.ENCRYPT_MODE, deskey);
            return c1.doFinal(src);
        } catch (java.security.NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        } catch (javax.crypto.NoSuchPaddingException e2) {
            e2.printStackTrace();
        } catch (java.lang.Exception e3) {
            e3.printStackTrace();
        }
        return null;
    }

    // keybyte为加密密钥，长度为24字节
    // src为加密后的缓冲区
    public static byte[] decryptMode(byte[] keybyte, byte[] src) {
        try {
            // 生成密钥
            SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);
            // 解密
            Cipher c1 = Cipher.getInstance(Algorithm);
            c1.init(Cipher.DECRYPT_MODE, deskey);
            return c1.doFinal(src);
        } catch (java.security.NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        } catch (javax.crypto.NoSuchPaddingException e2) {
            e2.printStackTrace();
        } catch (java.lang.Exception e3) {
            e3.printStackTrace();
        }
        return null;
    }

    // 转换成十六进制字符串
    public static String byte2hex(byte[] b) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1)
                hs = hs + "0" + stmp;
            else
                hs = hs + stmp;
            if (n < b.length - 1)
                hs = hs + "";
        }
        return hs.toUpperCase();
    }

    // 16 进制 转 2 进制
    public static byte[] hex2byte(String hex) throws IllegalArgumentException {
        if (hex.length() % 2 != 0) {
            throw new IllegalArgumentException();
        }
        char[] arr = hex.toCharArray();
        byte[] b = new byte[hex.length() / 2];
        for (int i = 0, j = 0, l = hex.length(); i < l; i++, j++) {
            String swap = "" + arr[i++] + arr[i];
            int byteint = Integer.parseInt(swap, 16) & 0xFF;
            b[j] = new Integer(byteint).byteValue();
        }
        return b;
    }

    public static byte[] hex2byte(byte[] b) {
        if ((b.length % 2) != 0)
            throw new IllegalArgumentException("长度不是偶数");
        byte[] b2 = new byte[b.length / 2];
        for (int n = 0; n < b.length; n += 2) {
            String item = new String(b, n, 2);
            b2[n / 2] = (byte) Integer.parseInt(item, 16);
        }
        return b2;
    }
}
