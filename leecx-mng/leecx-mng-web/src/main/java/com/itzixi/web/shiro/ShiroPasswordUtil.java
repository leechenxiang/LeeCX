package com.itzixi.web.shiro;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * 
 * @Title: ShiroPasswordUtil.java
 * @Package com.itzixi.common.utils
 * @Description: 统一密码加密工具类
 * Copyright: Copyright (c) 2017
 * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
 * 
 * @author leechenxiang
 * @date 2017年10月20日 下午8:38:00
 * @version V1.0
 */
public class ShiroPasswordUtil {

	/**
	 * 
	 * @Title: ShiroPasswordUtil.java
	 * @Package com.itzixi.web.shiro
	 * @Description: 获取加盐并且循环多次散列值的密码
	 * Copyright: Copyright (c) 2017
	 * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
	 * 
	 * @author leechenxiang
	 * @date 2017年10月20日 下午8:40:19
	 * @version V1.0
	 */
	public static String getShiroPassword(String password, String salt, int hashCount) {
		return new Md5Hash(password, salt, hashCount).toString();
	}
}
