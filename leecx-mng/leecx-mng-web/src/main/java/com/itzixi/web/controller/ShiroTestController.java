package com.itzixi.web.controller;

import java.util.Date;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.itzixi.common.utils.LeeJSONResult;
import com.itzixi.pojo.ActiveUser;
import com.itzixi.web.shiro.ShiroDBRealm;

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
	
	@Autowired
	private ShiroDBRealm realm;
	
	@RequestMapping("/shiroPage")
	@RequiresPermissions(value = {"company:mng", "appuser:check", "company:check"}, logical = Logical.OR) 
	public ModelAndView index() {
		
		ActiveUser user = (ActiveUser)SecurityUtils.getSubject().getPrincipal();
		user.setUsername(new Date() + "");
//		user.isPermitted("company:mng");
		
		System.out.println("当前主体用户有权限进入本controller~");
		
    	ModelAndView modelAndView = new ModelAndView("shiro/shiroPage");
		
		return modelAndView;
	}
	
	/**
	 * 
	 * @Title: ShiroTestController.java
	 * @Package com.itzixi.web.controller
	 * @Description: 强制清除缓存
	 * Copyright: Copyright (c) 2017
	 * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
	 * 
	 * @author leechenxiang
	 * @date 2017年10月27日 下午8:37:20
	 * @version V1.0
	 */
	@RequestMapping("/clearCache")
	@ResponseBody
	public LeeJSONResult clearCache() {
//		realm.clearCache();
		return LeeJSONResult.ok();
	}
}
