<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<!-- BEGIN HEAD -->
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>LeeCX 开源后台管理系统 | itzixi.com</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta content="width=device-width, initial-scale=1" name="viewport" />
        <meta content="尚自习 - 程序员的进阶平台 | www.itzixi.com" name="description" />
        <meta content="福瑞博课 - leechenxiang" name="author" />
        
        <!-- 公用头部JS start -->
        <jsp:include page="common/commonHeaderCSS.jsp"></jsp:include>
        <!-- 公用头部JS end -->
        
		<style>
			/* 设置jqgrid列中文字内容垂直居中 jqgrid 单元格自动换行 */
			.ui-jqgrid tr.jqgrow td {
				vertical-align:middle;
			 	white-space: normal !important; 
			 	height: auto; 
			 	word-break: break-all; 
			}
		</style>
		
    </head>
    <!-- END HEAD -->

<body class="page-header-fixed page-sidebar-closed-hide-logo page-content-white">
        <div class="page-wrapper">
            
            <!-- 引入header页面 start -->
           	<jsp:include page="common/header.jsp"></jsp:include>
           	<!-- 引入header页面  end -->
            
            <!-- BEGIN HEADER & CONTENT DIVIDER -->
            <div class="clearfix"> </div>
            <!-- END HEADER & CONTENT DIVIDER -->
            	
            	<div class="page-container">
            	
            	<!-- 菜单 start -->
            	<jsp:include page="common/menu.jsp"></jsp:include>
            	<!-- 菜单 end -->
            	
                <!-- BEGIN CONTENT -->
				<div class="page-content-wrapper">
				    <!-- BEGIN CONTENT BODY -->    
				    <div class="page-content">
				    
				    	<div class="page-content-body">
				    	
					        <jsp:include page="itzixi.jsp"></jsp:include>
					        
				        </div>
				        
				    </div>
				    <!-- END CONTENT BODY -->
				</div>
				<!-- END CONTENT -->
                
            </div>
            <!-- END CONTAINER -->
        </div>
            
            <!-- 引入footer页面 start -->
           	<jsp:include page="common/footer.jsp"></jsp:include>
           	<!-- 引入footer页面  end -->
            
        </div>
        
        <!-- 公用尾部JS start -->
        <jsp:include page="common/commonFooterJS.jsp"></jsp:include>
        <!-- 公用尾部JS end -->
	
</body>

</html>
