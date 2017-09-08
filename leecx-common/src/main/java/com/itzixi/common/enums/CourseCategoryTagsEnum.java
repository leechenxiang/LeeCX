package com.itzixi.common.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @Title: WorkYearsEnum.java
 * @Package com.itzixi.common.enums
 * @Description: 工作年限枚举
 * Copyright: Copyright (c) 2016
 * Company:Nathan.Lee.Salvatore
 * 
 * @author leechenxiang
 * @date 2017年3月6日 下午8:19:12
 * @version V1.0
 */
public enum CourseCategoryTagsEnum {
	
	JAVA(1, "Java技术"),							// Java技术
	FRONTEND(2, "前端技术"),						// 前端技术
	DATABASE(3, "数据库"),						// 数据库
	NOSQL(4, "NoSql"),							// NoSql
	ARCHITECTURE(5, "架构"),						// 架构
	ACTUAL_PROJECTS(6, "项目实战"),				// 项目实战
	HC_HA(7, "高并发/高可用"),						// 高并发/高可用
	PERFORMANCE_OPTIMIZATION(8, "性能优化"),		// 性能优化
	PORDUCT_DESIGN(9, "产品设计"),					// 产品设计
	WECHART_DEVELOP(10, "微信开发"),				// 微信开发
	LINUX_OPERATION(11, "Linux运维"),				// Linux运维
	BIG_DATA(12, "大数据"),						// 大数据
	CLOUD_COMPUTING(13, "云计算"),				// 云计算
	PROJECT_MANAGEMENT(14, "项目管理"),			// 项目管理
	SOFTWARE_TEST(15, "软件测试"),					// 软件测试
	OPENSOURCE(16, "开源项目"),					// 开源项目
	IOS(17, "ios"),								// ios
	DOT_NET(18, ".Net"),						// .Net
	ANDROID(19, "Android"),						// Android
	C_LAN(20, "C/C++"),							// C/C++
	PYTHON(21, "Python"),						// Python
	PHP(22, "php"),								// php
	WE_MEDIA(23, "自(新)媒体"),					// 自(新)媒体
	ENGLISH_LEARNING(24, "英语学习");				// 英语学习
	
	public final int key;
	public final String value;
	
	CourseCategoryTagsEnum(int key, String value) {
		this.key = key;
		this.value = value;
	}
	
	public static Map<Integer, String> getCategoryTagsMap() {
		
		Map<Integer, String> tagMap = new HashMap<Integer, String>();
		for (CourseCategoryTagsEnum tag : CourseCategoryTagsEnum.values()) {
			tagMap.put(tag.key, tag.value);
		}
		return tagMap;
	}
	
	public int getKey() {
		return key;
	}
	
	public String getValue() {
		return value;
	}
	
}
