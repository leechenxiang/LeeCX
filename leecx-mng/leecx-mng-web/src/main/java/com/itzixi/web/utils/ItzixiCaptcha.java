package com.itzixi.web.utils;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

import com.itzixi.common.utils.CookieUtils;


/**
 * 
 * @Title: ItzixiCaptcha.java
 * @Package com.itzixi.web.utils
 * @Description: 验证码实现类
 * Copyright: Copyright (c) 2017
 * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
 * 
 * @author leechenxiang
 * @date 2017年10月14日 下午12:11:53
 * @version V1.0
 */
public class ItzixiCaptcha implements InitializingBean {
	private final static Logger logger = LoggerFactory.getLogger(ItzixiCaptcha.class);
	private static final String DEFAULT_COOKIE_NAME = "itzixi-captcha";
	private final static String DEFAULT_CHACHE_NAME = "itzixiCaptchaCache";
	private final static int DEFAULT_MAX_AGE = -1; // cookie超时默认为session会话状态
	
	private CacheManager cacheManager;
	private String cacheName;
	private String cookieName;
	
	private Cache<String, String> itzixiCaptchaCache;
	
	public ItzixiCaptcha() {
		this.cacheName = DEFAULT_CHACHE_NAME;
		this.cookieName = DEFAULT_COOKIE_NAME;
	}
	
	public ItzixiCaptcha(CacheManager cacheManager) {
		this();
		this.cacheManager = cacheManager;
	}
	
	public CacheManager getCacheManager() {
		return cacheManager;
	}
	
	public void setCacheManager(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}
	
	public String getCacheName() {
		return cacheName;
	}
	
	public void setCacheName(String cacheName) {
		this.cacheName = cacheName;
	}
	
	public String getCookieName() {
		return cookieName;
	}

	public void setCookieName(String cookieName) {
		this.cookieName = cookieName;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(cacheManager, "cacheManager must not be null!");
		Assert.hasText(cacheName, "cacheName must not be empty!");
		Assert.hasText(cookieName, "cookieName must not be empty!");
		this.itzixiCaptchaCache = cacheManager.getCache(cacheName);
	}
	
	/**
	 * 生成验证码
	 */
	public void generate(HttpServletRequest request, HttpServletResponse response) {
		// 先检查cookie的uuid是否存在
		String cookieValue = CookieUtils.getCookieValue(request, cookieName);
		boolean hasCookie = true;
		if (StringUtils.isBlank(cookieValue)) {
			hasCookie = false;
			cookieValue = UUID.randomUUID().toString();
		}
		String captchaCode = CaptchaUtils.generateCode().toUpperCase();// 转成大写重要
		// 不存在cookie时设置cookie
		if (!hasCookie) {
			CookieUtils.setCookie(request, response, cookieName, cookieValue, DEFAULT_MAX_AGE);
		}
		// 生成验证码
		CaptchaUtils.generate(response, captchaCode);
		itzixiCaptchaCache.put(cookieValue, captchaCode);
	}
	
	/**
	 * 仅能验证一次，验证后立即删除
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @param userInputCaptcha 用户输入的验证码
	 * @return 验证通过返回 true, 否则返回 false
	 */
	public boolean validate(HttpServletRequest request, HttpServletResponse response, String userInputCaptcha) {
		if (logger.isDebugEnabled()) {
			logger.debug("validate captcha userInputCaptcha is " + userInputCaptcha);
		}
		String cookieValue = CookieUtils.getCookieValue(request, cookieName);
		if (StringUtils.isBlank(cookieValue)) {
			return false;
		}
		String captchaCode = itzixiCaptchaCache.get(cookieValue);
		if (StringUtils.isBlank(captchaCode)) {
			return false;
		}
		// 转成大写重要
		userInputCaptcha = userInputCaptcha.toUpperCase();
		boolean result = userInputCaptcha.equals(captchaCode);
		if (result) {
			itzixiCaptchaCache.remove(cookieValue);
			CookieUtils.deleteCookie(request, response, cookieName);
		}
		return result;
	}
}
