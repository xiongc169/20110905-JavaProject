package org.practice.springfx.book01.part02_ioc.aware;

import lombok.Data;

/**
 * @Desc XBeanName
 * <p>
 * @Author yoong
 * <p>
 * @Date 2017-5-10 22:10:00
 * <p>
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
