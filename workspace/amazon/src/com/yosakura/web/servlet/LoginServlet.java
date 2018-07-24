package com.yosakura.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yosakura.entity.User;
import com.yosakura.service.impl.UserServiceImpl;
@WebServlet("/doLogin")
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取登陆参数并非空验证
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		if (uname == null || "".equals(uname) || pwd == null || "".equals(pwd) ) {
			resp.getWriter().write("<script type='text/javascript'>alert('信息不完整')</script>");
			resp.setHeader("refresh","1;url=login.jsp");
			return;
		}
		User user = new User(uname,pwd);
		UserServiceImpl usi = new UserServiceImpl();
		User verifyUser = usi.login(user);
		if (verifyUser != null) {
			// 将登陆成功的用户放入session 用来会话跟踪
			HttpSession session = req.getSession();
			session.setAttribute("loginUser",verifyUser);
			System.out.println("普通用户登录");
			resp.sendRedirect("index.jsp");
		}else {
			resp.getWriter().write("<script type='text/javascript'>alert('用户名或密码错误')</script>");
			resp.setHeader("refresh","1;url=login.jsp");
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
}
