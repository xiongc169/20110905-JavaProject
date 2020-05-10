package org.practice.springfx.domain2;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Student
 *
 * @author yoong
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
