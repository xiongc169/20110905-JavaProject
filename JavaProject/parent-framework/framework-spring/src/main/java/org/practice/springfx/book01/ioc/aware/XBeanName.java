package org.practice.springfx.book01.ioc.aware;

import lombok.Data;

/**
 * @Desc XBeanNameAware
 * @Author
 * @Date
 * @Version 1.0
 */
@Data
public class XBeanName {

    private String beanName;

    private String Id;

    public void setBeanName(String Id) {
        System.out.println("setBeanName");
        this.beanName = Id;
    }
}
