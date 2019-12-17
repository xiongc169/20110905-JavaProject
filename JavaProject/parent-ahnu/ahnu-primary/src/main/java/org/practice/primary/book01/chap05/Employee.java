package org.practice.primary.book01.chap05;

import lombok.Data;

/**
 * @Desc final Employee
 * @Author
 * @Date
 * @Version 1.0
 */
@Data
public class Employee {
    private Long Id;
    private String name;
    private Long salary;

    /**
     * final
     */
    public String greet() {
        String greet = "Employee " + name;
        return greet;
    }
}
