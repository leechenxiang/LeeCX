package com.itzixi.web.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 
 * @Title: SpringUtils.java
 * @Package com.agood.bejavagod.utils
 * @Description: Spring上下文操作类
 * Copyright: Copyright (c) 2016
 * Company:Nathan.Lee.Salvatore
 * 
 * @author leechenxiang
 * @date 2016年11月29日 下午6:32:42
 * @version V1.0
 */
@Component
public class SpringUtils implements ApplicationContextAware {
	
	/**上下文对象*/
    private static ApplicationContext context;

	@Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.context = context;
    }

    /**
     * 
     * 获取Spring上下文对象
     * 
     * @return
     */
    public static ApplicationContext getContext() {
        return context;
    }

}
