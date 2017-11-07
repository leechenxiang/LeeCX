package com.itzixi.web.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * 
 * @Title: IOUtils.java
 * @Package com.itzixi.web.utils
 * @Description: 流工具类，继承自Spring
 * Copyright: Copyright (c) 2017
 * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
 * 
 * @author leechenxiang
 * @date 2017年10月14日 下午12:13:04
 * @version V1.0
 */
public class IOUtils extends org.springframework.util.StreamUtils {

    /**
     * closeQuietly
     * @param closeable 自动关闭
     */
    public static void closeQuietly(Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (IOException ioe) {
            // ignore
        }
    }
}
