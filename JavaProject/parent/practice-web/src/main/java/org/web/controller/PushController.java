package org.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.practice.jpush.App;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yoong
 *
 * @desc PushController.java
 *
 * @date 2018年8月16日
 *
 */
@Controller
@RequestMapping("/push")
public class PushController {

	public PushController() {
		System.out.println("init PushController");
	}

	@ResponseBody
	@RequestMapping("/pushMessage")
	public String pushMessage() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			boolean result = App.pushMessage("dev_15158107051", "征信信息", "客户【钟梦菲】杭州建行征信结果已反馈，请查收-2018年8月16日15:27:10");
			System.out.println(format.format(new Date()) + ": " + result);
			return result ? "Push Success  " + format.format(new Date()) : "Push Failure  "+ format.format(new Date());
		} catch (Exception ex) {
			ex.printStackTrace();
			return "Push Failure  "+ format.format(new Date());
		}
	}

}
