package org.practice.cheguo.utils;

import org.apache.commons.lang.StringUtils;

/**
 * @author yoong
 */
public class CommonUtils {

    /**
     * Java隐藏手机号中间四位
     * PS：个人信息加密(脱敏)
     * https://blog.csdn.net/hekewangzi/article/details/50905098
     *
     * @param clearText  明文
     * @param encodeType 明文类型，1 手机号、2 身份证号码、3 银行卡号
     * @return
     */
    public static String encode(String clearText, int encodeType) {
        String ciphterText = StringUtils.EMPTY;
        if (StringUtils.isEmpty(clearText)) {
            return ciphterText;
        }
        // 手机号加密
        if (encodeType == 1) {
            if (clearText.length() < 11) {
                return ciphterText;
            }
            ciphterText = clearText.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");// 152****4799
            return ciphterText;
        }
        // 身份证号码加密
        else if (encodeType == 2) {
            if (clearText.length() < 18) {
                return ciphterText;
            }
            ciphterText = clearText.replaceAll("(\\d{4})\\d{10}(\\w{4})", "$1*****$2");// 4304*****7733
            return ciphterText;
        }
        // 银行卡号加密
        else if (encodeType == 3) {
            if (clearText.length() < 8) {
                return ciphterText;
            }
            int size = clearText.length() - 8;
            ciphterText = clearText.replaceAll("(\\d{4})\\d{" + size + "}(\\w{4})", "$1*****$2");// 4304*****7733
            return ciphterText;
        }
        return ciphterText;
    }
}
