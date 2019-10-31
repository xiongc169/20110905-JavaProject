package org.practice.spring.ioc.aware;

import lombok.Data;
import org.springframework.beans.factory.BeanNameAware;

/**
 * @Desc XBeanNameAware
 * @Author
 * @Date
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
