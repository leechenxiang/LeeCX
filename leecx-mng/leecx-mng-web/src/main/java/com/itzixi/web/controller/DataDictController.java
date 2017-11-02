package com.itzixi.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.itzixi.common.pojo.JqGridResult;
import com.itzixi.common.utils.LeeJSONResult;
import com.itzixi.pojo.DataDict;
import com.itzixi.service.DataDictService;

/**
 * 
 * @Title: DataDictController.java
 * @Package com.itzixi.web.controller
 * @Description: 数据字典 controller
 * Copyright: Copyright (c) 2016
 * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
 * 
 * @author leechenxiang
 * @date 2017年9月5日 下午2:10:15
 * @version V1.0
 */
@Controller
@RequestMapping("/dataDict")
public class DataDictController extends BaseController {
	
	final static Logger log = LoggerFactory.getLogger(DataDictController.class);
	
	@Autowired
	private DataDictService dataDictService;
	
	/**
	 * 
	 * @Description: 打开新增数据字典页面
	 * @param userId
	 * @param request
	 * @return
	 * 
	 * @author leechenxiang
	 * @date 2017年9月5日 下午3:31:42
	 */
	@RequestMapping("/showCreateDataDictPage")
	public String showCreateUserPage(String userId, HttpServletRequest request){
		
		log.debug("显示数据字典页面");
		
		return "dataDict/createDataDict";
	}
	
	/**
	 * 
	 * @Description: 创建数据字典 或者 更新数据字典
	 * @param user
	 * @return
	 * 
	 * @author leechenxiang
	 * @date 2017年9月5日 下午4:39:32
	 */
	@RequestMapping("/saveOrUpdate")
	@ResponseBody
	public LeeJSONResult saveOrUpdate(DataDict dd){
		
		// 数据字典id不为空，则修改数据字典；数据字典id为空，则新建数据字典
		Integer ddId = dd.getId();
		if (ddId != null && ddId > 0) {
			dataDictService.updateDataDictById(dd);
		} else {
			dataDictService.saveDataDict(dd);
		}
		
		return LeeJSONResult.ok();
	}
	
	/**
	 * 
	 * @Description: 显示数据字典信息列表页面
	 * @param request
	 * @return
	 * 
	 * @author leechenxiang
	 * @date 2017年9月6日 下午2:31:22
	 */
	@RequestMapping("/showDataDictListPage")
	public String showDataDictListPage(HttpServletRequest request){
		
		return "dataDict/dataDictList";
	}
	
	/**
	 * 
	 * @Description: 条件查询数据字典列表
	 * @param user
	 * @param page
	 * @return
	 * 
	 * @author leechenxiang
	 * @date 2017年9月6日 上午11:19:39
	 */
	@RequestMapping("/getDataDictList")
	@ResponseBody
	public JqGridResult getDataDictList(DataDict dataDict, Integer page){
		
		if (page == null) {
			page = 1;
		}
		
		JqGridResult result = dataDictService.queryDataDictList(null, null, page, pageSize);
		
		return result;
	}
	
	/**
	 * 
	 * @Description: 跳转到修改数据字典页面
	 * @param userId
	 * @param request
	 * @return
	 * 
	 * @author leechenxiang
	 * @date 2017年9月5日 下午2:10:04
	 */
	@RequestMapping("/modifyDataDict")
	public ModelAndView modifyDataDict(Integer ddId, HttpServletRequest request){
		
		// 查询数据字典个人信息
		DataDict dataDict = dataDictService.queryDataDictById(ddId);
		
		ModelAndView mv = new ModelAndView("dataDict/modifyDataDict");
		mv.addObject("dataDict", dataDict);
		
		return mv;
	}
	
	/**
	 * 
	 * @Description: 删除数据字典
	 * @param userId
	 * @return
	 * 
	 * @author leechenxiang
	 * @date 2017年9月6日 下午3:26:32
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public LeeJSONResult delete(Integer ddId){
		
		dataDictService.deleteDataDictById(ddId);
		
		return LeeJSONResult.ok();
	}
	
	/**
	 * 
	 * @Title: DataDictController.java
	 * @Package com.itzixi.web.controller
	 * @Description: 用作redis测试的接口
	 * Copyright: Copyright (c) 2017
	 * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
	 * 
	 * @author leechenxiang
	 * @date 2017年9月18日 下午8:55:32
	 * @version V1.0
	 */
	@RequestMapping("/testRedis")
	@ResponseBody
	public LeeJSONResult testRedis(DataDict dd){
		
		jedis.set("test_me_redis", "hello redis~~~");
		String hello = jedis.get("test_me_redis");
		
		return LeeJSONResult.ok(hello);
	}
	
	/**
	 * 
	 * @Title: DataDictController.java
	 * @Package com.itzixi.web.controller
	 * @Description: api接口： 根据字典码和ddkey获取数据字典的值
	 * Copyright: Copyright (c) 2017
	 * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
	 * 
	 * @author leechenxiang
	 * @date 2017年9月18日 下午9:39:03
	 * @version V1.0
	 */
	@RequestMapping("/queryDataDictValue")
	@ResponseBody
	public LeeJSONResult queryDataDictValue(String typeCode, String ddkey){
		
		String ddvalue = dataDictService.queryDataDictValueByCodeKey(typeCode, ddkey);
		
		return LeeJSONResult.ok(ddvalue);
	}
}
