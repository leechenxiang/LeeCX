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
public enum OrderStatusEnum {

	WAIT_PAY(10, "待付款"),			// 代付款		
	PAID(20, "已付款"),				// 已付款
	CANCELED(30, "已取消"),			// 已取消
	CLOSED(40, "交易关闭");			// 超时未支付, 交易关闭    -  这个功能先不做, 如果用户一直是[待付款], 那就待呗, 有啥要紧的
	
	public final int key;
	public final String value;
	
	OrderStatusEnum(int key, String value) {
		this.key = key;
		this.value = value;
	}

	public static String getName(int key) {
		for (OrderStatusEnum status : OrderStatusEnum.values()) {
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
