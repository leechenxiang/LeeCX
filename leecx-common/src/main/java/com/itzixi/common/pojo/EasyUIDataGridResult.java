package com.itzixi.common.pojo;

import java.util.List;

/**
 * 
 * @Title: EUDataGridResult.java
 * @Package com.lee.common.pojo
 * @Description: 用来返回EasyUI的数据格式
 * 				(EasyUIDataGrid只接受这样的格式)
 * Copyright: Copyright (c) 2016
 * Company:Nathan.Lee.Salvatore
 * 
 * @author leechenxiang
 * @date 2016年4月15日 下午3:19:06
 * @version V1.0
 */
public class EasyUIDataGridResult {
	
	private long total;			// 分页的总记录数	
	private List<?> rows;		// 每行显示的内容

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

}
