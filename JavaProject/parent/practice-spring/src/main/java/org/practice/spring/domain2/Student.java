package org.practice.spring.domain2;

import org.springframework.stereotype.Component;

/**
 * Student
 *
 * @author yoong
 */
@Component
public class Student {

    private String studentId;

    private String studentName;

    private String sex;

    public Student() {
        System.out.println("Student.Student()");
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
