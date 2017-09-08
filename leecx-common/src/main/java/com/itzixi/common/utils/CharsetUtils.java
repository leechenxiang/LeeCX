package com.itzixi.common.utils;

import java.io.UnsupportedEncodingException;

import org.apache.commons.lang3.StringUtils;

/**
 * @Title: CharsetUtils.java
 * @Package com.itzixi.common.utils
 * @Description: 字符编码
 * Copyright: Copyright (c) 2016
 * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
 * 
 * @author leechenxiang
 * @date 2016年6月4日 下午2:51:41
 * @version V1.0
 */
public class CharsetUtils {
	
	/**
	 * @Description: iso8859-1 转换成 utf-8
	 * @param target
	 * @return
	 * @throws UnsupportedEncodingException
	 * 
	 * @author leechenxiang
	 * @date 2016年6月4日 下午2:55:58
	 */
	public static String IsoToUtf(String target) throws UnsupportedEncodingException{
		if(StringUtils.isNotEmpty(target) && StringUtils.isNotBlank(target)){
			return new String(target.getBytes("iso8859-1"), "utf-8").trim();
		}
		return null;
	}
}
