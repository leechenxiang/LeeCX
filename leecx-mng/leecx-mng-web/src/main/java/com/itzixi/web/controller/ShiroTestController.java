package com.itzixi.web.controller;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @Title: CenterController.java
 * @Package com.itzixi.web.controller
 * @Description: shiro测试的controller 
 * Copyright: Copyright (c) 2016
 * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
 * 
 * @author leechenxiang
 * @date 2017年7月26日 下午2:08:52
 * @version V1.0
 */
@Controller
@RequestMapping("shiroTest")
public class ShiroTestController extends BaseController {
	
	@RequestMapping("/shiroPage")
	@RequiresPermissions(value = {"company:mng", "appuser:check", "company:check"}, logical = Logical.OR) 
	public ModelAndView index() {
		
//		Subject user = SecurityUtils.getSubject();
//		user.isPermitted("company:mng");
		
		System.out.println("当前主体用户有权限进入本controller~");
		
    	ModelAndView modelAndView = new ModelAndView("shiro/shiroPage");
		
		return modelAndView;
	}
}
