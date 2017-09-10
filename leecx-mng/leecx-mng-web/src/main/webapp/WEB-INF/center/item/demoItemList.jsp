<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script src="<%=request.getContextPath() %>/static/pages/js/demoItemList.js?v=1.10.2" type="text/javascript"></script>

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
    	<div class="col-md-12">
			<br/>
			
			<div class="jqGridDemoItemList_wrapper">  
			    <table id="jqGridDemoItemList"></table>  
			    <div id="jqGridDemoItemPager"></div>  
			</div>  
			
		</div>
	</div>
	<!-- 用户信息列表 jqgrid end -->

	<!-- ajax 动态 读取model -->	
	<!-- 查看商品信息详情的model -->
	<div id="ajax-detailItemInfo-modal" class="modal container fade" tabindex="-1"></div>
	<!-- 展现修改商品信息的model -->
	<div id="ajax-modifyItem-modal" class="modal container fade" tabindex="-1"></div>
