package com.itzixi.common.enums;

/**
 * 
 * @Title: SexEnum.java
 * @Package com.itzixi.common.enums
 * @Description: 男女枚举
 * Copyright: Copyright (c) 2016
 * Company:Nathan.Lee.Salvatore
 * 
 * @author leechenxiang
 * @date 2017年3月6日 下午3:55:04
 * @version V1.0
 */
public enum SexEnum {
	
	GIRL(0),		// 女
	BOY(1),			// 男
	SECRET(2);		// 保密	
	
	public final int value;
	
	SexEnum(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
}
