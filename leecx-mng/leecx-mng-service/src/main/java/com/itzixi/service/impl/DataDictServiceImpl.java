package com.itzixi.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itzixi.common.pojo.JqGridResult;
import com.itzixi.mapper.DataDictMapper;
import com.itzixi.pojo.DataDict;
import com.itzixi.pojo.DataDictExample;
import com.itzixi.pojo.DataDictExample.Criteria;
import com.itzixi.service.DataDictService;

@Service
public class DataDictServiceImpl implements DataDictService {
	
	@Autowired
	private DataDictMapper dataDictMapper;
	
	@Override
	public void saveDataDict(DataDict dataDict) {
		
		dataDictMapper.insert(dataDict);
	}

	@Override
	public JqGridResult queryDataDictList(String typeName, String typeCode, Integer page, Integer pageSize) {
		PageHelper.startPage(page, pageSize);
		
		DataDictExample dde = new DataDictExample();
		Criteria dc = dde.createCriteria();
		
		if (StringUtils.isNotEmpty(typeName)) {
			dc.andTypeNameLike("%" + typeName + "%");
		}
		if (StringUtils.isNotEmpty(typeCode)) {
			dc.andTypeCodeLike("%" + typeCode + "%");
		}
		
		List<DataDict> userList = dataDictMapper.selectByExample(dde);
		
		PageInfo<DataDict> pageList = new PageInfo<DataDict>(userList);
		
		JqGridResult grid = new JqGridResult();
		grid.setTotal(pageList.getPages());
		grid.setRows(userList);
		grid.setPage(pageList.getPageNum());
		grid.setRecords(pageList.getTotal());
		
		return grid;
	}

	@Override
	public void deleteDataDictById(Integer ddId) {
		dataDictMapper.deleteByPrimaryKey(ddId);
	}

	@Override
	public void updateDataDictById(DataDict dataDict) {
		dataDictMapper.updateByPrimaryKey(dataDict);
	}

	@Override
	public DataDict queryDataDictById(Integer ddId) {
		return dataDictMapper.selectByPrimaryKey(ddId);
	}
	
}
