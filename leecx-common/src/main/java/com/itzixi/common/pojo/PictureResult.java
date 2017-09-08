package com.itzixi.common.pojo;

/**
 * 
 * @Title: PictureResult.java
 * @Package com.lee.common.pojo
 * @Description: 图片上传结果POJO
 * 	//成功时
 *	{
 *		"error" : 0,
 *	    "url" : "http://www.example.com/path/to/file.ext"
 *	}
 *	//失败时
 *	{
 *	    "error" : 1,
 *	    "message" : "错误信息"
 *	}
 *	
 * Copyright: Copyright (c) 2016
 * Company:Nathan.Lee.Salvatore
 * 
 * @author leechenxiang
 * @date 2016年4月19日 下午3:49:21
 * @version V1.0
 */
public class PictureResult {

	private int error;
	private String url;
	private String urlDB;
	private String message;
	
	
	public int getError() {
		return error;
	}
	public void setError(int error) {
		this.error = error;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUrlDB() {
		return urlDB;
	}
	public void setUrlDB(String urlDB) {
		this.urlDB = urlDB;
	}
	
}
