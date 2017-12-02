package com.itzixi.common.utils.amount;

import java.math.BigDecimal;

/**
 * 
 * @Title: CurrencyUtils.java
 * @Package com.itzixi.common.utils
 * @Description: 货币utils
 * Copyright: Copyright (c) 2016
 * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
 * 
 * @author leechenxiang
 * @date 2017年4月19日 上午9:33:05
 * @version V1.0
 */
public class CurrencyUtils {
	
	/**
	 * 
	 * @Description: 分转元，带有小数点
	 * @param amount
	 * @return
	 * 
	 * @author leechenxiang
	 * @date 2017年4月20日 下午3:17:01
	 */
	public static String getFen2YuanWithPoint(Integer amount) {    
		return BigDecimal.valueOf(amount).divide(new BigDecimal(100)).toString();    
	}
	
	/**
	 * 
	 * @Description: 分转元，不带小数，只取整数位
	 * @param amount
	 * @return
	 * 
	 * @author leechenxiang
	 * @date 2017年4月20日 下午3:17:13
	 */
	public static Integer getFen2Yuan(Integer amount) {    
		return BigDecimal.valueOf(amount).divide(new BigDecimal(100)).intValue();    
	} 
        
	/**
	 * 
	 * @Description: 元转分，返回整数
	 * @param amount
	 * @return
	 * 
	 * @author leechenxiang
	 * @date 2017年4月20日 下午3:17:35
	 */
	public static Integer getYuan2Fen(Integer amount) {    
		return BigDecimal.valueOf(amount).multiply(new BigDecimal(100)).intValue();    
	}   
	
	/**
	 * 
	 * @Description: 元转分，返回整数
	 * @param amount
	 * @return
	 * 
	 * @author leechenxiang
	 * @date 2017年4月20日 下午3:17:35
	 */
	public static Integer getYuan2Fen(String amount) {    
		return BigDecimal.valueOf(Double.valueOf(amount)).multiply(new BigDecimal(100)).intValue();    
	}  
	
//	public static void main(String[] args) {
//		System.out.println(new CurrencyUtils().getYuan2Fen("12.366"));
//	}
}
