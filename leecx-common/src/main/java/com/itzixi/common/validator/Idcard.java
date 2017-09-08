package com.itzixi.common.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @Title: Idcard.java
 * @Package com.itzixi.common.validator
 * @Description: 省份证格式验证Validator
 * Copyright: Copyright (c) 2016
 * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
 * 
 * @author leechenxiang
 * @date 2016年6月14日 上午9:43:09
 * @version V1.0
 */
@Documented  
@Constraint(validatedBy = {IdcardValidator.class})  
@Target({java.lang.annotation.ElementType.METHOD,    
    java.lang.annotation.ElementType.FIELD})  
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)  
public @interface Idcard {
	
	String message() default "省份证格式不正确"; //提示信息,可以写死,可以填写国际化的key    
        
    //下面这两个属性必须添加    
    Class<?>[] groups() default {};   
    
    Class<? extends Payload>[] payload() default {};    
}
