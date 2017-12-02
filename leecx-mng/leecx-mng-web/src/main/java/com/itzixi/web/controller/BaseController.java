package com.itzixi.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.itzixi.components.JedisClient;
import com.itzixi.components.utils.RedisOperator;
import com.itzixi.pojo.ActiveUser;

/**
 * 
 * @Title: BaseController.java
 * @Package com.itzixi.web.controller
 * @Description: basic controller, controller中的大部分通用方法写在此
 * Copyright: Copyright (c) 2016
 * Company:Nathan.Lee.Salvatore
 * 
 * @author leechenxiang
 * @date 2017年2月16日 下午7:56:32
 * @version V1.0
 */
public class BaseController {
	
//	@Autowired
//	public JedisClient jedis;
	
	@Autowired
	public RedisOperator jedis;
	
//	@Value("${REDIS_SESSION_KEY}")
//	public String REDIS_SESSION_KEY;
//	
//	@Value("${SESSION_EXPIRE}")
//	public Integer SESSION_EXPIRE;
//	
//	@Value("${ITZIXI_TOKEN}")
//	public String ITZIXI_TOKEN;
	
	/**
	 * 默认分页行数
	 */
	public static final Integer pageSize = 10;
	
	/**
	 * 
	 * @Description: 验证并且获得获得bean上的错误
	 * @param result
	 * @return
	 * 
	 * @author leechenxiang
	 * @date 2017年2月16日 下午7:56:59
	 */
	protected Map<String, String> getErrors(BindingResult result) {
		Map<String, String> map = new HashMap<String, String>();
		List<FieldError> list = result.getFieldErrors();
		for (FieldError error : list) {
			map.put(error.getField(), error.getDefaultMessage());
		}
		return map;
	}
	
	/**
	 * 
	 * @Description: 获得域名地址路径
	 * @param request
	 * @return
	 * 
	 * @author leechenxiang
	 * @date 2017年2月19日 下午7:13:56
	 */
	protected String getWebUrlAddress(HttpServletRequest request) {
		StringBuffer url = request.getRequestURL();  
		String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append("/").toString();  
		return tempContextUrl;
	}
	
	/**
	 * 
	 * @Description: 获得当前登录用户
	 * @return
	 * 
	 * @author leechenxiang
	 * @date 2017年2月26日 下午7:43:28
	 */
	protected ActiveUser getLoginUser() {
		return (ActiveUser)SecurityUtils.getSubject().getPrincipal();
	}
	
}
