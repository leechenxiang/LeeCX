package com.itzixi.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.itzixi.common.utils.LeeJSONResult;

/**
 * 
 * @Title: CenterController.java
 * @Package com.itzixi.web.controller
 * @Description: CenterController 
 * Copyright: Copyright (c) 2016
 * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
 * 
 * @author leechenxiang
 * @date 2017年7月26日 下午2:08:52
 * @version V1.0
 */
@Controller
public class CenterController extends BaseController {
	
	final static Logger log = LoggerFactory.getLogger(CenterController.class);
	
	@RequestMapping("/center")
	public ModelAndView index() {
		
    	ModelAndView modelAndView = new ModelAndView("center");
		
		return modelAndView;
	}
	
//	@GetMapping("/login")
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String doGetlogin() {
		
		return "login";
	}
	
//	@PostMapping("/login")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public LeeJSONResult doPostlogin(String username, String password, HttpServletRequest request, HttpServletResponse response) {
		
		if (StringUtils.isBlank(username)) {
            return LeeJSONResult.errorMsg("用户名不能为空");
        }
        if (StringUtils.isBlank(password)) {
            return LeeJSONResult.errorMsg("密码不能为空");
        }
        Subject user = SecurityUtils.getSubject();
        
        UsernamePasswordToken token = new UsernamePasswordToken(username, password.toCharArray());
        
        try {
            user.login(token);
        } catch (UnknownAccountException e) {
            return LeeJSONResult.errorMsg("账号不存在");
        } catch (DisabledAccountException e) {
            return LeeJSONResult.errorMsg("账号未启用");
        } catch (IncorrectCredentialsException e) {
            return LeeJSONResult.errorMsg("密码错误");
        } catch (RuntimeException e) {
            return LeeJSONResult.errorMsg("未知错误,请联系管理员");
        }

		return LeeJSONResult.ok();
	}
 
	/**
	 * 
	 * @Title: CenterController.java
	 * @Package com.itzixi.web.controller
	 * @Description: 用户退出
	 * Copyright: Copyright (c) 2017
	 * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
	 * 
	 * @author leechenxiang
	 * @date 2017年10月19日 下午10:06:21
	 * @version V1.0
	 */
    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        
        return "redirect:/login.action";
    }
}
