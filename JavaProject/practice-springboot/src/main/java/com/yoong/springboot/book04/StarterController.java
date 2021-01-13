package com.yoong.springboot.book04;

import com.yoong.starter.book04.chap1402.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Desc 《Spring源码深度解析(第2版)》郝佳著
 * PS：第十四章、SpringBoot体系原理 (P394)，见 practice-springboot、practice-springboot-starter
 * http://yun.java1234.com/article/1822	！！！！！
 * https://www.aibooks.cc/book/biancheng	！！！！！
 * <p>
 * @Author yoong
 * <p>
 * @Date 2020年4月29日20:26:30
 * <p>
 * @Version 1.0
 */
@Controller
@RequestMapping("/starter")
public class StarterController {

    @Autowired
    private HelloService helloService;

    /**
     * http://127.0.0.1:8085/starter/hello
     */
    @ResponseBody
    @RequestMapping("/hello")
    public void hello() {
        String result = "init";
        result = helloService.sayHello();
        System.out.println(result);
    }
}
