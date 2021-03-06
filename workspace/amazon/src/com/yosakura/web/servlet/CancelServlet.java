package com.yosakura.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/cancel")
public class CancelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 注销只需要将session域中的登录成功后的用户移除即可;
		HttpSession session = req.getSession(false);
		if (session == null || session.getAttribute("loginUser")==null) {
			resp.getWriter().write("<script type='text/javascript'>alert('未登录不能注销')</script>");
			resp.setHeader("refresh","1;url=index.jsp");
		}else {
			// 从session中删除属性对
			session.removeAttribute("loginUser");
			resp.getWriter().write("<script type='text/javascript'>alert('恭喜注销成功')</script>");
			resp.setHeader("refresh","1;url=index.jsp");
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}