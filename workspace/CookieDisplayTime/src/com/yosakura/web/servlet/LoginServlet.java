package com.yosakura.web.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String time = sdf.format(date);
		// 每次登录都会从cookie中取整个时间
		// 1.将当期时间放入cookie中;
		Cookie[] cookies = req.getCookies();
		String lastTime = null;
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("lastTime".equals(cookie.getName())) {
					lastTime = cookie.getValue();
				}
			}
		}
		resp.setContentType("text/html;charset=utf-8");
		if (lastTime == null) {
			lastTime = time;
		}
		Cookie cookie = new Cookie("lastTime", time);
		resp.addCookie(cookie);
		resp.getWriter().write("您上次登录的时间为："+lastTime);
		
	}
}
