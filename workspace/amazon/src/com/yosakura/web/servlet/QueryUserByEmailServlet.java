package com.yosakura.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yosakura.entity.User;
import com.yosakura.service.impl.UserServiceImpl;

@WebServlet("/queryUserByEmail")
public class QueryUserByEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1.获取ajax请求邮箱
		String email = req.getParameter("email");
		if (email == null || "".equals(email)) {
			resp.getWriter().write("error");
			return;
		}
		// 2.调用业务逻辑层的验证用户名的接口
		UserServiceImpl usi = new UserServiceImpl();
		User user = usi.queryUserByEmail(email);
		// 3.根据查询的结果来返回响应
		resp.getWriter().write(user==null?"use":"unuse");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}