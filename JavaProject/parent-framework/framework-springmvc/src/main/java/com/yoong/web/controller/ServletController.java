package com.yoong.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Desc ServletController
 * @Author
 * @Date
 * @Version 1.0
 */
@Controller
@RequestMapping("/servlet")
public class ServletController {

    /**
     * http://127.0.0.1:8095/servlet/webapp
     * <p>
     */
    @ResponseBody
    @RequestMapping("/webapp")
    public void webapp() {
        System.out.println("ServletController.webapp");
    }
}
