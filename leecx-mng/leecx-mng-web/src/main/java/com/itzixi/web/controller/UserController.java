package com.itzixi.web.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.itzixi.common.enums.YesOrNo;
import com.itzixi.common.pojo.JqGridResult;
import com.itzixi.common.utils.LeeJSONResult;
import com.itzixi.common.utils.NumberUtil;
import com.itzixi.pojo.DataDict;
import com.itzixi.pojo.SysUser;
import com.itzixi.service.DataDictService;
import com.itzixi.service.UserService;

/**
 * 
 * @Title: UserController.java
 * @Package com.itzixi.web.controller
 * @Description: 用户 controller
 * Copyright: Copyright (c) 2016
 * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
 * 
 * @author leechenxiang
 * @date 2017年9月5日 下午2:10:15
 * @version V1.0
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	
	final static Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private DataDictService ddService;
	
	/**
	 * 
	 * @Description: 打开新增用户页面
	 * @param userId
	 * @param request
	 * @return
	 * 
	 * @author leechenxiang
	 * @date 2017年9月5日 下午3:31:42
	 */
	@RequestMapping("/showCreateUserPage")
	public ModelAndView showCreateUserPage(String userId, HttpServletRequest request){
		
		log.debug("显示用户个人信息页面");
		
		List<DataDict> ddlist = ddService.queryDataDictListByTypeCode("job");
		
		ModelAndView mv = new ModelAndView("user/createUser");
		mv.addObject("ddlist", ddlist);
		
		return mv;
	}
	
	/**
	 * 
	 * @Description: 创建用户 或者 更新用户
	 * @param user
	 * @return
	 * 
	 * @author leechenxiang
	 * @date 2017年9月5日 下午4:39:32
	 */
	@RequestMapping("/saveOrUpdate")
	@ResponseBody
	public LeeJSONResult saveOrUpdate(SysUser user){
		
		// 用户id不为空，则修改用户；用户id为空，则新建用户
		String userId = user.getId();
		if (StringUtils.isEmpty(userId)) {
			// 生成4位随机组合字符作为权限的盐
			String authSalt = NumberUtil.getStringRandom(4);
			
			// 保存用户操作
			user.setAuthSalt(authSalt);
			user.setRegistTime(new Date());
			user.setIsDelete(YesOrNo.NO.value);
			userService.saveUser(user);
		} else {
			userService.updateUserById(user);
		}
		
		return LeeJSONResult.ok();
	}
	
	/**
	 * 
	 * @Description: 显示用户信息列表页面
	 * @param request
	 * @return
	 * 
	 * @author leechenxiang
	 * @date 2017年9月6日 下午2:31:22
	 */
	@RequestMapping("/showUserInfoListPage")
	public String showUserInfoListPage(HttpServletRequest request){
		
		return "user/userInfoList";
	}
	
	/**
	 * 
	 * @Description: 条件查询用户列表
	 * @param user
	 * @param page
	 * @return
	 * 
	 * @author leechenxiang
	 * @date 2017年9月6日 上午11:19:39
	 */
	@RequestMapping("/getUserInfoList")
	@ResponseBody
	public JqGridResult getUserInfoList(SysUser user, Integer page){
		
		if (page == null) {
			page = 1;
		}
		
		JqGridResult result = userService.queryUserList(user, page, pageSize);
		
		return result;
	}
	
	/**
	 * 
	 * @Description: 查询用户详情
	 * @param userId
	 * @param request
	 * @return
	 * 
	 * @author leechenxiang
	 * @date 2017年9月5日 下午2:10:04
	 */
	@RequestMapping("/userInfo")
	public ModelAndView showUserInfo(String userId, HttpServletRequest request){
		
		// 查询用户个人信息
		SysUser userInfo = userService.queryUserInfoById(userId);
		
		ModelAndView mv = new ModelAndView("user/userDetail");
		mv.addObject("userInfo", userInfo);
		mv.addObject("num", 12500);
		
		return mv;
	}
	
	/**
	 * 
	 * @Description: 跳转到修改用户页面
	 * @param userId
	 * @param request
	 * @return
	 * 
	 * @author leechenxiang
	 * @date 2017年9月5日 下午2:10:04
	 */
	@RequestMapping("/modifyUser")
	public ModelAndView showModifyUser(String userId, HttpServletRequest request){
		
		// 查询用户个人信息
		SysUser userInfo = userService.queryUserInfoById(userId);
		
		List<DataDict> ddlist = ddService.queryDataDictListByTypeCode("job");
		
		ModelAndView mv = new ModelAndView("user/modifyUser");
		mv.addObject("userInfo", userInfo);
		mv.addObject("ddlist", ddlist);
		
		return mv;
	}
	
	/**
	 * 
	 * @Description: 删除用户
	 * @param userId
	 * @return
	 * 
	 * @author leechenxiang
	 * @date 2017年9月6日 下午3:26:32
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public LeeJSONResult update(String userId){
		
		userService.deleteUserById(userId);
		
		return LeeJSONResult.ok();
	}
	
	/**
	 * 
	 * @Description: 用户修改昵称查询是否存在
	 * @param nickname
	 * @param userId
	 * @return
	 * 
	 * @author leechenxiang
	 * @date 2017年3月13日 下午7:53:19
	 */
	@RequestMapping("/nicknameIsExist")
	@ResponseBody
	public LeeJSONResult nicknameIsExist(String nickname, String userId) {
		
		boolean isExist = userService.queryNicknameIsExist(nickname, userId);
		return LeeJSONResult.ok(isExist);
	}
	
	/**
	 * 
	 * @Description: 用户名/登录名 是否是否存在
	 * @param username
	 * @return
	 * 
	 * @author leechenxiang
	 * @date 2017年9月5日 下午4:24:35
	 */
	@RequestMapping("/usernameIsExist")
	@ResponseBody
	public LeeJSONResult usernameIsExist(String username, String userId) {
		
		boolean isExist = userService.queryUsernameIsExist(username, userId);
		return LeeJSONResult.ok(isExist);
	}

}
