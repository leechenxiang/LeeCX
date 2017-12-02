package com.itzixi.common.enums;

/**
 * 
 * @Title: JobEnum.java
 * @Package com.itzixi.common.enums
 * @Description: 职业类型枚举
 * Copyright: Copyright (c) 2016
 * Company:Nathan.Lee.Salvatore
 * 
 * @author leechenxiang
 * @date 2017年3月6日 下午8:22:18
 * @version V1.0
 */
public enum JobEnum {
	
	JAVA(1),				// Java开发
	FRONT_END(2),			// 前端开发
	BIG_DATA(3),			// 大数据开发	
	IOS(4),					// ios开发
	ANDROID(5),				// Android开发
	LINUX(6),				// Linux系统工程师
	PHP(7),					// PHP开发
	DOT_NET(8),				// .net开发
	C_LAN(9),				// C/C++
	STUDENT(10),			// 学生
	OTHER(11);				// 其它
	
	public final int value;
	
	JobEnum(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
}
