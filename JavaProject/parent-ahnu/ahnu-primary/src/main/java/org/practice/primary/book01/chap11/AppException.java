package org.practice.primary.book01.chap11;

import java.util.logging.Logger;

/**
 * 《Java核心技术·卷1》第十一章、异常、断言、日志、调试
 */
public class AppException {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            category1101();
            log1105();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            System.out.println("This is finally");
        }
    }

    private static void category1101() {
        Throwable throwable = new Throwable();
        throwable.printStackTrace();

        //描述了Java运行时系统的内部错误和资源耗尽错误
        Error error = new Error();
        error.printStackTrace();

        Exception exception = new Exception();
        exception.printStackTrace();

        //由于程序错误导致的异常，属于RuntimeException；
        //程序本身没有问题，由于像IO错误导致的异常，属于其他异常
        RuntimeException runtimeException = new RuntimeException();
        runtimeException.printStackTrace();

        //派生于Error、RuntimeException类的所有异常，称为未检查异常(unchecked exception)
        //其他的异常，称为已检查异常(checked exception)
    }

    private static void log1105() {
        Logger logger = Logger.getLogger("");
        logger.info("This is info");
    }
}
