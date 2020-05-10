package org.practice.springfx.book01.part02_ioc.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.lang.Nullable;

/**
 * @Desc FirstBeanPostProcessor implements InstantiationAwareBeanPostProcessor,BeanPostProcessor
 * <p>
 * @Author yoong
 * <p>
 * @Date 2017-5-10 22:10:00
 * <p>
 * @Version 1.0
 */
public class FirstBeanPostProcessor implements InstantiationAwareBeanPostProcessor, BeanPostProcessor {

    /**
     * BeanPostProcessor前置处理
     *
     * @param bean     原对象实例
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Nullable
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(bean.getClass());
        return bean;
    }

    /**
     * BeanPostProcessor后置处理
     *
     * @param bean     原对象实例
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Nullable
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
