package com.itzixi.components;

/**
 * 
 * @Title: JedisClient.java
 * @Package com.lee.rest.component
 * @Description: redis客户端
 * Copyright: Copyright (c) 2016
 * Company:Nathan.Lee.Salvatore
 * 
 * @author leechenxiang
 * @date 2016年4月27日 下午4:28:46
 * @version V1.0
 */
public interface JedisClient {

	public String set(String key, String value);
	public String get(String key);
	public Long del(String key);
	public Long hset(String key, String item, String value);
	public String hget(String key, String item);
	public Long hdel(String key, String item);
	public Long incr(String key);
	public Long decr(String key);
	
	/**
	 * 
	 * @Description: 设置存存活时间
	 * @param key
	 * @param second
	 * @return
	 * 
	 * @author leechenxiang
	 * @date 2016年4月27日 下午4:34:35
	 */
	public Long expire(String key, int second);
	
	/**
	 * 
	 * @Description: 判断key多久过期
	 * @param key
	 * @return 秒 
	 * 			>= 0 	剩余秒数
	 * 			= -1	永久存活
	 * 			= -2	已经消除
	 * 
	 * @author leechenxiang
	 * @date 2016年4月27日 下午4:34:22
	 */
	public Long ttl(String key);
}
