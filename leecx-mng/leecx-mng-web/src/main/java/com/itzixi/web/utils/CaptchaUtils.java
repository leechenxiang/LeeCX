package com.itzixi.web.utils;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.QuadCurve2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @Title: CaptchaUtils.java
 * @Package com.itzixi.web.utils
 * @Description: 验证码工具类
 * Copyright: Copyright (c) 2017
 * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
 * 
 * @author leechenxiang
 * @date 2017年10月14日 下午12:13:14
 * @version V1.0
 */
class CaptchaUtils {
	// 默认的验证码大小
	private static final int WIDTH = 108, HEIGHT = 40, CODE_SIZE = 4;
	// 验证码随机字符数组
	protected static final char[] charArray = "3456789ABCDEFGHJKMNPQRSTUVWXY".toCharArray();
	// 验证码字体
	private static final Font[] RANDOM_FONT = new Font[] {
		new Font("nyala", Font.BOLD, 38),
		new Font("Arial", Font.BOLD, 32),
		new Font("Bell MT", Font.BOLD, 32),
		new Font("Credit valley", Font.BOLD, 34),
		new Font("Impact", Font.BOLD, 32),
		new Font(Font.MONOSPACED, Font.BOLD, 40)
	};
	
	/**
	 * 生成验证码
	 */
	static void generate(HttpServletResponse response, String vCode) {
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		response.setHeader("Pragma","no-cache");
		response.setHeader("Cache-Control","no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");
		
		ServletOutputStream sos = null;
		try {
			drawGraphic(image, vCode);
			sos = response.getOutputStream();
			ImageIO.write(image, "JPEG", sos);
			sos.flush();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			IOUtils.closeQuietly(sos);
		}
	}
	
	// 生成随机类
	private static final Random RANDOM = new Random();
	
	/**
	 * 生成验证码字符串
	 * @return 验证码字符串
	 */
	static String generateCode() {
		int count = CODE_SIZE;
		char[] buffer = new char[count];
		for (int i = 0; i < count; i++) {
			buffer[i] = charArray[RANDOM.nextInt(charArray.length)];
		}
		return new String(buffer);
	}
	
	private static void drawGraphic(BufferedImage image, String code){
		// 获取图形上下文
		Graphics2D g = image.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
		// 图形抗锯齿
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		// 字体抗锯齿
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		
		// 设定背景色，淡色
		g.setColor(getRandColor(210, 250));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		// 画小字符背景
		Color color = null;
		for(int i = 0; i < 20; i++){
			color = getRandColor(120, 200);
			g.setColor(color);
			String rand = String.valueOf(charArray[RANDOM.nextInt(charArray.length)]);
			g.drawString(rand, RANDOM.nextInt(WIDTH), RANDOM.nextInt(HEIGHT));
			color = null;
		}
		// 取随机产生的认证码(4位数字)
		char[] buffer = code.toCharArray();
		for (int i = 0; i < buffer.length; i++){
			char _code = buffer[i];
			//旋转度数 最好小于45度
			int degree = RANDOM.nextInt(28);
			if (i % 2 == 0) {
				degree = degree * (-1);
			}
			//定义坐标
			int x = 22 * i, y = 21;
			//旋转区域
			g.rotate(Math.toRadians(degree), x, y);
			//设定字体颜色
			color = getRandColor(20, 130);
			g.setColor(color);
			//设定字体，每次随机
			g.setFont(RANDOM_FONT[RANDOM.nextInt(RANDOM_FONT.length)]);
			//将认证码显示到图象中
			g.drawString("" + _code, x + 8, y + 10);
			//旋转之后，必须旋转回来
			g.rotate(-Math.toRadians(degree), x, y);
		}
		//图片中间曲线，使用上面缓存的color
		g.setColor(color);
		//width是线宽,float型
		BasicStroke bs = new BasicStroke(3);
		g.setStroke(bs);
		//画出曲线
		QuadCurve2D.Double curve = new QuadCurve2D.Double(0d, RANDOM.nextInt(HEIGHT - 8) + 4, WIDTH / 2, HEIGHT / 2, WIDTH, RANDOM.nextInt(HEIGHT - 8) + 4);
		g.draw(curve);
		// 销毁图像
		g.dispose();
	}

	/**
	 * 给定范围获得随机颜色
	 */
	private static Color getRandColor(int fc, int bc) {
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + RANDOM.nextInt(bc - fc);
		int g = fc + RANDOM.nextInt(bc - fc);
		int b = fc + RANDOM.nextInt(bc - fc);
		return new Color(r, g, b);
	}
}
