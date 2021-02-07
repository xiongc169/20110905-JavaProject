package com.yoong.hundsun;

/**
 * @Desc PythonUtility.java
 * <p>
 * @Author yoong
 * <p>
 * @Date 2017年4月1日
 * <p>
 * @Version 1.0
 */
public class PythonUtility {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        // 执行python脚本
        // PythonInterpreter interpreter = new PythonInterpreter();
        // interpreter.exec("days=('mod','Tue','Wed','Thu','Fri','Sat','Sun');
        // ");

        try {
            // 执行python py文件
            // PythonInterpreter interpreter = new PythonInterpreter();
            // InputStream filepy = new FileInputStream("D:\\hello.py");
            // interpreter.execfile(filepy);
            // filepy.close();
        } catch (Exception ex) {
            String msg = ex.getMessage();
            System.out.println(msg);
        }

        System.out.println("Hello World Ending!");
    }
}
