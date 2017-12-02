<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/dataDict" prefix="dataDict" %>

	<div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
	    <h4 class="modal-title">用户信息详情</h4>
	</div>
	<div class="modal-body">
	
        <div class="modal-body">
        	<div class="portlet-body">
	            <div class="row">
	                <div class="col-md-12">
	                    <table id="user" class="table table-bordered table-striped">
	                        <tbody>
	                            <tr>
	                                <td style="width:15%"> 用户编号 </td>
	                                <td style="width:50%">
	                                    ${userInfo.id }
	                                </td>
	                            </tr>
	                            <tr>
	                                <td> 用户名/登录名 </td>
	                                <td>
	                                    ${userInfo.username }
	                                </td>
	                            </tr>
	                            <tr>
	                                <td> 密码 </td>
	                                <td>
	                                    ${userInfo.password }
	                                </td>
	                            </tr>
	                            <tr>
	                                <td> 昵称 </td>
	                                <td>
	                                    ${userInfo.nickname }
	                                </td>
	                            </tr>
	                            <tr>
	                                <td> 年龄 </td>
	                                <td>
	                                    ${userInfo.age } 岁
	                                </td>
	                            </tr>
	                            <tr>
	                                <td> 性别 </td>
	                                <td>
	                                	<dataDict:dataDictValue ddKey="${userInfo.sex}" typeCode="sex"/>
<%-- 	                                    <c:choose> --%>
<%-- 	                                     	<c:when test="${userInfo.sex == 0}"> --%>
<!-- 	                                           	女 -->
<%-- 	                                        </c:when> --%>
<%-- 	                                        <c:when test="${userInfo.sex == 1}"> --%>
<!-- 	                                           	男 -->
<%-- 	                                        </c:when> --%>
<%-- 	                                        <c:otherwise> --%>
<!-- 	                                        	保密 -->
<%-- 	                                        </c:otherwise> --%>
<%-- 	                                    </c:choose> --%>
	                                </td>
	                            </tr>
	                            <tr>
	                                <td> 职务 </td>
	                                <td>
	                                	<dataDict:dataDictValue ddKey="${userInfo.job}" typeCode="job"/>
<%-- 	                                    <c:choose> --%>
<%-- 	                                     	<c:when test="${userInfo.job == 1}"> --%>
<!-- 	                                           	Java开发 -->
<%-- 	                                        </c:when> --%>
<%-- 	                                        <c:when test="${userInfo.job == 2}"> --%>
<!-- 	                                           	前端开发 -->
<%-- 	                                        </c:when> --%>
<%-- 	                                        <c:when test="${userInfo.job == 3}"> --%>
<!-- 	                                           	大数据开发 -->
<%-- 	                                        </c:when> --%>
<%-- 	                                        <c:when test="${userInfo.job == 4}"> --%>
<!-- 	                                           	ios开发 -->
<%-- 	                                        </c:when> --%>
<%-- 	                                        <c:when test="${userInfo.job == 5}"> --%>
<!-- 	                                           	Android开发 -->
<%-- 	                                        </c:when> --%>
<%-- 	                                        <c:when test="${userInfo.job == 6}"> --%>
<!-- 	                                           	Linux系统工程师 -->
<%-- 	                                        </c:when> --%>
<%-- 	                                        <c:when test="${userInfo.job == 7}"> --%>
<!-- 	                                           	PHP开发 -->
<%-- 	                                        </c:when> --%>
<%-- 	                                        <c:when test="${userInfo.job == 8}"> --%>
<!-- 	                                           	.net开发 -->
<%-- 	                                        </c:when> --%>
<%-- 	                                        <c:when test="${userInfo.job == 9}"> --%>
<!-- 	                                           	C/C++ -->
<%-- 	                                        </c:when> --%>
<%-- 	                                        <c:when test="${userInfo.job == 10}"> --%>
<!-- 	                                           	学生 -->
<%-- 	                                        </c:when> --%>
<%-- 	                                        <c:when test="${userInfo.job == 11}"> --%>
<!-- 	                                           	其它 -->
<%-- 	                                        </c:when> --%>
<%-- 	                                    </c:choose> --%>
	                                </td>
	                            </tr>
	                            <tr>
	                                <td> 所在地 </td>
	                                <td>
	                                	${userInfo.province }
				                    	&nbsp;
				                    	${userInfo.city }
				                    	&nbsp;
				                    	${userInfo.district }
	                                </td>
	                            </tr>
	                            <tr>
	                                <td> 地址 </td>
	                                <td>
	                                    ${userInfo.address }
	                                </td>
	                            </tr>
	                            <tr>
	                                <td> 权限：盐 </td>
	                                <td>
	                                    ${userInfo.authSalt }
	                                </td>
	                            </tr>
	                            <tr>
	                                <td> 登录IP </td>
	                                <td>
	                                    ${userInfo.lastLoginIp }
	                                </td>
	                            </tr>
	                            <tr>
	                                <td> 最近一次登录时间 </td>
	                                <td>
	                                    <fmt:formatDate value="${userInfo.lastLoginTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
	                                </td>
	                            </tr>
	                            <tr>
	                                <td> 注册时间 </td>
	                                <td>
	                                    <fmt:formatDate value="${userInfo.registTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
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

