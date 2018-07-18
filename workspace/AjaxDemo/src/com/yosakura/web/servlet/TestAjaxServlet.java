package com.yosakura.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/testAjax")
public class TestAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1.异步请求的参数
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		System.out.println(uname+":"+pwd);
		// 2.向客户端返回响应（无需使用转发和重定向）
		resp.setContentType("text/htm;charset=UTF-8");
		resp.getWriter().write("测试Ajax");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}