package org.practice.springfx.book01.part02_ioc.methodreplacer;

import org.practice.springfx.domain.Car;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

public class Boss implements BeanFactoryAware {

    private BeanFactory beanFactory;

    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public String say(String msg) {
        String result = "I'm Boss, " + msg;
        System.out.println(result);
        return result;
    }
}
