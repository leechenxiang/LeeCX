<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="/dataDict" prefix="dataDict" %>
<%@ taglib uri="/shiro" prefix="shiro"%>

<!-- BEGIN PAGE HEADER-->
	<!-- BEGIN PAGE BAR -->
	<div class="page-bar">
	    <ul class="page-breadcrumb">
	        <li>
	            <span>首页</span>
	            <i class="fa fa-circle"></i>
	        </li>
	        <li>
	            <span>shiro 测试</span>
	            <i class="fa fa-circle"></i>
	        </li>
	        <li>
	            <span>shiro page</span>
	        </li>
	    </ul>
	</div>
	<!-- END PAGE BAR -->
	<!-- END PAGE HEADER-->

	Hello Shiro
	<br/><br/>
	
	当前登录的主体用户名为：<shiro:principal property="username"></shiro:principal>
	
	<br/><br/>
	
	用户是否认证登录过：<shiro:authenticated>是的</shiro:authenticated> <shiro:notAuthenticated>没有</shiro:notAuthenticated>
	
	<br/><br/>
	
	是否游客：<shiro:guest>guest</shiro:guest>
	
	<br/><br/>
	
	是否登陆或者记住我:<shiro:user>user 记住我</shiro:user>
	
	<br/><br/>
	
	用户含有单一的资源权限：<shiro:hasPermission name="appuser:check">appuser:check</shiro:hasPermission>
	
	<br/><br/>
	
	用户是否含有多个权限，如果含有其中一个或者多个，则显示：<shiro:hasAnyPermission name="appuser:mng,appuser:getPersonal,appuser:toCheck,appuser:check,company:mng">appuser:mng,appuser:getPersonal,appuser:toCheck,appuser:check,company:mng</shiro:hasAnyPermission>
	
	<br/><br/>
	