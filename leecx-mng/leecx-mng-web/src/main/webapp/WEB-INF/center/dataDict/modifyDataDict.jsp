<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script src="<%=request.getContextPath() %>/static/pages/js/dataDict.js?v=3.1415926" type="text/javascript"></script>

<form id="dataDictForm" action="" class="form-horizontal" method="post">
	<input id="dataDictId" name="id" type="hidden" value="${dataDict.id }" />

	<div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
	    <h4 class="modal-title">修改数据字典</h4>
	</div>
	<div class="modal-body">
	    <div class="row">
	        <div class="col-md-12">
							
                    <div class="form-body">
	                   	<div class="form-group">
	                       	<label class="col-md-3 control-label"><span class="required" aria-required="true"> * </span>字典名称</label>
	                           <div class="col-md-4">
	                           	<div id="input-error">
	                           		<input id="typeName" name="typeName" type="text" class="form-control" value="${dataDict.typeName }" />
	                           	</div>
							</div>
						</div>
	                       
						<div class="form-group">
							<label class="col-md-3 control-label"><span class="required" aria-required="true"> * </span>字典码</label>
							<div class="col-md-4">
	                                  <div id="input-error">
	                                      <input id="typeCode" name="typeCode" type="text" class="form-control" value="${dataDict.typeCode }">
	                                  </div>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-md-3 control-label"><span class="required" aria-required="true"> * </span>key</label>
							<div class="col-md-4">
	                                  <div id="input-error">
	                                      <input id="ddkey" name="ddkey" type="text" class="form-control" value="${dataDict.ddkey }">
	                                  </div>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-md-3 control-label"><span class="required" aria-required="true"> * </span>value</label>
							<div class="col-md-4">
	                                  <div id="input-error">
	                                      <input id="ddvalue" name="ddvalue" type="text" class="form-control" value="${dataDict.ddvalue }">
	                                  </div>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-md-3 control-label"><span class="required" aria-required="true"> * </span>是否显示</label>
							<div class="col-md-4">
	                                  <div id="input-error">
	                                      <label>
	                                          <input type="radio" name="isShow" class="icheck" value="1" ${(dataDict.isShow== '1') ? "checked='checked'" : ""}/> 是
	                                      </label>
	                                      
	                                      <label>
	                                          <input type="radio" name="isShow" class="icheck" value="0" ${(dataDict.isShow== '0') ? "checked='checked'" : ""}/> 否
	                                      </label>
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