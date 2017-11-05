package com.itzixi.web.shiro;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itzixi.pojo.ActiveUser;
import com.itzixi.pojo.SysPermission;
import com.itzixi.pojo.SysUser;
import com.itzixi.service.UserService;

/**
 * 
 * @Title: ShiroDBRealm.java
 * @Package com.itzixi.shiro.realm
 * @Description: 使用自定义realm来实现数据库的用户名密码校验进行登录认证
 * Copyright: Copyright (c) 2017
 * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
 * 
 * @author leechenxiang
 * @date 2017年10月9日 下午8:32:37
 * @version V1.0
 */
@Component
public class ShiroDBRealm extends AuthorizingRealm {
	
	@Autowired
	private UserService userService; 
	
	public ShiroDBRealm(CacheManager cacheManager) {
        super(cacheManager);
    }
	
	/**
	 * 用于登录认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		// 1. 从token中获取用户在表单中输入的域，即 用户名 以及 密码，以此来和数据库中的用户真实数据进行匹配
		UsernamePasswordToken userToken = (UsernamePasswordToken)token;
		String username = userToken.getUsername();							// 用户的登录名
		String password = String.valueOf(userToken.getPassword());			// 用户的密码
		
		// 2. 根据用户输入的用户名和数据库进行匹配，查询数据库中的用户，如果查询不到，则返回一个null
		SysUser user = userService.queryUserByUsername(username);
		
		// 3. 判断数据库中查询出来的用户是否存在，不存在代表用户名密码错误；如果存在，则返回 AuthenticationInfo
		if (user == null) {
			return null;
		}
		
		String dbPassword = user.getPassword();
		String dbSalt = user.getAuthSalt();
		String userPassword = ShiroPasswordUtil.getShiroPassword(password, dbSalt, 2);
		
		if (!userPassword.equals(dbPassword)) {
			// 抛出一个异常，密码不正确
			throw new IncorrectCredentialsException();
		}
		
		ActiveUser activeUser = new ActiveUser();
		activeUser.setUserId(user.getId());
		activeUser.setUsername(user.getUsername());
		
		// 4. 返回AuthenticationInfo
		// 参数意义：
		// Object principal: 用户对象，可以使一个对象类，或者一个字符串，存与session中 
		// Object credentials：密码 			
		// 							题外话：我们目前直接根据用户名密码来查询，所以这里直接放用户输入的密码即可；但是，也可疑直接用用户名来查询数据库中的用户，再然后进行密码的比对，如此则此处应该填写用户输入的密码
		// String realmName：当前我们自定义realm的名称
		AuthenticationInfo info = new SimpleAuthenticationInfo(activeUser, password, getName());
		return info;
	}
	
	/**
	 * 用于授权鉴权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		// 从principals中获取当前用户
		ActiveUser sessionUser = (ActiveUser)principals.getPrimaryPrincipal();
		String userid = sessionUser.getUserId();
		
		// 模拟从数据库中获取用户的权限（资源权限字符串）
		List<SysPermission> permissionList = null;
		try {
			permissionList = userService.findPermissionListByUserId(userid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<String> percodeList = new ArrayList<String>();
		for (SysPermission p : permissionList) {
			percodeList.add(p.getPercode());
		}
		
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		simpleAuthorizationInfo.addStringPermissions(percodeList);
		
		return simpleAuthorizationInfo;
	}

	/**
	 * 
	 * @Description: 权限修改生效后，立即刷新清空缓存，则可以实现用户不退出生效新的权限
	 * 
	 * @author leechenxiang
	 * @date 2016年9月29日 下午9:34:07
	 */
	public void clearCache() {
		PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
		super.clearCache(principals);
	}
}

