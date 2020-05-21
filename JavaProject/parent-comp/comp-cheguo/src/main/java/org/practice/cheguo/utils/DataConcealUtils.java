package org.practice.cheguo.utils;

import org.apache.commons.lang.StringUtils;

/**
 * @Desc 数据脱敏
 * https://www.jianshu.com/p/d54a970c251a
 * https://baike.baidu.com/item/%E6%95%B0%E6%8D%AE%E8%84%B1%E6%95%8F/7914656
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018年1月15日
 * <p>
 * @Version 1.0
 */
public class DataConcealUtils {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            String phone = "18668161992";
            String idCard = "342501199111122014";
            String bankCardNo1 = "6226621702371731";
            String bankCardNo = "6228481990677155518";

            String resultPhone = dataConceal(phone, 1);
            String resultId = dataConceal(idCard, 2);
            String resultBankCard = dataConceal(bankCardNo1, 3);

            System.out.println(resultPhone);
            System.out.println(resultId);
            System.out.println(resultBankCard);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Java隐藏手机号中间四位
     * PS：个人信息加密(脱敏)
     * https://blog.csdn.net/hekewangzi/article/details/50905098
     */
    public static String dataConceal(String clearText, int encodeType) {
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
