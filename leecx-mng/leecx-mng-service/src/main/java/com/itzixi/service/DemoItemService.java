package com.itzixi.service;

import java.util.List;

import com.itzixi.common.pojo.JqGridResult;
import com.itzixi.pojo.DemoItem;

/**
 * 
 * @Title: DemoItemService.java
 * @Package com.itzixi.service
 * @Description: DEMO-商品service
 * Copyright: Copyright (c) 2017
 * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
 * 
 * @author leechenxiang
 * @date 2017年9月8日 下午9:36:52
 * @version V1.0
 */
public interface DemoItemService {

	/**
	 * 
	 * @Title: DemoItemService.java
	 * @Package com.itzixi.service
	 * @Description: 保存商品
	 * Copyright: Copyright (c) 2017
	 * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
	 * 
	 * @author leechenxiang
	 * @date 2017年9月8日 下午9:37:12
	 * @version V1.0
	 */
	public void saveItem(DemoItem item);
	
	/**
	 * 
	 * @Title: DemoItemService.java
	 * @Package com.itzixi.service
	 * @Description: 分页查询商品列表
	 * Copyright: Copyright (c) 2017
	 * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
	 * 
	 * @author leechenxiang
	 * @date 2017年9月9日 下午8:29:29
	 * @version V1.0
	 */
	public JqGridResult queryItemList(Integer page, Integer pageSize);
}
