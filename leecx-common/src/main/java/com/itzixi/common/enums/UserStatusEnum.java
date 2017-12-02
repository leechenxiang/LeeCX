package com.itzixi.common.enums;

/**
 * 
 * @Title: UserStatusEnum.java
 * @Package com.itzixi.common.enums
 * @Description: 用户状态枚举
 * Copyright: Copyright (c) 2016
 * Company:Nathan.Lee.Salvatore
 * 
 * @author leechenxiang
 * @date 2017年2月15日 下午8:26:54
 * @version V1.0
 */
public enum UserStatusEnum {

	NOT_ACTIVE(0),			// 未激活
	ACTIVATED(1),			// 已激活
	FROZEN(2),				// 已冻结
	BANNED(3);				// 已封号
	
	public final int value;
	
	UserStatusEnum(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
}
