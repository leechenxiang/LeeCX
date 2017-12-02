<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/dataDict" prefix="dataDict" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="<%=request.getContextPath() %>/static/citys/js/distpicker.data.js?v=3.1415926"></script>
<script src="<%=request.getContextPath() %>/static/citys/js/distpicker.js?v=3.1415926"></script>
<script src="<%=request.getContextPath() %>/static/pages/js/userInfo.js?v=3.1415926" type="text/javascript"></script>

<form id="userInfoForm" action="" class="form-horizontal" method="post">
	<input id="userId" name="id" type="hidden" value="${userInfo.id }" />

	<div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
	    <h4 class="modal-title">修改用户信息</h4>
	</div>
	<div class="modal-body">
	    <div class="row">
	        <div class="col-md-12">
							
                    <div class="form-body">
                    	<div class="form-group">
                        	<label class="col-md-3 control-label"><span class="required" aria-required="true"> * </span>用户名 /登录名</label>
                            <div class="col-md-4">
                            	<div id="input-error">
                            		<input id="username" name="username" type="text" class="form-control" value="${userInfo.username }" />
                            	</div>
							</div>
						</div>
                        
                        <div class="form-group">
							<label class="col-md-3 control-label"><span class="required" aria-required="true"> * </span>密码</label>
							<div class="col-md-4">
                                   <div id="input-error">
                                       <input id="password" name="password" type="text" class="form-control" value="${userInfo.password }">
                                   </div>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-md-3 control-label"><span class="required" aria-required="true"> * </span>确认密码</label>
							<div class="col-md-4">
                                   <div id="input-error">
                                       <input id="confirmPassword" name="confirmPassword" type="text" class="form-control" value="${userInfo.password }">
                                   </div>
							</div>
						</div>
						                        
						<div class="form-group">
							<label class="col-md-3 control-label"><span class="required" aria-required="true"> * </span>昵称</label>
							<div class="col-md-4">
                                   <div id="input-error">
                                       <input id="nickname" name="nickname" type="text" class="form-control" value="${userInfo.nickname }">
                                   </div>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-md-3 control-label">年龄</label>
							<div class="col-md-4">
                                   <div id="input-error">
                                       <input id="age" name="age" type="text" class="form-control" value="${userInfo.age }">
                                   </div>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-md-3 control-label">性别</label>
							<div class="col-md-4">
                                   <div id="input-error">
                                       <label>
                                           <input type="radio" name="sex" class="icheck" value="0" ${(userInfo.sex== '0') ? "checked='checked'" : ""}/> <dataDict:dataDictValue typeCode="sex" ddKey="0"/>
                                       </label>
                                       
                                       <label>
                                           <input type="radio" name="sex" class="icheck" value="1" ${(userInfo.sex== '1') ? "checked='checked'" : ""}/> <dataDict:dataDictValue typeCode="sex" ddKey="1"/>
                                       </label>
                                        
                                       <label>
                                           <input type="radio" name="sex" class="icheck" value="2" ${(userInfo.sex== '2') ? "checked='checked'" : ""}/> <dataDict:dataDictValue typeCode="sex" ddKey="2"/>
                                       </label>
                                   </div>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-md-3 control-label">职业</label>
							<div class="col-md-4">
                            	<div id="input-error">
                                   <select class="form-control" id="job" name="job">
		                                <option value="0" ${(userInfo.job== '0') ? "selected" : ""}>请选择</option>
		                                
		                                <c:forEach items="${ddlist }" var="dd">
											<option value="${dd.ddkey }" ${(userInfo.job== dd.ddkey) ? "selected" : ""}>${dd.ddvalue }</option>
										</c:forEach>
		                                
<%-- 		                                <option value="1" ${(userInfo.job== '1') ? "selected" : ""}>Java开发</option> --%>
<%-- 										<option value="2" ${(userInfo.job== '2') ? "selected" : ""}>前端开发</option> --%>
<%-- 										<option value="3" ${(userInfo.job== '3') ? "selected" : ""}>大数据开发</option> --%>
<%-- 										<option value="4" ${(userInfo.job== '4') ? "selected" : ""}>ios开发</option> --%>
<%-- 										<option value="5" ${(userInfo.job== '5') ? "selected" : ""}>Android开发</option> --%>
<%-- 										<option value="6" ${(userInfo.job== '6') ? "selected" : ""}>Linux系统工程师</option> --%>
<%-- 										<option value="7" ${(userInfo.job== '7') ? "selected" : ""}>PHP开发</option> --%>
<%-- 										<option value="8" ${(userInfo.job== '8') ? "selected" : ""}>.net开发</option> --%>
<%-- 										<option value="9" ${(userInfo.job== '9') ? "selected" : ""}>C/C++</option> --%>
<%-- 										<option value="10" ${(userInfo.job== '10') ? "selected" : ""}>学生</option> --%>
<%-- 										<option value="11" ${(userInfo.job== '11') ? "selected" : ""}>其它</option> --%>
		                        	</select>
                                </div>
							</div>
						</div>
						
						   
						<div class="form-group">
							<label class="col-md-3 control-label">居住地点</label>
							<div data-toggle="distpicker">
								<div class="col-md-2">
                                    <div id="input-error">
										<select class="form-control" name="province" data-province="${userInfo.province }"></select>
                                    </div>
								</div>
								<div class="col-md-2">
                                    <div id="input-error">
										<select class="form-control" name="city" data-city="${userInfo.city }"></select>
                                    </div>
								</div>
								<div class="col-md-2">
                                    <div id="input-error">
										<select class="form-control" name="district" data-district="${userInfo.district }"></select>
                                    </div>
								</div>
							</div>
						</div>              
							                  
						<div class="form-group">
							<label class="col-md-3 control-label">详细地址</label>
							<div class="col-md-4">
								<div class="input-group">
									<div id="input-error">
										<textarea id="address" name="address" class="form-control" rows="6" cols="70" placeholder="详细地址，如：“平江区观前街XX号”">${userInfo.address }</textarea>
									</div>
								</div>
							</div>
						</div>
					</div>
                                                       
				
	        </div>
	    </div>
	</div>
	<div class="modal-footer">
	    <button type="button" class="btn default" data-dismiss="modal">关  闭</button>
	    <button type="submit" class="btn blue">保  存</button>
	</div>

</form>