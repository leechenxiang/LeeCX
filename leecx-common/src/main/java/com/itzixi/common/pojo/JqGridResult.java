package com.itzixi.common.pojo;

import java.util.List;

/**
 * 
 * @Title: JqGridResult.java
 * @Package com.lee.common.pojo
 * @Description: 用来返回jqGrid的数据格式
 * Copyright: Copyright (c) 2016
 * Company:Nathan.Lee.Salvatore
 * 
 * @author leechenxiang
 * @date 2016年4月23日 上午1:37:53
 * @version V1.0
 */
public class JqGridResult {
	
	private int page;			// 当前页数
	private int total;			// 总页数	
	private long records;		// 总记录数
	private List<?> rows;		// 每行显示的内容
	private Object userdata;	// 用户自定义数据
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public long getRecords() {
		return records;
	}
	public void setRecords(long records) {
		this.records = records;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	public Object getUserdata() {
		return userdata;
	}
	public void setUserdata(Object userdata) {
		this.userdata = userdata;
	}

}
