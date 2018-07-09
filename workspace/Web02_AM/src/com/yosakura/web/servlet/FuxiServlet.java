package com.yosakura.web.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FuxiServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Servlet 初始化");
		ServletContext context = config.getServletContext();
		String driver = context.getInitParameter("driver");
		System.out.println(driver);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("get请求");
		// 获取 ServletContest 的方法二		
		ServletContext context = req.getServletContext();
		String driver = context.getInitParameter("driver");
		System.out.println(driver);
		// ServletContest 可以获取工程中任意资源的相对于服务器的绝对路径
		String realpath = context.getRealPath("index.html");
		System.out.println(realpath);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Post请求");
	}
}
