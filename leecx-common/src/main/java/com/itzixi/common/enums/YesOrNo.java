package com.itzixi.common.enums;

/**
 * 
 * @Title: YesOrNo.java
 * @Package com.itzixi.common.enums
 * @Description: 是否枚举
 * Copyright: Copyright (c) 2016
 * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
 * 
 * @author leechenxiang
 * @date 2017年8月15日 下午4:15:28
 * @version V1.0
 */
public enum YesOrNo {

	YES(1),			// 是	有错误
	NO(0);			// 否	无错误	
	
	public final int value;
	
	YesOrNo(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
}
