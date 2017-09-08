package com.itzixi.common.pojo.echarts;

import java.util.List;

public class EChartResult {
	
	private Title title;
	private XAxis xAxis;	
	private List<Series> series;
	
	public XAxis getxAxis() {
		return xAxis;
	}
	public void setxAxis(XAxis xAxis) {
		this.xAxis = xAxis;
	}
	public Title getTitle() {
		return title;
	}
	public void setTitle(Title title) {
		this.title = title;
	}
	public List<Series> getSeries() {
		return series;
	}
	public void setSeries(List<Series> series) {
		this.series = series;
	}

}
