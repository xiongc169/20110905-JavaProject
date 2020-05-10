package org.practice.springfx.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @Desc Car
 * <p>
 * @Author yoong
 * <p>
 * @Date 2014年3月30日
 * <p>
 * @Version 1.0
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
