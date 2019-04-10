package org.practice.primary.encrypt;

public class App {

    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            descTest();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void descTest() {
        try {
            // 20171019：i=事件Id、n=事件编号、c=客户编号、k=加密串、u=时间
            String strKey = "a1508727422299cd";// 长度要求16位
            String eventId = "201711022053495460671765";
            String eventNo = "SJ201711020092";
            String customerId = "201605201416001000002467";
            byte[] strKeyBytes = DesUtil.hex2byte(strKey);
            String i = DesUtil.encrypt(eventId, strKeyBytes);
            String n = DesUtil.encrypt(eventNo, strKeyBytes);
            String c = DesUtil.encrypt(customerId, strKeyBytes);
            System.out.println(i);
            System.out.println(n);
            System.out.println(c);

            String eventIdCipher = "2D7491D4115FE4748707366F8428768BC10FC834C53B0DB9E8199D8FC5C53FC0";
            String eventNoCipher = "AFAC14427B05107D65584F74818C9153";
            String customerIdCipher = "F3B25A15C2171FA47815B67242C18C6C1B09F645C1E9B20FE8199D8FC5C53FC0";
            System.out.println("eventId: " + DesUtil.decrypt(eventIdCipher, strKeyBytes));
            System.out.println("eventNo: " + DesUtil.decrypt(eventNoCipher, strKeyBytes));
            System.out.println("customerId: " + DesUtil.decrypt(customerIdCipher, strKeyBytes));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
