package com.itzixi.items.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itzixi.items.mapper.ItemsMapper;
import com.itzixi.items.pojo.Items;
import com.itzixi.items.service.ItemsService;

@Service("itemsService")
public class ItemsServiceImpl implements ItemsService {
	
	@Autowired
	private ItemsMapper itemsMapper;

	@Override
	public boolean displayReduceCounts(int buyCounts) {
		System.out.println("dubbo123");
		return false;
	}

	@Override
	public Items getItem(String itemId) {
		return itemsMapper.selectByPrimaryKey(itemId);
	}

}

