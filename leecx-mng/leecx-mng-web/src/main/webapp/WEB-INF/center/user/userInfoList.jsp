<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script src="<%=request.getContextPath() %>/static/pages/js/userInfoList.js?v=1.0.3" type="text/javascript"></script>

	<!-- BEGIN PAGE HEADER-->
	<!-- BEGIN PAGE BAR -->
	<div class="page-bar">
	    <ul class="page-breadcrumb">
	        <li>
	            <span>首页</span>
	            <i class="fa fa-circle"></i>
	        </li>
	        <li>
	            <span>用户信息</span>
	            <i class="fa fa-circle"></i>
	        </li>
	        <li>
	            <span>用户列表</span>
	        </li>
	    </ul>
	</div>
	<!-- END PAGE BAR -->
	<!-- END PAGE HEADER-->
        
    <!-- 用户信息列表 jqgrid start -->                
	<div class="row">
	
		<!-- 搜索内容 -->
		<div class="col-md-12">
			<br/>
			
				<form id="searchUserInfoListForm" action="<%=request.getContextPath() %>/admin/userInfo/queryAllUserList.shtml" class="form-inline" method="post" role="form">
					<div class="form-group">
						<label class="sr-only" for="username">用户名:</label>
						<input id="username" name="username" type="text" class="form-control" placeholder="用户名" />
					</div>
					<div class="form-group">
						<label class="sr-only" for="nickname">昵称:</label>
						<input id="nickname" name="nickname" type="text" class="form-control" placeholder="昵称" />
					</div>
					<div class="form-group">
						<label class="sr-only" for="sex">性别:</label>
					 	<select class="form-control" id="sex" name="sex">
	                    	<option value="" >选择性别</option>
	                        <option value="0" >女</option>
							<option value="1" >男</option>
	                	</select>
					</div>
					<button id="searchUserListButton" class="btn yellow-casablanca" type="button">搜    索</button>
				</form>
			</div>
	
	
    	<div class="col-md-12">
			<br/>
			
			<div class="jqGridUserInfoList_wrapper">  
			    <table id="jqGridUserInfoList"></table>  
			    <div id="jqGridUserInfoPager"></div>  
			</div>  
			
		</div>
	</div>
	<!-- 用户信息列表 jqgrid end -->

	<!-- ajax 动态 读取model -->	
	<!-- 查看用户信息详情的modal -->
	<div id="ajax-detailUserInfo-modal" class="modal container fade" tabindex="-1"> </div>
	<!-- 编辑用户信息modal -->
	<div id="ajax-modifyUserInfo-modal" class="modal container fade" tabindex="-1"> </div>
	
