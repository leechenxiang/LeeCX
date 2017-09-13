<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/shiro" prefix="shiro"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@ taglib uri="/dataDict" prefix="dataDict" %>  

<script src="<%=request.getContextPath() %>/static/citys/js/distpicker.data.js?v=3.1415926"></script>
<script src="<%=request.getContextPath() %>/static/citys/js/distpicker.js?v=3.1415926"></script>
<script src="<%=request.getContextPath() %>/static/pages/js/userInfo.js?v=3.1415926" type="text/javascript"></script>

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
	            <span>创建用户</span>
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
                    		<i class="icon-user"></i>创建用户
                    	</div>
					</div>
					
					<div class="portlet-body form">
					
	                    <!-- BEGIN FORM-->
	                    <form id="userInfoForm" action="" class="form-horizontal" method="post">
							
		                    <div class="form-body">
		                    	<div class="form-group">
		                        	<label class="col-md-3 control-label"><span class="required" aria-required="true"> * </span>用户名 /登录名</label>
		                            <div class="col-md-4">
		                            	<div id="input-error">
		                            		<input id="username" name="username" type="text" class="form-control" value="" />
		                            	</div>
									</div>
								</div>
		                        
		                        <div class="form-group">
									<label class="col-md-3 control-label"><span class="required" aria-required="true"> * </span>密码</label>
									<div class="col-md-4">
	                                    <div id="input-error">
	                                        <input id="password" name="password" type="text" class="form-control" value="">
	                                    </div>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-md-3 control-label"><span class="required" aria-required="true"> * </span>确认密码</label>
									<div class="col-md-4">
	                                    <div id="input-error">
	                                        <input id="confirmPassword" name="confirmPassword" type="text" class="form-control" value="">
	                                    </div>
									</div>
								</div>
								                        
								<div class="form-group">
									<label class="col-md-3 control-label"><span class="required" aria-required="true"> * </span>昵称</label>
									<div class="col-md-4">
	                                    <div id="input-error">
	                                        <input id="nickname" name="nickname" type="text" class="form-control" value="">
	                                    </div>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-md-3 control-label">年龄</label>
									<div class="col-md-4">
	                                    <div id="input-error">
	                                        <input id="age" name="age" type="text" class="form-control" value="">
	                                    </div>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-md-3 control-label">性别</label>
									<div class="col-md-4">
	                                    <div id="input-error">
	                                        <label>
	                                            <input type="radio" name="sex" class="icheck" value="0" /> <dataDict:dataDictValue typeCode="sex" ddKey="0"/>
	                                        </label>
	                                        
	                                        <label>
	                                            <input type="radio" name="sex" class="icheck" value="1" /> <dataDict:dataDictValue typeCode="sex" ddKey="1"/>
	                                        </label>
	                                         
	                                        <label>
	                                            <input type="radio" name="sex" class="icheck" value="2" checked="checked"/> <dataDict:dataDictValue typeCode="sex" ddKey="2"/>
	                                        </label>
	                                    </div>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-md-3 control-label">职业</label>
									<div class="col-md-4">
	                                    <div id="input-error">
	                                        <select class="form-control" id="job" name="job">
				                                <option value="0">请选择</option>
				                                
				                                <!-- 
				                                <option value="1" >Java开发</option>
												<option value="2" >前端开发</option>
												<option value="3" >大数据开发</option>
												<option value="4" >ios开发</option>
												<option value="5" >Android开发</option>
												<option value="6" >Linux系统工程师</option>
												<option value="7" >PHP开发</option>
												<option value="8" >.net开发</option>
												<option value="9" >C/C++</option>
												<option value="10" >学生</option>
												<option value="11" >其它</option>
												 -->
												<c:forEach items="${ddlist }" var="dd">
													<option value="${dd.ddkey }" >${dd.ddvalue }</option>
												</c:forEach>
				                            </select>
	                                    </div>
									</div>
								</div>
								
								   
								<div class="form-group">
									<label class="col-md-3 control-label">居住地点</label>
									<div data-toggle="distpicker">
										<div class="col-md-2">
		                                    <div id="input-error">
												<select class="form-control" name="province" data-province=""></select>
		                                    </div>
										</div>
										<div class="col-md-2">
		                                    <div id="input-error">
												<select class="form-control" name="city" data-city=""></select>
		                                    </div>
										</div>
										<div class="col-md-2">
		                                    <div id="input-error">
												<select class="form-control" name="district" data-district=""></select>
		                                    </div>
										</div>
									</div>
								</div>              
									                  
								<div class="form-group">
									<label class="col-md-3 control-label">详细地址</label>
									<div class="col-md-4">
										<div class="input-group">
											<div id="input-error">
												<textarea id="address" name="address" class="form-control" rows="6" cols="70" placeholder="详细地址，如：“平江区观前街XX号”"></textarea>
											</div>
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
