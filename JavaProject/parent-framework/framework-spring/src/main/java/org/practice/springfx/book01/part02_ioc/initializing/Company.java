package org.practice.springfx.book01.part02_ioc.initializing;

import lombok.Data;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

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

    public Company() {
        System.out.println("Construct - Company.Company()");
    }

    /**
     * JSR250的@Resource、@PostConstruct、@PreDestory对相应类进行标注
     */
    @PostConstruct
    public void postConstruct() {
        System.out.println("@PostConstruct - Company.postConstruct()");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("@PreDestroy - Company.preDestroy()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean - Company.afterPropertiesSet()");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean - Company.destroy()");
    }

    public void initMethod() {
        System.out.println("init-method - Company.initMethod()");
    }

    public void destroyMethod() {
        System.out.println("destroy-method - Company.destroyMethod()");
    }

    /**
     * 注意：重写Object的finalize()方法，不是其他类的方法
     * import org.codehaus.groovy.util.Finalizable;
     */
    @Override
    public void finalize() {
        System.out.println("finalize - Company.finalize()");
    }
}
