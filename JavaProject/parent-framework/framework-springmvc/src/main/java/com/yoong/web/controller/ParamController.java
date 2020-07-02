package com.yoong.web.controller;

import com.yoong.web.domain.Menu;
import com.yoong.web.dto.CommonEContractReq;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yoong
 * @desc ParamController.java
 * @date 2020年2月20日
 */
@Controller
@RequestMapping("/param")
public class ParamController {

    /**
     * http://127.0.0.1:7095/param/requestName?name=123
     * http://127.0.0.1:7095/param/requestName?name=123&qq=111
     */
    @ResponseBody
    @RequestMapping("/requestName")
    public String requestName(String name) {
        System.out.println(name);
        return "Success";
    }

    /**
     * http://127.0.0.1:7095/param/requestMenu
     * {"menuId":"1111","menuName":"menuName-01","menuUrl":"menuUrl-01"}
     * ?menuId=1111&menuName=menuName
     * ?menuId=1111
     */
    @ResponseBody
    @RequestMapping("/requestMenu")
    public String requestMenu(Menu menu) {
        System.out.println(menu);
        return "Success";
    }


    /**
     * Postman-Params Tag中添加参数
     * http://127.0.0.1:7095/param/requestParamName?name=name-01
     */
    @ResponseBody
    @RequestMapping("/requestParamName")
    public String requestParamName(@RequestParam("name") String name) {
        System.out.println(name);
        return "Success";
    }

    /**
     * http://127.0.0.1:7095/param/requestParamMenu
     */
    @ResponseBody
    @RequestMapping("/requestParamMenu")
    public String requestParamMenu(@RequestParam("menu") Menu menu) {
        System.out.println(menu);
        return "Success";
    }


    /**
     * PS：{"menuId":"1111","menuName":"menuName-01","menuUrl":"menuUrl-01"}
     * http://127.0.0.1:7095/param/requestBodyName
     */
    @ResponseBody
    @RequestMapping("/requestBodyName")
    public String requestBodyName(@RequestBody String name) {
        System.out.println(name);
        return "Success";
    }

    /**
     * PS：{"menuId":"1111","menuName":"menuName-01","menuUrl":"menuUrl-01"}
     * http://127.0.0.1:7095/param/requestBodyMenu
     */
    @ResponseBody
    @RequestMapping("/requestBodyMenu")
    public String requestBodyMenu(@RequestBody Menu menu) {
        System.out.println(menu);
        return "Success";
    }

    /**
     * PS：{"menuId":"1111","menuName":"menuName-01","menuUrl":"menuUrl-01"}
     * http://127.0.0.1:7095/param/requestBodyReq
     */
    @ResponseBody
    @RequestMapping("/requestBodyReq")
    public String requestBodyReq(@RequestBody CommonEContractReq req) {
        System.out.println(req);
        return "Success";
    }
}
