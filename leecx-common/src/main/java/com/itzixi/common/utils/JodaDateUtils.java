package com.itzixi.common.utils;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * 
 * @Title: JodaDateUtils.java
 * @Package com.itzixi.common.utils
 * @Description: Joda 时间工具类
 * Copyright: Copyright (c) 2016
 * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
 * 
 * @author leechenxiang
 * @date 2016年8月13日 上午10:19:58
 * @version V1.0
 */
public class JodaDateUtils {
	
	public static final String TIME_FORMATTER_BASIC = "yyyy-MM-dd HH:mm:ss";
	public static final String TIME_FORMATTER_SHORT = "yyyyMMddHHmmss";
	public static final String TIME_FORMATTER_SHORT_MINI = "yyyyMMddHHmmssSSS";
	public static final String DATE_FORMATTER_SHORT = "yyyyMMdd";
	public static final String DATE_FORMATTER_NORMAL = "yyyy-MM-dd";
	
	/**
	 * 
	 * @Description: 获得字符串格式的时间
	 * @param formatter
	 * @return
	 * 
	 * @author leechenxiang
	 * @date 2016年8月13日 上午10:22:28
	 */
	public static String getDateStr(String formatter) {
		DateTime dateTime = new DateTime();
		return dateTime.toString(formatter);
	}
	
	/**
	 * 
	 * @Description: 获得字符串格式的时间
	 * @param formatter
	 * @param date
	 * @return
	 * 
	 * @author leechenxiang
	 * @date 2016年11月29日 下午3:12:17
	 */
	public static String getDateStr(String formatter, Date date) {
		DateTime dateTime = new DateTime(date);
		return dateTime.toString(formatter);
	}

	/**
	 * 
	 * @Description: 获得昨天的日期
	 * @param date
	 * @return
	 * 
	 * @author leechenxiang
	 * @date 2016年11月25日 下午2:13:54
	 */
	public static Date getYesterday(Date date) {
		DateTime dateTime = new DateTime(date);  
		dateTime = dateTime.minusDays(1);  
		return dateTime.toDate();
	}
	
	/**
	 * 
	 * @Description: str转换为date
	 * @param formatter
	 * @param date
	 * @return
	 * 
	 * @author leechenxiang
	 * @date 2016年11月29日 下午3:40:47
	 */
	public static Date getStrToDate(String formatter, String date) {
		DateTimeFormatter format = DateTimeFormat .forPattern(formatter);    
		DateTime dateTime = DateTime.parse(date, format);   
		return dateTime.toDate();
	}
	
	/**
	 * 
	 * @Description: 获得一周前
	 * @param date
	 * @return
	 * 
	 * @author leechenxiang
	 * @date 2016年11月29日 下午2:55:26
	 */
	public static Date getAWeekAgoDay(Date date) {
		DateTime dateTime = new DateTime(date);  
		dateTime = dateTime.minusDays(7);  
		return dateTime.toDate();
	}
}

