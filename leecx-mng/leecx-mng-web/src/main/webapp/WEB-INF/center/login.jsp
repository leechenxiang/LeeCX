<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>  
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
    <title>尚自习  - 登录 | www.itzixi.com 程序员的进阶平台</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1" name="viewport" />
    <meta content="leechenxiang" name="author" />
    
<!--     <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css" /> -->
<!-- 	<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css" /> -->
    <link href="<%=request.getContextPath() %>/static/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath() %>/static/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath() %>/static/global/plugins/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/static/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css" />
    <!-- END GLOBAL MANDATORY STYLES -->
    <!-- BEGIN PAGE LEVEL PLUGINS -->
    <link href="<%=request.getContextPath() %>/static/global/plugins/select2/css/select2.min.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath() %>/static/global/plugins/select2/css/select2-bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath() %>/static/global/plugins/bootstrap-sweetalert/sweetalert.css" rel="stylesheet" type="text/css" />
    <!-- END PAGE LEVEL PLUGINS -->
    <!-- BEGIN THEME GLOBAL STYLES -->
    <link href="<%=request.getContextPath() %>/static/global/css/components.min.css" rel="stylesheet" id="style_components" type="text/css" />
	<link href="<%=request.getContextPath() %>/static/global/css/plugins.min.css" rel="stylesheet" type="text/css" />
    <!-- END THEME GLOBAL STYLES -->
    <!-- BEGIN PAGE LEVEL STYLES -->
    <link href="<%=request.getContextPath() %>/static/pages/css/login-5.css" rel="stylesheet" type="text/css" />
    <!-- END PAGE LEVEL STYLES -->

	<link rel="shortcut icon" href="<%=request.getContextPath()%>/portal/image/itzixi_favicon.ico" type="image/x-icon">
        
	<style type="text/css">
		.help-block {
			display: block;
		  	margin-top: 5px;
		  	margin-bottom: 10px;
		  	color: red; 
		}
	</style>
	
	<script src="<%=request.getContextPath() %>/static/baiduTongji.js" type="text/javascript"></script>
	
</head>
<body class="login">
	<!-- BEGIN : LOGIN PAGE 5-1 -->
        <div class="user-login-5">
            <div class="row bs-reset">
                <div class="col-md-6 bs-reset mt-login-5-bsfix">
                    <div class="login-bg" style="">
                        <a href="<%=request.getContextPath()%>/">
                        	<img class="login-logo" src="<%=request.getContextPath()%>/portal/image/itzixi-logo.png" />
                        </a> 
                    </div>
                </div>
                <div class="col-md-6 login-container bs-reset mt-login-5-bsfix">
                    <div class="login-content" >
                        <h1 class="font-green-jungle">欢迎登录尚自习</h1>
                        <p> ` `心态有多开放, 视野就有多开阔 · ❀不忘初心, 持之以恒 ❀❀ Stay hungry, Stay foolish.. </p>
                        <form id="loginForm" action="javascript:;" class="login-form" method="post">
                            <div class="alert alert-danger display-hide">
                                <button class="close" data-close="alert"></button>
                                <span>请输入用户名和密码. </span>
                            </div>
                            <div class="row">
                                <div class="col-xs-6">
<%--                                     <input class="form-control form-control-solid placeholder-no-fix form-group" type="text" autocomplete="off" placeholder="<spring:message code="mobile"/>" name="username" required/> --%>
                                    <input class="form-control form-control-solid placeholder-no-fix form-group" type="text" autocomplete="off" placeholder="用户名 或 手机号" name="username" required/> 
                                </div>
                                <div class="col-xs-6">
<%--                                     <input class="form-control form-control-solid placeholder-no-fix form-group" type="password" autocomplete="off" placeholder="<spring:message code="pwd"/>" name="password" required/> --%>
                                    <input class="form-control form-control-solid placeholder-no-fix form-group" type="password" autocomplete="off" placeholder="密码" name="password" required/>  
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
									<div class="form-actions">
		                                <a id="go-regist-btn" class="btn green-jungle" href="<%=request.getContextPath() %>/regist.shtml">立即注册</a>
		                            </div>

<!--                                     <div class="rem-password"> -->
<!--                                         <label class="rememberme mt-checkbox mt-checkbox-outline"> -->
<!--                                             <input type="checkbox" name="remember" value="1" /> 记住我 -->
<!--                                             <span></span> -->
<!--                                         </label> -->
<!--                                     </div> -->
                                </div>
                                <div class="col-ld-8 col-md-8 col-sm-8 col-xs-8 text-right">
                                    <div class="forgot-password" style="margin-right: 0px;">
                                        <a href="javascript:;" id="forget-password" class="forget-password">忘记密码？</a>
                                    </div>
                                    <button class="btn green" type="submit">登  录</button>
                                </div>
                            </div>
                        </form>
                        
                        <!-- 使用手机号重置密码 start -->
                        <form class="forget-form" action="<%=request.getContextPath() %>/user/showResetPwdByMobilePage.shtml" method="post" style="display: none;">
                            <h3 class="font-green">忘记 密码 ？</h3>
                            <p> 请输入你的手机号获取动态验证码后来重置你的密码. </p>
                            <div class="form-group">
                                	<div class="input-icon">
                                		<i class="fa fa-mobile "></i>
                                    	<input class="form-control placeholder-no-fix form-group" type="text" autocomplete="off" placeholder="手机号" name="mobile" id="mobile"/>
                                    </div> 
                            </div>
                            
                            <div class="form-group">
                           		<div class="row">
									<div class="col-md-9">
										<div class="input-icon">
											<i class="fa fa-paper-plane-o "></i>
		                                 			<input class="form-control placeholder-no-fix form-group" type="text" autocomplete="off" placeholder="验证码" name="authCode" />
										</div>
									</div>
							        <div class="col-md-3">
							        	<button id="btnGetAuthCode" type="button" class="btn green-meadow pull-right" disabled="disabled">获取手机动态验证码</button>
							        	<input type="hidden" id="totalSecond">
							        </div>
                               	</div> 
                            </div>
                            <div class="form-actions">
                                <button type="button" id="back-btn" class="btn blue-steel btn-outline">后  退</button>
                                <button type="submit" class="btn btn-success uppercase pull-right">提  交</button>
                            </div>
                        </form>
                        <!-- 使用手机号重置密码 end -->
                        
                        <!-- BEGIN FORGOT PASSWORD FORM -->
                        <form class="forget-form-email" action="javascript:;" method="post" style="display: none;">
                            <h3 class="font-green">忘记 密码 ？</h3>
                            <p> 请输入你的Email来重置你的密码. </p>
                            <div class="form-group">
                            	<div class="input-icon">
                            		<i class="fa fa-envelope "></i>
                                	<input class="form-control placeholder-no-fix form-group" type="text" autocomplete="off" placeholder="Email" id="email" name="email" />
                                </div>
                            </div>
                            <div class="form-actions">
                                <button type="button" id="back-btn" class="btn blue-steel btn-outline">后  退</button>
                                <button type="submit" class="btn btn-success uppercase pull-right">提  交</button>
                            </div>
                        </form>
                        <!-- END FORGOT PASSWORD FORM -->
                        
                        <!-- 发送邮件后所显示的内容 start -->
                        <div id="afterSendEmail" style="display: none;">
                            <h4 class="font-green">重置密码验证链接地址已经发送至您的邮箱了，点击链接后即可重置密码！</h4>
                            <p> 系统已经向您的邮箱 <b id="yourEmail" class="font-yellow-gold"></b> 发送了一封验证链接，请前往您的邮箱完成重置密码操作噢~ </p>
                            <div class="form-actions">
                                <button type="button" id="goEmail" class="btn blue-steel">前往邮箱</button>
                            </div>
                        </div>
                        <!-- 发送邮件后所显示的内容 end -->
                        
                    </div>
                    <div class="login-footer">
                        <div class="row bs-reset">
                            <div class="col-xs-12 bs-reset">
                                <div class="login-copyright text-right">
                                    <p> &copy; 2017 尚自习 - 无锡福瑞博课网络科技有限公司</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <input type="hidden" id="hdnContextPath" name="hdnContextPath" value="<%=request.getContextPath() %>"/>
        
        <!-- END : LOGIN PAGE 5-1 -->
        <!--[if lt IE 9]>
<script src="../assets/global/plugins/respond.min.js?v=3.1415926"></script>
<script src="../assets/global/plugins/excanvas.min.js?v=3.1415926"></script> 
<script src="../assets/global/plugins/ie8.fix.min.js?v=3.1415926"></script> 
<![endif]-->
        
        <!-- 公用尾部JS start -->
	    <jsp:include page="common/commonFooterJS.jsp"></jsp:include>
	    <!-- 公用尾部JS end -->
    
        <!-- BEGIN PAGE LEVEL SCRIPTS -->
        <script src="<%=request.getContextPath() %>/static/pages/scripts/login-5.js?v=3.1415926" type="text/javascript"></script>
        <!-- END PAGE LEVEL SCRIPTS -->
        
        <!-- 页面要用到的私有JS start -->
<%-- 	    <script src="<%=request.getContextPath() %>/static/pages/js/login.js?v=3.1415926" type="text/javascript"></script> --%>
	    <!-- 页面要用到的私有JS end -->
        
</body>
</html>
