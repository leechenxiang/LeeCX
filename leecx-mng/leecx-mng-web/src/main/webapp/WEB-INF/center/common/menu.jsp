<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/shiro" prefix="shiro"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- BEGIN CONTAINER -->
    <!-- BEGIN SIDEBAR -->
    <div class="page-sidebar-wrapper">
        <!-- BEGIN SIDEBAR -->
        <div class="page-sidebar navbar-collapse collapse">
            <!-- BEGIN SIDEBAR MENU -->
            <ul class="page-sidebar-menu  page-header-fixed " data-keep-expanded="false" data-auto-scroll="false" data-slide-speed="200" style="padding-top: 20px">
                <!-- DOC: To remove the sidebar toggler from the sidebar you just need to completely remove the below "sidebar-toggler-wrapper" LI element -->
                <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
                <li class="sidebar-toggler-wrapper hide">
                    <div class="sidebar-toggler">
                        <span>
                        	
                        </span>
                    </div>
                </li>
                
               	<!-- 控制台  start -->
               	<li class="nav-item">
                	<a href="<%=request.getContextPath() %>/">
                    	<i class="icon-home"></i>
                        	<span class="title">首页</span>
					</a>
               	</li>
               	
              	<!-- 用户个人信息 start -->
				<li class="nav-item ">
                    <a href="javascript:;" class="nav-link nav-toggle">
                        <i class="icon-user"></i>
                        <span class="title">用户信息</span>
						<span class="arrow"></span>
                    </a>
                    <ul class="sub-menu">
						<li class="nav-item ">
                            <a href="<%=request.getContextPath() %>/user/showCreateUserPage.action" class="ajaxify nav-link ">
                                <span class="title">创建用户</span>
                            </a>
                        </li>
                        <li class="nav-item ">
                            <a href="<%=request.getContextPath() %>/user/showUserInfoListPage.action" class="ajaxify nav-link ">
                                <span class="title">用户列表</span>
                            </a>
                        </li>
                    </ul>
               	</li>
               	
               	<!-- 数据字典管理 start -->
				<li class="nav-item ">
                    <a href="javascript:;" class="nav-link nav-toggle">
                        <i class="icon-notebook"></i>
                        <span class="title">数据字典管理</span>
						<span class="arrow"></span>
                    </a>
                    <ul class="sub-menu">
						<li class="nav-item ">
                            <a href="<%=request.getContextPath() %>/dataDict/showCreateDataDictPage.action" class="ajaxify nav-link ">
                                <span class="title">新建字典</span>
                            </a>
                        </li>
                        <li class="nav-item ">
                            <a href="<%=request.getContextPath() %>/dataDict/showDataDictListPage.action" class="ajaxify nav-link ">
                                <span class="title">字典列表</span>
                            </a>
                        </li>
                    </ul>
               	</li>
               	
               	<!-- 商品信息 start -->
				<li class="nav-item ">
                    <a href="javascript:;" class="nav-link nav-toggle">
                        <i class="icon-basket-loaded"></i>
                        <span class="title">Demo - 商品信息</span>
						<span class="arrow"></span>
                    </a>
                    <ul class="sub-menu">
						<li class="nav-item ">
                            <a href="<%=request.getContextPath() %>/demoItem/showCreateItemPage.action" class="ajaxify nav-link ">
                                <span class="title">创建商品</span>
                            </a>
                        </li>
                        <li class="nav-item ">
                            <a href="<%=request.getContextPath() %>/demoItem/showQueryItemPage.action" class="ajaxify nav-link ">
                                <span class="title">商品列表</span>
                            </a>
                        </li>
                    </ul>
               	</li>
               	
               	<!-- shiro 测试 start -->
				<li class="nav-item ">
                    <a href="javascript:;" class="nav-link nav-toggle">
                        <i class="icon-basket-loaded"></i>
                        <span class="title">shiro 测试</span>
						<span class="arrow"></span>
                    </a>
                    <ul class="sub-menu">
						<li class="nav-item ">
                            <a href="<%=request.getContextPath() %>/shiroTest/shiroPage.action" class="ajaxify nav-link ">
                                <span class="title">shiro 页面</span>
                            </a>
                        </li>
                        <li class="nav-item ">
                            <a href="<%=request.getContextPath() %>/shiroTest/clearCache.action" class="ajaxify nav-link ">
                                <span class="title">清理授权缓存</span>
                            </a>
                        </li>
                    </ul>
               	</li>
				
            </ul>
            <!-- END SIDEBAR MENU -->
        </div>
        <!-- END SIDEBAR -->
    </div>
    <!-- END SIDEBAR -->