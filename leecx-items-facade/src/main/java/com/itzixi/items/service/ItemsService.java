package com.itzixi.items.service;

import com.itzixi.items.pojo.Items;

public interface ItemsService {

	public Items getItem(String itemId);
	
	public boolean displayReduceCounts(int buyCounts);

}

