package com.itzixi.common.enums;

/**
 * 
 * @Title: ReviewStatusEnum.java
 * @Package com.itzixi.common.enums
 * @Description: 审核状态枚举
 * Copyright: Copyright (c) 2016
 * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
 * 
 * @author leechenxiang
 * @date 2017年8月15日 下午4:15:08
 * @version V1.0
 */
public enum ReviewStatusEnum {

	PASS(1),				// 审核不通过
	UNPASS(0),				// 审核通过
	WAIT_REVIEW(2);			// 待审核
	
	public final int value;
	
	ReviewStatusEnum(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
}
