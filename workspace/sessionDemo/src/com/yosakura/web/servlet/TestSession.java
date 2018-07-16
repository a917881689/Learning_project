package com.yosakura.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/testSession")
public class TestSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		// 讲解的是Session的工作原理（自动发送Cookie(“JSESSION”,服务器session的id)）
		// 
		// req.getSession() req.getSession(true) 先从服务器找有没有请求中的cookie匹配到的session,若有就返回此session,没有就新建一个
		// req.getSession(false) 先从服务器找有没有请求中的cookie匹配到的session,若有就返回此session,没有返回null
		HttpSession session = req.getSession();
		System.out.println("服务器的id:"+session.getId());
		// 转发或者重定向都可以
		req.getRequestDispatcher("index.html").forward(req,resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}