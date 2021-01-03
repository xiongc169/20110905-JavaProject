package org.practice.springfx.book04.chap0401;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class MyNamespaceHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        registerBeanDefinitionParser("customTag", new UserBeanDefinitionParser());
    }
}
