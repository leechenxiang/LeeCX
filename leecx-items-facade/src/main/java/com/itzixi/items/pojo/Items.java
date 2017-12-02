package com.itzixi.items.pojo;

import java.io.Serializable;

public class Items implements Serializable {
	private static final long serialVersionUID = -3255670677835531509L;

	private String id;

    private String name;

    private Integer counts;
    
    private Integer buyCounts;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

	public Integer getBuyCounts() {
		return buyCounts;
	}

	public void setBuyCounts(Integer buyCounts) {
		this.buyCounts = buyCounts;
	}
}