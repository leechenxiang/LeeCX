package com.itzixi.mapper;

import java.util.List;

import com.itzixi.pojo.SysPermission;

/**
 * 
 * @Title: SysPermissionMapperCustom.java
 * @Package com.itzixi.mapper
 * @Description: 资源权限自定义mapper
 * Copyright: Copyright (c) 2017
 * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
 * 
 * @author leechenxiang
 * @date 2017年10月22日 下午9:25:48
 * @version V1.0
 */
public interface SysPermissionMapperCustom {
	
	/**
	 * 
	 * @Title: SysPermissionMapperCustom.java
	 * @Package com.itzixi.mapper
	 * @Description: 根据userid动态查询菜单资源url
	 * Copyright: Copyright (c) 2017
	 * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
	 * 
	 * @author leechenxiang
	 * @date 2017年10月22日 下午9:25:28
	 * @version V1.0
	 */
	public List<SysPermission> findMenuListByUserId(String userid)throws Exception;
	
	/**
	 * 
	 * @Title: SysPermissionMapperCustom.java
	 * @Package com.itzixi.mapper
	 * @Description: 根据userid查询权限资源字符串
	 * Copyright: Copyright (c) 2017
	 * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
	 * 
	 * @author leechenxiang
	 * @date 2017年10月22日 下午9:25:05
	 * @version V1.0
	 */
	public List<SysPermission> findPermissionListByUserId(String userid)throws Exception;

}
