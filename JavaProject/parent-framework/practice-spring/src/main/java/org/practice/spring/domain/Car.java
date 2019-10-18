package org.practice.spring.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Car
 *
 * @author yoong
 */
@Data
@Component
public class Car {

    private String carId;

    private String carBrandName;

    private String carModelName;

    public String output() {
        String msg = String.format("%s %s %s", this.carId, this.carBrandName, this.carModelName);
        System.out.println("Output: " + msg);
        return msg;
    }
}
