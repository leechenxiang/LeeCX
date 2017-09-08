package com.itzixi.common.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 
 * @Title: CookieUtils.java
 * @Package com.lee.sso.utils
 * @Description: Cookie 工具类
 * Copyright: Copyright (c) 2016
 * Company:Nathan.Lee.Salvatore
 * 
 * @author leechenxiang
 * @date 2016年5月5日 下午1:24:52
 * @version V1.0
 */
public final class CookieUtils {
	
	final static Logger log = LoggerFactory.getLogger(CookieUtils.class);
	
	/**
	 * 
	 * @Description: 得到Cookie的值, 不编码
	 * @param request
	 * @param cookieName
	 * @return
	 * 
	 * @author leechenxiang
	 * @date 2016年5月5日 下午1:25:01
	 */
    public static String getCookieValue(HttpServletRequest request, String cookieName) {
        return getCookieValue(request, cookieName, false);
    }
    
    /**
     * 
     * @Description: 得到Cookie的值
     * @param request
     * @param cookieName
     * @param isDecoder
     * @return
     * 
     * @author leechenxiang
     * @date 2016年5月5日 下午1:25:24
     */
    public static String getCookieValue(HttpServletRequest request, String cookieName, boolean isDecoder) {
        Cookie[] cookieList = request.getCookies();
        if (cookieList == null || cookieName == null) {
            return null;
        }
        String retValue = null;
        try {
            for (int i = 0; i < cookieList.length; i++) {
                if (cookieList[i].getName().equals(cookieName)) {
                    if (isDecoder) {
                        retValue = URLDecoder.decode(cookieList[i].getValue(), "UTF-8");
                    } else {
                        retValue = cookieList[i].getValue();
                    }
                    break;
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return retValue;
    }

    /**
     * 
     * @Description: 得到Cookie的值
     * @param request
     * @param cookieName
     * @param encodeString
     * @return
     * 
     * @author leechenxiang
     * @date 2016年5月5日 下午1:25:46
     */
    public static String getCookieValue(HttpServletRequest request, String cookieName, String encodeString) {
        Cookie[] cookieList = request.getCookies();
        if (cookieList == null || cookieName == null) {
            return null;
        }
        String retValue = null;
        try {
            for (int i = 0; i < cookieList.length; i++) {
                if (cookieList[i].getName().equals(cookieName)) {
                    retValue = URLDecoder.decode(cookieList[i].getValue(), encodeString);
                    break;
                }
            }
        } catch (UnsupportedEncodingException e) {
        	 e.printStackTrace();
        }
        return retValue;
    }

    /**
     * 
     * @Description: 设置Cookie的值 不设置生效时间默认浏览器关闭即失效,也不编码
     * @param request
     * @param response
     * @param cookieName
     * @param cookieValue
     * 
     * @author leechenxiang
     * @date 2016年5月5日 下午1:26:05
     */
    public static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName,
            String cookieValue) {
        setCookie(request, response, cookieName, cookieValue, -1);
    }

    /**
     * 
     * @Description: 设置Cookie的值 在指定时间内生效,但不编码
     * @param request
     * @param response
     * @param cookieName
     * @param cookieValue
     * @param cookieMaxage
     * 
     * @author leechenxiang
     * @date 2016年5月5日 下午1:26:29
     */
    public static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName,
            String cookieValue, int cookieMaxage) {
        setCookie(request, response, cookieName, cookieValue, cookieMaxage, false);
    }

    /**
     * 
     * @Description: 设置Cookie的值 不设置生效时间,但编码
     * @param request
     * @param response
     * @param cookieName
     * @param cookieValue
     * @param isEncode
     * 
     * @author leechenxiang
     * @date 2016年5月5日 下午1:26:51
     */
    public static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName,
            String cookieValue, boolean isEncode) {
        setCookie(request, response, cookieName, cookieValue, -1, isEncode);
    }

   /**
    * 
    * @Description: 设置Cookie的值 在指定时间内生效, 编码参数
    * @param request
    * @param response
    * @param cookieName
    * @param cookieValue
    * @param cookieMaxage
    * @param isEncode
    * 
    * @author leechenxiang
    * @date 2016年5月5日 下午1:27:06
    */
    public static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName,
            String cookieValue, int cookieMaxage, boolean isEncode) {
        doSetCookie(request, response, cookieName, cookieValue, cookieMaxage, isEncode);
    }

    /**
     * 
     * @Description: 设置Cookie的值 在指定时间内生效, 编码参数(指定编码)
     * @param request
     * @param response
     * @param cookieName
     * @param cookieValue
     * @param cookieMaxage
     * @param encodeString
     * 
     * @author leechenxiang
     * @date 2016年5月5日 下午1:27:14
     */
    public static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName,
            String cookieValue, int cookieMaxage, String encodeString) {
        doSetCookie(request, response, cookieName, cookieValue, cookieMaxage, encodeString);
    }

    /**
     * 
     * @Description: 删除Cookie带cookie域名
     * @param request
     * @param response
     * @param cookieName
     * 
     * @author leechenxiang
     * @date 2016年5月5日 下午1:27:21
     */
    public static void deleteCookie(HttpServletRequest request, HttpServletResponse response,
            String cookieName) {
        doSetCookie(request, response, cookieName, "", -1, false);
    }

    
    /**
     * 
     * @Description: 设置Cookie的值，并使其在指定时间内生效
     * @param request
     * @param response
     * @param cookieName
     * @param cookieValue
     * @param cookieMaxage	cookie生效的最大秒数
     * @param isEncode
     * 
     * @author leechenxiang
     * @date 2016年5月5日 下午1:27:30
     */
    private static final void doSetCookie(HttpServletRequest request, HttpServletResponse response,
            String cookieName, String cookieValue, int cookieMaxage, boolean isEncode) {
        try {
            if (cookieValue == null) {
                cookieValue = "";
            } else if (isEncode) {
                cookieValue = URLEncoder.encode(cookieValue, "utf-8");
            }
            Cookie cookie = new Cookie(cookieName, cookieValue);
            if (cookieMaxage > 0)
                cookie.setMaxAge(cookieMaxage);
            if (null != request) {// 设置域名的cookie
            	String domainName = getDomainName(request);
            	log.info("cookie：{}", domainName);
                if (!"localhost".equals(domainName)) {
                	cookie.setDomain(domainName);
                }
            }
            cookie.setPath("/");
            response.addCookie(cookie);
        } catch (Exception e) {
        	 e.printStackTrace();
        }
    }

    /**
     * 
     * @Description: 设置Cookie的值，并使其在指定时间内生效
     * @param request
     * @param response
     * @param cookieName
     * @param cookieValue
     * @param cookieMaxage	cookie生效的最大秒数
     * @param encodeString
     * 
     * @author leechenxiang
     * @date 2016年5月5日 下午1:27:45
     */
    private static final void doSetCookie(HttpServletRequest request, HttpServletResponse response,
            String cookieName, String cookieValue, int cookieMaxage, String encodeString) {
        try {
            if (cookieValue == null) {
                cookieValue = "";
            } else {
                cookieValue = URLEncoder.encode(cookieValue, encodeString);
            }
            Cookie cookie = new Cookie(cookieName, cookieValue);
            if (cookieMaxage > 0)
                cookie.setMaxAge(cookieMaxage);
            if (null != request) {// 设置域名的cookie
            	String domainName = getDomainName(request);
            	log.info("cookie：{}", domainName);
                if (!"localhost".equals(domainName)) {
                	cookie.setDomain(domainName);
                }
            }
            cookie.setPath("/");
            response.addCookie(cookie);
        } catch (Exception e) {
        	 e.printStackTrace();
        }
    }

    /**
     * 
     * @Description: 得到cookie的域名
     * @param request
     * @return
     * 
     * @author leechenxiang
     * @date 2016年5月5日 下午1:28:01
     */
    private static final String getDomainName(HttpServletRequest request) {
        String domainName = null;

        String serverName = request.getRequestURL().toString();
        if (serverName == null || serverName.equals("")) {
            domainName = "";
        } else {
            serverName = serverName.toLowerCase();
            serverName = serverName.substring(7);
            final int end = serverName.indexOf("/");
            serverName = serverName.substring(0, end);
            final String[] domains = serverName.split("\\.");
            int len = domains.length;
            if (len > 3) {
                // www.xxx.com.cn
                domainName = "." + domains[len - 3] + "." + domains[len - 2] + "." + domains[len - 1];
            } else if (len <= 3 && len > 1) {
                // xxx.com or xxx.cn
                domainName = "." + domains[len - 2] + "." + domains[len - 1];
            } else {
                domainName = serverName;
            }
        }

        if (domainName != null && domainName.indexOf(":") > 0) {
            String[] ary = domainName.split("\\:");
            domainName = ary[0];
        }
        return domainName;
    }

}
