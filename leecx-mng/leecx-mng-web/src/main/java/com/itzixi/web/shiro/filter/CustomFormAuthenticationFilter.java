package com.itzixi.web.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

/**
 * 
 * @Title: CustomFormAuthenticationFilter.java
 * @Package com.lee.shiro.filter
 * @Description: 要进行验证码验证，需要重写原来的过滤器，在认证（登录）之前验证验证码
 * Copyright: Copyright (c) 2016
 * Company:Nathan.Lee.Salvatore
 * 
 * @author leechenxiang
 * @date 2016年10月2日 下午9:44:19
 * @version V1.0
 */
public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        if (isLoginRequest(request, response)) {
            if (isLoginSubmission(request, response)) {
                return executeLogin(request, response);
            } else {
                // 放行 allow them to see the login page ;)
                return true;
            }
        } else {
        	HttpServletRequest httpRequest = WebUtils.toHttp(request);
        	
        	if (ShiroFilterUtils.isAjax(httpRequest)) {
        		
        		HttpServletResponse httpServletResponse = WebUtils.toHttp(response);  
        		httpServletResponse.sendError(ShiroFilterUtils.HTTP_STATUS_SESSION_EXPIRE);
                 
        		// 解决session过期会在页面中显示登陆页面
//                HttpServletRequest httpRequest = (HttpServletRequest)request;
//			    response.setContentType("text/html;charset=UTF-8");
//			    PrintWriter out = response.getWriter();
//			    StringBuilder builder = new StringBuilder();
//			    builder.append("<script type=\"text/javascript\" charset=\"UTF-8\">");
//			    builder.append("window.top.location.href='" + httpRequest.getContextPath() + "/login.shtml';");
//			    builder.append("</script>");
//			    out.print(builder.toString());
//			    out.close();
        		
			    return false;
    
            } else {  
            	saveRequestAndRedirectToLogin(request, response); 
            }  

            return false;
        }
    }
	
	/**
	 * 判断ajax请求
	 * @param request
	 * @return
	 */
	boolean isAjax(HttpServletRequest request){
	    return  (request.getHeader("X-Requested-With") != null  && "XMLHttpRequest".equals( request.getHeader("X-Requested-With").toString())   ) ;
	}
	
}
