package com.itzixi.web.tag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang3.StringUtils;

import com.itzixi.service.DataDictService;
import com.itzixi.web.utils.SpringContextUtil;
import com.itzixi.web.utils.SpringUtils;

/**
 * 
 * @Title: DataDictValueTag.java
 * @Package com.itzixi.web.tag
 * @Description: 自定义数据字典标签，根据typeCode和ddkey获取ddvalue 
 * Copyright: Copyright (c) 2016
 * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
 * 
 * @author leechenxiang
 * @date 2017年9月13日 下午7:20:03
 * @version V1.0
 */
public class DataDictValueTag extends SimpleTagSupport {

	private String typeCode;

	private String ddKey;
	
	StringWriter sw = new StringWriter();
	
	public void doTag() throws JspException, IOException {
		if (StringUtils.isNotEmpty(typeCode) && StringUtils.isNotEmpty(ddKey)) {
			
			DataDictService ddService = (DataDictService)SpringContextUtil.getBean(DataDictService.class);
			String ddValue = ddService.queryDataDictValueByCodeKey(typeCode, ddKey);
			
			JspWriter out = getJspContext().getOut();
			out.println(ddValue);
		} else {
			getJspBody().invoke(sw);
			getJspContext().getOut().println(sw.toString());
		}
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getDdKey() {
		return ddKey;
	}

	public void setDdKey(String ddKey) {
		this.ddKey = ddKey;
	}

}
