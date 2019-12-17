package org.practice.primary.book01.chap05;

import lombok.Data;

/**
 * @Desc Manager
 * @Author
 * @Date
 * @Version 1.0
 */
@Data
public class Manager extends Employee {

    private Long bonus;

    @Override
    public Long getSalary() {
        System.out.println(this.getId());
        return super.getSalary() + bonus;
    }

    public String greet() {
        String greet = "Manager " + this.getName();
        return greet;
    }
}
