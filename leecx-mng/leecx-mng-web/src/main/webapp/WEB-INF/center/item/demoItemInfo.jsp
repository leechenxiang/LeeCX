<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
	    <h4 class="modal-title">商品信息详情</h4>
	</div>
	<div class="modal-body">
	
        <div class="modal-body">
        	<div class="portlet-body">
	            <div class="row">
	                <div class="col-md-12">
	                    <table id="user" class="table table-bordered table-striped">
	                        <tbody>
	                            <tr>
	                                <td style="width:15%"> 商品编号 </td>
	                                <td style="width:50%">
	                                    ${item.id }
	                                </td>
	                            </tr>
	                            <tr>
	                                <td> 商品名称 </td>
	                                <td>
	                                    ${item.name}
	                                </td>
	                            </tr>
	                            <tr>
	                                <td> 商品金额 </td>
	                                <td>
	                                    <fmt:formatNumber value="${item.amount / 100}" type="currency"></fmt:formatNumber>
	                                </td>
	                            </tr>
	                        </tbody>
	                    </table>
	                </div>
	            </div>
	        </div>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn default" data-dismiss="modal">关  闭</button>
        </div>
        
	</div>

