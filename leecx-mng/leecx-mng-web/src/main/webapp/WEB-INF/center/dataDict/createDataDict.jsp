<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/shiro" prefix="shiro"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  

<script src="<%=request.getContextPath() %>/static/pages/js/dataDict.js?v=3.1415926" type="text/javascript"></script>

	<!-- BEGIN PAGE HEADER-->
	<!-- BEGIN PAGE BAR -->
	<div class="page-bar">
	    <ul class="page-breadcrumb">
	        <li>
	            <span>首页</span>
	            <i class="fa fa-circle"></i>
	        </li>
	        <li>
	            <span>数据字典</span>
	            <i class="fa fa-circle"></i>
	        </li>
	        <li>
	            <span>创建数据字典</span>
	        </li>
	    </ul>
	</div>
	<!-- END PAGE BAR -->
	<!-- END PAGE HEADER-->
                        
	<div class="row">
    	<div class="col-md-12">
			<br/>
			<!-- 用户信息 start -->
			<div class="tabbable-line boxless tabbable-reversed">
            	<div class="portlet box green-jungle">
                	<div class="portlet-title">
                    	<div class="caption">
                    		<i class="icon-user"></i>创建数据字典
                    	</div>
					</div>
					
					<div class="portlet-body form">
					
	                    <!-- BEGIN FORM-->
	                    <form id="dataDictForm" action="" class="form-horizontal" method="post">
							
		                    <div class="form-body">
		                    	<div class="form-group">
		                        	<label class="col-md-3 control-label"><span class="required" aria-required="true"> * </span>字典名称</label>
		                            <div class="col-md-4">
		                            	<div id="input-error">
		                            		<input id="typeName" name="typeName" type="text" class="form-control" value="" />
		                            	</div>
									</div>
								</div>
		                        
								<div class="form-group">
									<label class="col-md-3 control-label"><span class="required" aria-required="true"> * </span>字典码</label>
									<div class="col-md-4">
	                                    <div id="input-error">
	                                        <input id="typeCode" name="typeCode" type="text" class="form-control" value="">
	                                    </div>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-md-3 control-label"><span class="required" aria-required="true"> * </span>key</label>
									<div class="col-md-4">
	                                    <div id="input-error">
	                                        <input id="ddkey" name="ddkey" type="text" class="form-control" value="">
	                                    </div>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-md-3 control-label"><span class="required" aria-required="true"> * </span>value</label>
									<div class="col-md-4">
	                                    <div id="input-error">
	                                        <input id="ddvalue" name="ddvalue" type="text" class="form-control" value="">
	                                    </div>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-md-3 control-label"><span class="required" aria-required="true"> * </span>是否显示</label>
									<div class="col-md-4">
	                                    <div id="input-error">
	                                        <label>
	                                            <input type="radio" name="isShow" class="icheck" value="1" checked="checked"/> 是
	                                        </label>
	                                        
	                                        <label>
	                                            <input type="radio" name="isShow" class="icheck" value="0" /> 否
	                                        </label>
	                                    </div>
									</div>
								</div>
							</div>
	                                                        
							<div class="form-actions">
			                    <div class="row">
			                        <div class="col-md-offset-3 col-md-9">
			                            <button type="submit" class="btn green-jungle">提  交</button>
			                            <button type="reset" class="btn grey-salsa btn-outline">取  消</button>
			                        </div>
			                    </div>
							</div>
						</form>
						<!-- END FORM-->
						
					</div>
				</div>
			</div>
                            
		</div>
	</div>
