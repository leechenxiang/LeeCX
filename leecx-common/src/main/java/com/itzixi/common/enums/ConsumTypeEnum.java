package com.itzixi.common.enums;

/**
 * 
 * @Title: ConsumTypeEnum.java
 * @Package com.itzixi.common.enums
 * @Description: 消费类型
 * Copyright: Copyright (c) 2016
 * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
 * 
 * @author leechenxiang
 * @date 2017年4月25日 下午3:50:05
 * @version V1.0
 */
public enum ConsumTypeEnum {

	BUY_COURSE(1, "购买课程"),			// 购买课程	
	RECHARGE(2, "充值");				// 充值
	
	public final int key;
	public final String value;
	
	ConsumTypeEnum(int key, String value) {
		this.key = key;
		this.value = value;
	}

	public static String getName(int key) {
		for (ConsumTypeEnum status : ConsumTypeEnum.values()) {
			if (status.getKey() == key) {
				return status.value;
			}
		}
		return null;
	}
	 
	public int getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}
}
