package org.practice.springfx.book01.part02_ioc.initializing;

import lombok.Data;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @Desc Company
 * <p>
 * @Author yoong
 * <p>
 * @Date 2017-5-10 22:10:00
 * <p>
 * @Version 1.0
 */
@Data
public class Company implements InitializingBean, DisposableBean {

    private String companyId;
    private String companyName;
    private String companyAddress;

    public void initMethod() {
        System.out.println("Company.initMethod()");
    }

    public void destroyMethod() {
        System.out.println("Company.destroyMethod()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Company.afterPropertiesSet()");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Company.destroy()");
    }
}
