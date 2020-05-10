package org.practice.springfx.book01.part02_ioc.aware;

import lombok.Data;
import org.springframework.beans.factory.BeanNameAware;

/**
 * @Desc XBeanNameAware
 * <p>
 * @Author yoong
 * <p>
 * @Date 2017-5-10 22:10:00
 * <p>
 * @Version 1.0
 */
@Data
public class XBeanNameAware implements BeanNameAware {

    private String beanName;

    private String Id;

    @Override
    public void setBeanName(String Id) {
        System.out.println("setBeanName");
        this.beanName = Id;
    }
}
