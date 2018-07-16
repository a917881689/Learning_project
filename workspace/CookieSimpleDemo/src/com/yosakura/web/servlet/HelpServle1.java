package com.yosakura.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelpServle1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 客户端第一次请求服务器()
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1.服务器端如何向客户端发送cookie
		// 新建一个cookie
		Cookie cookie1 = new Cookie("id","1234567");
		// expiry 事件单位是秒数
		cookie1.setMaxAge(60); 
		Cookie cookie2 = new Cookie("name","admin");
		// -1 会话级别(关闭浏览器失效)
		cookie2.setMaxAge(-1);
		Cookie cookie3 = new Cookie("sex","M");
		// 不保存
		cookie3.setMaxAge(0);
		// 将cookie添加到响应头中
		resp.setContentType("text/html;charset=utf-8");
		resp.addCookie(cookie1);
		resp.addCookie(cookie2);
		resp.addCookie(cookie3);
		resp.getWriter().write("第一次访问服务器");
	}
	
}
