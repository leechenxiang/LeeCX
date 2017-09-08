package com.itzixi.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
@RequestMapping("/")
public class CenterController extends BaseController {
	
	final static Logger log = LoggerFactory.getLogger(CenterController.class);
	
	@RequestMapping("/center")
	public ModelAndView index() {
		
    	ModelAndView modelAndView = new ModelAndView("center");
		
		return modelAndView;
	}
	
}
