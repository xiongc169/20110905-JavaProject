package org.practice.spring.reflect;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author yoong
 *
 * @version 1.0
 *
 * @desc 自定义注解
 *      http://www.importnew.com/17413.html
 *      https://blog.csdn.net/bao19901210/article/details/17201173/
 *
 * @date 2014年3月30日
 */
@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodInfo {

    String author() default "yoong";

    String date();

    String version();

    String comments();

}
