package com.itzixi.service;

import com.itzixi.common.pojo.JqGridResult;
import com.itzixi.pojo.DataDict;
import com.itzixi.pojo.SysUser;

/**
 * 
 * @Title: UserService.java
 * @Package com.itzixi.service
 * @Description: 处理数据字典的service
 * Copyright: Copyright (c) 2016
 * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
 * 
 * @author leechenxiang
 * @date 2017年9月5日 上午11:07:39
 * @version V1.0
 */
public interface DataDictService {

	/**
	 * 
	 * @Description: 保存数据字典
	 * @param dataDict
	 * 
	 * @author leechenxiang
	 * @date 2017年9月5日 上午11:13:38
	 */
	public void saveDataDict(DataDict dataDict);
	
	/**
	 * 
	 * @Description: 查询数据字典列表
	 * @param ddname
	 * @param ddcode
	 * @return
	 * 
	 * @author leechenxiang
	 * @date 2017年9月5日 上午11:14:46
	 */
	public JqGridResult queryDataDictList(String typeName, String typeCode, Integer page, Integer pageSize);
	
	/**
	 * 
	 * @Description: 删除数据字典
	 * @param ddId
	 * 
	 * @author leechenxiang
	 * @date 2017年9月5日 上午11:14:55
	 */
	public void deleteDataDictById(Integer ddId);
	
	/**
	 * 
	 * @Description: 查询数据字典
	 * @param ddId
	 * 
	 * @author leechenxiang
	 * @date 2017年9月12日 下午4:08:49
	 */
	public DataDict queryDataDictById(Integer ddId);
	
	/**
	 * 
	 * @Description: 修改数据字典
	 * @param dataDict
	 * 
	 * @author leechenxiang
	 * @date 2017年9月5日 上午11:15:03
	 */
	public void updateDataDictById(DataDict dataDict);
	
}
