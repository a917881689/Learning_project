package com.yosakura.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yosakura.entity.User;
import com.yosakura.service.impl.UserServiceImpl;

@WebServlet("/queryUserByVeryCode")
public class QueryUserByVeryCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1.获取ajax请求验证码
		String veryCode = req.getParameter("veryCode");
		if (veryCode == null || "".equals(veryCode)) {
			System.out.println(1);
			resp.getWriter().write("error");
			return;
		}
		// 3.对比session域中的值
		String sin_veryCode = (String)req.getSession().getAttribute("veryCode");
		if (sin_veryCode == null || "".equals(veryCode)) {
			System.out.println(2);
			resp.getWriter().write("error");
			return;
		}
		String info = null;
		sin_veryCode = sin_veryCode.toLowerCase();
		veryCode = veryCode.toLowerCase();
		if (sin_veryCode.equals(veryCode)) {
			info = "use";
		}else {
			info = "unuse";	
		}
		// 3.根据查询的结果来返回响应
		resp.getWriter().write(info);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}