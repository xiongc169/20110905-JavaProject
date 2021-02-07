package com.yoong.springfx.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @Desc Student
 * <p>
 * @Author yoong
 * <p>
 * @Date 2014年3月30日
 * <p>
 * @Version 1.0
 */
@Data
@Component
public class Student {

    private String studentId;

    private String studentName;

    private String sex;

    public Student() {
        System.out.println("Student.Student()");
    }
}
