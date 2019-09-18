package org.practice.spring.domain;

import org.springframework.stereotype.Component;

/**
 * Car
 *
 * @author yoong
 */
@Component
public class Car {

    private String carId;

    private String carBrandName;

    private String carModelName;

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getCarBrandName() {
        return carBrandName;
    }

    public void setCarBrandName(String carBrandName) {
        this.carBrandName = carBrandName;
    }

    public String getCarModelName() {
        return carModelName;
    }

    public void setCarModelName(String carModelName) {
        this.carModelName = carModelName;
    }

    public String output() {
        String msg = String.format("%s %s %s", this.carId, this.carBrandName, this.carModelName);
        System.out.println("Output: " + msg);
        return msg;
    }
}
