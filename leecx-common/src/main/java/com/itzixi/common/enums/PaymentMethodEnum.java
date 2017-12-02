package com.itzixi.common.enums;

/**
 * 
 * @Title: OrderStatusEnum.java
 * @Package com.itzixi.common.enums
 * @Description: 订单状态
 * Copyright: Copyright (c) 2016
 * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
 * 
 * @author leechenxiang
 * @date 2017年4月24日 下午4:31:20
 * @version V1.0
 */
public enum PaymentMethodEnum {

	alipay(1, "支付宝"),			// 支付宝	
	wechat(2, "微信");			// 微信
	
	public final int key;
	public final String value;
	
	PaymentMethodEnum(int key, String value) {
		this.key = key;
		this.value = value;
	}

	public static String getName(int key) {
		for (PaymentMethodEnum status : PaymentMethodEnum.values()) {
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
