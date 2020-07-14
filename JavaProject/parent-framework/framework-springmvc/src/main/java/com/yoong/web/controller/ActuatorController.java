package com.yoong.web.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import java.util.Objects;

/**
 * @Desc ActuatorController.java
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018年8月20日
 * <p>
 * @Version 1.0
 */
@Controller
@RequestMapping("/actuator")
public class ActuatorController {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ServletContext servletContext;

    /**
     * http://127.0.0.1:8095/actuator/getIoc
     * <p>
     * 查看Spring MVC父容器、子容器的对象的实例
     * https://www.cnblogs.com/oukele/p/9887463.html
     */
    @ResponseBody
    @RequestMapping("/getIoc")
    public String getIoc() {
        String[] beanNames = webApplicationContext.getBeanDefinitionNames();
        String[] parentBeanNames = Objects.requireNonNull(webApplicationContext.getParent()).getBeanDefinitionNames();
        //"logAspect",
        //"preConfig",
        //"actuatorController",
        //"hibernateController",
        //"pushController",
        //"accountDaoImpl",
        //"accountServiceImpl",
        //"org.springframework.context.annotation.internalConfigurationAnnotationProcessor",
        //"org.springframework.context.annotation.internalAutowiredAnnotationProcessor",
        //"org.springframework.context.annotation.internalRequiredAnnotationProcessor",
        //"org.springframework.context.annotation.internalCommonAnnotationProcessor",
        //"org.springframework.context.annotation.internalPersistenceAnnotationProcessor",
        //"org.springframework.aop.config.internalAutoProxyCreator",
        //"org.springframework.beans.factory.config.PropertyPlaceholderConfigurer#0",
        //"dataSource",
        //"sessionFactory",
        //"transactionManager",
        //"org.springframework.transaction.annotation.AnnotationTransactionAttributeSource#0",
        //"org.springframework.transaction.interceptor.TransactionInterceptor#0",
        //"org.springframework.transaction.config.internalTransactionAdvisor",
        //"org.springframework.context.annotation.ConfigurationClassPostProcessor.importAwareProcessor",
        //"org.springframework.context.annotation.ConfigurationClassPostProcessor.enhancedConfigurationProcessor",
        //"accountBean"
        System.out.println(beanNames.length);
        System.out.println(JSON.toJSONString(beanNames));

        System.out.println(parentBeanNames.length);
        System.out.println(JSON.toJSONString(parentBeanNames));

        Object root = servletContext.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);//org.springframework.web.context.WebApplicationContext.ROOT
        System.out.println(root);

        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        System.out.println(context);
        return "Success";
    }
}

