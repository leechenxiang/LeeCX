package com.itzixi.common.utils;

import java.util.Random;

/**
 * 
 * @Title: NumberUtil.java
 * @Package com.itzixi.common.utils
 * @Description: 跟数字有关的一些工具方法 Copyright: Copyright (c) 2016
 *               Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
 * 
 * @author leechenxiang
 * @date 2016年6月1日 下午3:29:07
 * @version V1.0
 */
public class NumberUtil {

	/**
	 * 
	 * @Description: 随机数字
	 * @param num
	 * @return
	 * 
	 * @author leechenxiang
	 * @date 2016年6月1日 下午3:29:49
	 */
	public static String getRandomNumber(int length) {
		int i = 1;// i在此程序中只作为判断是否是将随机数添加在首位，防止首位出现0；
		Random r = new Random();
		int tag[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		String number = "";
		int temp = 0;

		while (number.length() < length) {
			temp = r.nextInt(10);// 取出0(含)~10(不含)之间任意数
			if (i == 1 && temp == 0) {
				continue;
			} else {
				i = 2;
				if (tag[temp] == 0) {
					number = number + temp;
					tag[temp] = 1;
				}
			}
		}
		return number;
	}
	
	/**
	 * 
	 * @Description: 生成随机数字和字母
	 * @param length
	 * @return
	 * 
	 * @author leechenxiang
	 * @date 2017年9月5日 下午4:38:15
	 */
    public static String getStringRandom(int length) {  
          
        String val = "";  
        Random random = new Random();  
          
        //参数length，表示生成几位随机数  
        for(int i = 0; i < length; i++) {  
              
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";  
            //输出字母还是数字  
            if( "char".equalsIgnoreCase(charOrNum) ) {  
                //输出是大写字母还是小写字母  
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;  
                val += (char)(random.nextInt(26) + temp);  
            } else if( "num".equalsIgnoreCase(charOrNum) ) {  
                val += String.valueOf(random.nextInt(10));  
            }  
        }  
        return val;  
    }  
    
//    public static void main(String[] args) {
//    	String s = NumberUtil.getStringRandom(4);
//    	System.out.println(s);
//	}
}
