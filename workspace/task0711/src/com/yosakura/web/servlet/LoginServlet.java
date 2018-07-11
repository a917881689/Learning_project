package com.yosakura.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yosakura.entity.User;
import com.yosakura.service.impl.UserServiceImpl;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	public void init() throws ServletException {
		System.out.println("初始化");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 登录
		req.setCharacterEncoding("UTF-8"); 
		resp.setContentType("text/html;charset=UTF-8");
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		String utype = req.getParameter("utype");
		if (uname == null || "".equals(uname) || pwd == null || "".equals(pwd) || utype == null || "".equals(utype)) {
			resp.getWriter().write("<script type='text/javascript'>alert('信息不完整')</script>");
			resp.setHeader("refresh", "1;url=loginUI.html");
			return;
		}
		User user = new User(uname, pwd,Integer.parseInt(utype));
		UserServiceImpl usi = new UserServiceImpl();
		user = usi.login(user);
		if (user != null) {
			resp.getWriter().write("<script type='text/javascript'>alert('登录成功')</script>");
			resp.setHeader("refresh", "1;url=productView.html");
		}else {
			resp.getWriter().write("<script type='text/javascript'>alert('登录失败,用户名或者密码或身份错误')</script>");
			resp.setHeader("refresh", "1;url=loginUI.html");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
