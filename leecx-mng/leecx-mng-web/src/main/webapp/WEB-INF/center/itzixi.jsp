<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        
<style>

.desc {
	line-height:18px;
	text-indent:2em;
}

</style>
        
	<div class="page-bar">
	    <ul class="page-breadcrumb">
	        <li>
	            <a href="index.html">首页</a>
	        </li>
	    </ul>
	</div>
	
	<h1 class="page-title"> LeeCX 开源后台管理系统
        <small></small>
    </h1>
                        
	<div class="clearfix"></div>
        
	<div class="row">
	    <div class="col-lg-6 col-xs-12 col-sm-12">
	        
	        <div class="portlet light portlet-fit bordered">
	            <div class="portlet-title">
	                <div class="caption">
	                    <i class="icon-microphone font-dark hide"></i>
	                    <span class="caption-subject bold font-dark uppercase"> 平台简介</span>
	                    <span class="caption-helper">使用到的技术将不断更新...</span>
	                </div>
	            </div>
	            <div class="portlet-body">
	                <div class="row">
	                    <div class="col-md-12">
	                        <div class="mt-widget-3" style="padding-top: 15px;">
	                        	<p class="desc"><font style="font-size: 16px;"><b>主要功能：</b></font></p>
	                        	<p class="desc">1、三层架构：使用SSM，即springmvc+spring+mybatis作为基本的架构</p>
	                        	<p class="desc">2、数据源采用阿里巴巴Druid连接池，可以开启监控数据库访问性能，统计SQL执行的面板</p>
								<p class="desc">3、展现层： 使用spring mvc注解，api接口采用Restful风格</p>
								<p class="desc">4、持久层：使用mybatis持久化，提供逆向生成工程减少代码量；并且使用pagehelper作为分页插件</p>
								<p class="desc">5、日志采用slf4j+log4j进行日志管理</p>
								<p class="desc">其他技术将会不间断更新并且引入...</p>
	                        </div>
	                    </div>
	                </div>
	                
	                <div class="row" style="margin-top: 15px;">
	                    <div class="col-md-12">
	                        <div class="mt-widget-3" style="padding-top: 15px;">
	                        	<p class="desc"><font style="font-size: 16px;"><b>技术选型：</b></font></p>
	                        	<p class="desc">1、核心框架：Spring Framework 4.3.3.RELEASE</p>
								<p class="desc">2、权限框架：Apache Shiro 1.3.2</p>
								<p class="desc">3、持久层框架：MyBatis 3.2.8 + pagehelper 4.1.3</p>
								<p class="desc">4、数据库连接池：阿里巴巴 Druid 1.1.0</p>
								<p class="desc">5、缓存：Redis/Jedis 2.8.0</p>
								<p class="desc">6、日志管理：SLF4J + Log4j</p>
								<p class="desc">7、前端框架：Bootstrap + Jquery</p>
	                        </div>
	                    </div>
	                </div>
	            </div>
	        </div>
	        
	        <div class="portlet light portlet-fit bordered">
	            <div class="portlet-title">
	                <div class="caption">
	                    <i class="icon-microphone font-dark hide"></i>
	                    <span class="caption-subject bold font-dark uppercase"> 扫一扫关注我们</span>
	                    <span class="caption-helper">加入QQ群（458372464）或者关注公众号获得更多技术咨询、技术交流、技术资源...</span>
	                </div>
	            </div>
	            <div class="portlet-body">
	                <div class="row">
	                    <div class="col-md-4">
	                        <div class="mt-widget-3">
	                        	<img src="<%=request.getContextPath() %>/static/pages/img/center/qrcode-qq.jpg" width="233px" class="img-responsive"/>
	                        </div>
	                    </div>
	                    <div class="col-md-4">
	                        <div class="mt-widget-3">
	                            <img src="<%=request.getContextPath() %>/static/pages/img/center/qrcode-lee.jpg" width="233px" class="img-responsive"/>
	                        </div>
	                    </div>
	                    <div class="col-md-4">
	                        <div class="mt-widget-3">
	                            <img src="<%=request.getContextPath() %>/static/pages/img/center/qrcode-itzixi.jpg" width="233px" class="img-responsive"/>
	                        </div>
	                    </div>
	                </div>
	            </div>
	        </div>
	        
	    </div>
	    
	    <div class="col-lg-6 col-xs-12 col-sm-12">
	        <div class="portlet light portlet-fit bordered">
	            <div class="portlet-title">
	                <div class="caption">
	                    <i class="icon-microphone font-dark hide"></i>
	                    <span class="caption-subject bold font-dark uppercase"> 视频推荐</span>
	                    <span class="caption-helper">我们也致力于技术视频的录制，希望大家学到更多的技术...</span>
	                </div>
	            </div>
	            <div class="portlet-body ">
	            	<div class="row ">
	                    <div class="col-md-4 ">
	                        <img src="<%=request.getContextPath() %>/static/pages/img/course/springboot.jpg" width="233px" class="img-responsive"/>
	                    </div>
	                    <div class="col-md-8 " >
	                    	<a href="http://www.itzixi.com/course/detail.shtml?courseId=1711089W6RG47GHH" target="_blank">《Sping Boot 极速入门到整合系列视频》</a>
	                    </div>
	                </div>
	                <div class="row " style="margin-top: 10px;">
	                    <div class="col-md-4 ">
	                        <img src="<%=request.getContextPath() %>/static/pages/img/course/shiro.jpg" width="233px" class="img-responsive"/>
	                    </div>
	                    <div class="col-md-8 " >
	                    	<a href="http://www.itzixi.com/course/detail.shtml?courseId=170925BH9R40SAY8" target="_blank">《Shiro权限管理在J2EE企业级开发中的应用与实战》</a>
	                    </div>
	                </div>
	                <div class="row " style="margin-top: 10px;">
	                    <div class="col-md-4 ">
	                        <img src="<%=request.getContextPath() %>/static/pages/img/course/dd.jpg" width="233px" class="img-responsive"/>
	                    </div>
	                    <div class="col-md-8 " >
	                    	<a href="http://www.itzixi.com/course/detail.shtml?courseId=17092078Y3009WX4" target="_blank">《使用新版支付宝接口实现第三方网关支付》</a>
	                    </div>
	                </div>
	                <div class="row " style="margin-top: 10px;">
	                    <div class="col-md-4 ">
	                        <img src="<%=request.getContextPath() %>/static/pages/img/course/alipay.jpg" width="233px" class="img-responsive"/>
	                    </div>
	                    <div class="col-md-8 " >
	                    	<a href="http://www.itzixi.com/course/detail.shtml?courseId=170818C4XS6SPG9P" target="_blank">《使用新版支付宝接口实现第三方网关支付》</a>
	                    </div>
	                </div>
	                <div class="row" style="margin-top: 10px;">
	                    <div class="col-md-4">
	                        	<img src="<%=request.getContextPath() %>/static/pages/img/course/wxpay.jpg" width="233px" class="img-responsive"/>
	                    </div>
	                    <div class="col-md-8">
	                    	<a href="http://www.itzixi.com/course/detail.shtml?courseId=1709029W0AFN7X1P" target="_blank">《SpringMVC 实现web端微信扫码支付(即时到账)》</a>
	                    </div>
	                </div>
	                <div class="row" style="margin-top: 10px;">
	                    <div class="col-md-4">
	                        	<img src="<%=request.getContextPath() %>/static/pages/img/course/linux.jpg" width="233px" class="img-responsive"/>
	                    </div>
	                    <div class="col-md-8">
	                    	<a href="http://www.itzixi.com/course/detail.shtml?courseId=170802GTMYF0GYNC" target="_blank">《Linux - Java开发者所需要掌握的一门最基本的技能》</a>
	                    </div>
	                </div>
	                <div class="row" style="margin-top: 10px;">
	                    <div class="col-md-4">
	                        	<img src="<%=request.getContextPath() %>/static/pages/img/course/leecx.jpg" width="233px" class="img-responsive"/>
	                    </div>
	                    <div class="col-md-8">
	                    	<a href="http://www.itzixi.com/course/detail.shtml?courseId=17091175XBRXMS14" target="_blank">《LeeCX 开源后台管理系统 git+maven+ssm (不断更新)》</a>
	                    </div>
	                </div>
	                <div class="row" style="margin-top: 10px;">
	                    <div class="col-md-4">
	                        	<img src="<%=request.getContextPath() %>/static/pages/img/course/jqgrid.jpg" width="233px" class="img-responsive"/>
	                    </div>
	                    <div class="col-md-8">
	                    	<a href="http://www.itzixi.com/course/detail.shtml?courseId=1709106XFPFRT4SW" target="_blank">《mybatis-pagehelper+jqgrid 实现无刷新分页》</a>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
