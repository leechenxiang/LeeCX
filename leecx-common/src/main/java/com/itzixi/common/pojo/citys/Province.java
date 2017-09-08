package com.itzixi.common.pojo.citys;

import java.util.List;

public class Province {

	private String p;

	private List<?> c;

	public Province() {
		super();
	}
	
	public Province(String p, List<?> c) {
		super();
		this.p = p;
		this.c = c;
	}

	public String getP() {
		return p;
	}

	public void setP(String p) {
		this.p = p;
	}

	public List<?> getC() {
		return c;
	}

	public void setC(List<?> c) {
		this.c = c;
	}
}
