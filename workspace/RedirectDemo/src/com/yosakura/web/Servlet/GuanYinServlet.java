package com.yosakura.web.Servlet;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 模拟观音的servlet
 * URL拼接
 * @author Administrator
 *
 */
public class GuanYinServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 怎么实现外部重定向 （响应实现重定向）
		// 获取八戒的请求参数
		String monster = new String(req.getParameter("monster").getBytes("ISO-8859-1"),"UTF-8");
		// 将utf-8格式的参数编码 转换成URL编码		
		monster = URLEncoder.encode(monster,"UTF-8");
		String fabao = URLEncoder.encode("芭蕉扇","UTF-8");
//		System.out.println(monster);
//		解码使用 （需要保证解码编码 和编码的初始编码一样）
//		URLDecoder.decode(monster,"UTF-8");
//		System.out.println(monster);
		// 约定优于编程
		// 路径可以是服务器内部资源,也可以是外部服务器资源
		
		// 重定向的路径采用的是url编码（中文参数必须处理成url编码才可以拼接）
		resp.sendRedirect("niuMo?monster="+monster+"&fabao="+fabao);

	}
}
