package com.itzixi.service;

import java.util.List;

import com.itzixi.common.pojo.JqGridResult;
import com.itzixi.pojo.SysPermission;
import com.itzixi.pojo.SysUser;

/**
 * 
 * @Title: UserService.java
 * @Package com.itzixi.service
 * @Description: 处理用户的service
 * Copyright: Copyright (c) 2016
 * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
 * 
 * @author leechenxiang
 * @date 2017年9月5日 上午11:07:39
 * @version V1.0
 */
public interface UserService {

	/**
	 * 
	 * @Description: 保存用户
	 * @param user
	 * 
	 * @author leechenxiang
	 * @date 2017年9月5日 上午11:13:38
	 */
	public boolean saveUser(SysUser user);
	
	/**
	 * 
	 * @Description: 查询用户列表
	 * @param username
	 * @return
	 * 
	 * @author leechenxiang
	 * @date 2017年9月5日 上午11:14:46
	 */
	public JqGridResult queryUserList(SysUser user, Integer page, Integer pageSize);
	
	/**
	 * 
	 * @Description: 查询用户详细信息
	 * @param userId
	 * 
	 * @author leechenxiang
	 * @date 2017年9月5日 上午11:14:55
	 */
	public SysUser queryUserInfoById(String userId);
	
	/**
	 * 
	 * @Description: 删除用户
	 * @param userId
	 * 
	 * @author leechenxiang
	 * @date 2017年9月5日 上午11:14:55
	 */
	public void deleteUserById(String userId);
	
	/**
	 * 
	 * @Description: 修改用户
	 * @param user
	 * 
	 * @author leechenxiang
	 * @date 2017年9月5日 上午11:15:03
	 */
	public void updateUserById(SysUser user);
	
	/**
	 * 
	 * @Description: 检查昵称是否存在
	 * @param nickname
	 * @return
	 * 
	 * @author leechenxiang
	 * @date 2017年9月5日 下午4:22:48
	 */
	public boolean queryNicknameIsExist(String nickname, String userId);
	
	/**
	 * 
	 * @Description: 检查昵称是否存在
	 * @param username
	 * @return
	 * 
	 * @author leechenxiang
	 * @date 2017年9月5日 下午4:23:18
	 */
	public boolean queryUsernameIsExist(String username, String userId);
	
	/**
	 * 
	 * @Title: UserService.java
	 * @Package com.itzixi.service
	 * @Description: 根据用户查询用户信息，如果查不到，则返回空，用于登录查询
	 * Copyright: Copyright (c) 2017
	 * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
	 * 
	 * @author leechenxiang
	 * @date 2017年10月19日 下午9:06:41
	 * @version V1.0
	 */
	public SysUser queryUserByUsername(String username);
	
	/**
	 * 
	 * @Title: UserService.java
	 * @Package com.itzixi.service
	 * @Description: 根据用户id查询用户的权限资源字符串percode
	 * Copyright: Copyright (c) 2017
	 * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
	 * 
	 * @author leechenxiang
	 * @date 2017年10月22日 下午9:35:34
	 * @version V1.0
	 */
	public List<SysPermission> findPermissionListByUserId(String userid) throws Exception ;
}
