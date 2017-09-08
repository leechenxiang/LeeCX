package com.itzixi.common.utils.amount;

import java.math.BigDecimal;

/**
 * 
 * @Title: AmountUtil.java
 * @Package com.itzixi.common.utils.amount
 * @Description: 计算金额的工具类
 * Copyright: Copyright (c) 2016
 * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
 * 
 * @author leechenxiang
 * @date 2017年5月19日 下午3:08:54
 * @version V1.0
 */
public class AmountUtil {

	/**
	 * 
	 * @Description: 乘法运算: 整数 X 小数
	 * @param value1
	 * @param value2
	 * @return
	 * 
	 * @author leechenxiang
	 * @date 2017年5月19日 下午3:19:12
	 */
    public static Integer mul(Integer value1, BigDecimal value2) {
        BigDecimal b1 = new BigDecimal(Integer.toString(value1));
        BigDecimal b2 = value2;
        return b1.multiply(b2).intValue();
    }
    
//    public static void main(String[] args) {
//		System.out.println(new AmountUtil().mul(19999, 0.8));
//	}

}