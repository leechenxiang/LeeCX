package com.itzixi.common.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IdcardValidator implements ConstraintValidator<Idcard, String> {

	@Override
	public void initialize(Idcard constraintAnnotation) {
		
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		boolean rs=false;
		//验证15位省份证
		if(value.length()==15){
		    // 15位验证规则
		    String regEx = "^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$";
		    // 编译正则表达式
		    Pattern pattern = Pattern.compile(regEx);
		    // 忽略大小写的写法
		    // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
		    Matcher matcher = pattern.matcher(value);
		    // 字符串是否与正则表达式相匹配
		    rs = matcher.matches();
		    return rs;
		}
		//验证18位省份证
	    if(value.length()==18){
	    	// 18位验证规则
		    String regEx = "^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$";
		    // 编译正则表达式
		    Pattern pattern = Pattern.compile(regEx);
		    // 忽略大小写的写法
		    // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
		    Matcher matcher = pattern.matcher(value);
		    // 字符串是否与正则表达式相匹配
		    rs = matcher.matches();
		    return rs;
	    }
	    return rs;
	}

}
