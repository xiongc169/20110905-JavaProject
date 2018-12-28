package org.practice.spring.domain2;

import org.springframework.stereotype.Component;

/**
 * 序列化
 *
 * @author yoong
 */
@Component
public class Student {

    /**
     * Id，非空，长度应为36
     */
    protected String studentId;

    /**
     * 姓名，非空，最大长度为30
     */
    protected String studentName;

    /**
     * 所属单位编号，非空，最大长度为36
     */
    protected String sex;

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
