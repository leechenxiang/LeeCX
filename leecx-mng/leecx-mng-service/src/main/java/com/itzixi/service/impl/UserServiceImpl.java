package com.itzixi.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itzixi.common.enums.YesOrNo;
import com.itzixi.common.pojo.JqGridResult;
import com.itzixi.mapper.SysUserMapper;
import com.itzixi.pojo.SysUser;
import com.itzixi.pojo.SysUserExample;
import com.itzixi.pojo.SysUserExample.Criteria;
import com.itzixi.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private SysUserMapper userMapper;
	
	@Autowired
	private Sid sid;

	@Override
	public void saveUser(SysUser user) {
		
		String userId = sid.nextShort();
		user.setId(userId);
		userMapper.insert(user);
	}

	@Override
	public JqGridResult queryUserList(String username, Integer page, Integer pageSize) {
		
		PageHelper.startPage(page, pageSize);
		
		SysUserExample ue = new SysUserExample();
		Criteria uc = ue.createCriteria();
		
		if (StringUtils.isNotEmpty(username)) {
			uc.andUsernameLike("%" + username + "%");
		}
		
		uc.andIsDeleteEqualTo(YesOrNo.NO.value);
		
		List<SysUser> userList = userMapper.selectByExample(ue);
		
		PageInfo<SysUser> pageList = new PageInfo<SysUser>(userList);
		
		JqGridResult grid = new JqGridResult();
		grid.setTotal(pageList.getPages());
		grid.setRows(userList);
		grid.setPage(pageList.getPageNum());
		grid.setRecords(pageList.getTotal());
		
		return grid;
	}

	@Override
	public SysUser queryUserInfoById(String userId) {
		SysUser user = userMapper.selectByPrimaryKey(userId);
		return user;
	}

	@Override
	public void deleteUserById(String userId) {
//		userMapper.deleteByPrimaryKey(userId);
		
		SysUser user = new SysUser();
		user.setId(userId);
		user.setIsDelete(YesOrNo.YES.value);
		userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public void updateUserById(SysUser user) {
		userMapper.updateByPrimaryKeySelective(user);
	}
	
	@Override
	public boolean queryNicknameIsExist(String nickname, String userId) {
		
		SysUserExample userExample = new SysUserExample();
		Criteria userCriteria = userExample.createCriteria();
		userCriteria.andNicknameEqualTo(nickname);
		
		if (StringUtils.isNotEmpty(userId)) {
			userCriteria.andIdNotEqualTo(userId);
		}
		
		int counts = userMapper.countByExample(userExample);
		return counts > 0;
	}

	@Override
	public boolean queryUsernameIsExist(String username, String userId) {
		
		SysUserExample userExample = new SysUserExample();
		Criteria userCriteria = userExample.createCriteria();
		userCriteria.andUsernameEqualTo(username);
		
		if (StringUtils.isNotEmpty(userId)) {
			userCriteria.andIdNotEqualTo(userId);
		}
		
		int counts = userMapper.countByExample(userExample);
		return counts > 0;
	}
}
