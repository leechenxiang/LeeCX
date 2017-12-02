package com.itzixi.web.shiro;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.util.Destroyable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @Title: ShiroSpringCacheManager.java
 * @Package com.itzixi.web.shiro
 * @Description: 实现shiro的cacheManager
 * Copyright: Copyright (c) 2017
 * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
 * 
 * @author leechenxiang
 * @date 2017年10月14日 下午12:09:49
 * @version V1.0
 */
public class ShiroSpringCacheManager implements CacheManager, Destroyable {
	
	final static Logger logger = LoggerFactory.getLogger(ShiroSpringCacheManager.class);
	
	private org.springframework.cache.CacheManager cacheManager;
	
	public org.springframework.cache.CacheManager getCacheManager() {
		return cacheManager;
	}

	public void setCacheManager(org.springframework.cache.CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

	@Override
	public <K, V> Cache<K, V> getCache(String name) throws CacheException {
		if (logger.isTraceEnabled()) {
			logger.trace("Acquiring ShiroSpringCache instance named [" + name + "]");
		}
		org.springframework.cache.Cache cache = cacheManager.getCache(name);
		return new ShiroSpringCache<K, V>(cache);
	}

	@Override
	public void destroy() throws Exception {
		cacheManager = null;
	}

}
